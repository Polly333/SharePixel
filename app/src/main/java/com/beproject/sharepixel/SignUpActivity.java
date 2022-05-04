package com.beproject.sharepixel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beproject.sharepixel.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    EditText email_et, username_et,password_et,password_confirm_et;
    Button sign_up_btn;
    TextView go_to_login_btn;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //SignUp design varibales
        email_et = (EditText) findViewById(R.id.user_email);
        username_et = (EditText) findViewById(R.id.user_name);
        password_et = (EditText) findViewById(R.id.user_password);
        password_confirm_et = (EditText) findViewById(R.id.user_password_confirm);
        sign_up_btn =  (Button) findViewById(R.id.sign_up_btn);
        go_to_login_btn = (TextView) findViewById(R.id.go_to_login_btn);
        mProgressDialog = new ProgressDialog(this);


        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        go_to_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });

    }

    private void register(){


        mProgressDialog.setTitle("Creating your account");
        mProgressDialog.setMessage("Please wait!!....");
        mProgressDialog.show();

        final String email = email_et.getText().toString();
        final String username = username_et.getText().toString();
        final String password = password_et.getText().toString();
        String password_confirm = password_confirm_et.getText().toString();


        if(!email.contains("@")){
            email_et.setError("This is not a valid email");
            email_et.requestFocus();
            mProgressDialog.dismiss();
            return;
        }
        if(TextUtils.isEmpty(username)){
            username_et.setError("Please fill in this field");
            username_et.requestFocus();
            mProgressDialog.dismiss();
            return;
        }

        if(TextUtils.isEmpty(password)){
            password_et.setError("Please fill in this field");
            password_et.requestFocus();
            mProgressDialog.dismiss();
            return;
        }

        if(TextUtils.isEmpty(password_confirm)){
            password_confirm_et.setError("Please fill in this field");
            password_confirm_et.requestFocus();
            mProgressDialog.dismiss();
            return;
        }

        if(!password.equals(password_confirm)){
            password_et.setError("Password don't match!");
            password_et.requestFocus();
            mProgressDialog.dismiss();
            return;

        }


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLS.sign_up_api,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            if(!jsonObject.getBoolean("error")){
                                mProgressDialog.dismiss();

                                JSONObject jsonObjectUser =  jsonObject.getJSONObject("user");

                                User user = new User(jsonObjectUser.getInt("id"),jsonObjectUser.getString("email"),jsonObjectUser.getString("username")
                                   ,jsonObjectUser.getString("image") );


                                //store user data inside sharedprefrences

                                SharedPreferenceManager.getInstance(getApplicationContext()).storeUserData(user);

                                //let user in
                                finish();
                                startActivity(new Intent(SignUpActivity.this,MainActivity.class));

                            }else{

                                Toast.makeText(SignUpActivity.this,jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                            }


                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignUpActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                        mProgressDialog.dismiss();
                    }
                }


        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> authenticationVariables = new HashMap<>();
                authenticationVariables.put("email",email);
                authenticationVariables.put("username",username);
                authenticationVariables.put("password",password);
                return  authenticationVariables;
            }
        };//end of string Request

        VolleyHandler.getInstance(getApplicationContext()).addRequestToQueue(stringRequest);

    }

    @Override
    protected void onStart() {
        super.onStart();

        boolean isUserLoggedIn = SharedPreferenceManager.getInstance(getApplicationContext()).isUserLoggedIn();

        if (isUserLoggedIn) {
            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
        }
    }


}