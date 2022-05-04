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

public class LoginActivity extends AppCompatActivity {

    EditText username_et , password_et;
    TextView sign_up_btn; //We can give button functionality to TextView
    Button login_btn;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //login variables
        username_et =(EditText) findViewById(R.id.user_name);
        password_et =(EditText) findViewById(R.id.user_password);
        login_btn = (Button) findViewById(R.id.login_btn);
        sign_up_btn = (TextView) findViewById(R.id.sign_up_btn);
        mProgressDialog =  new ProgressDialog(this);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();
            }
        });

        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //To kill this LoginActivity to free up space and improve perf
                Intent signUpIntent = new Intent(LoginActivity.this , SignUpActivity.class);
                startActivity(signUpIntent);

            }
        });



    }

    private void logIn() {

        mProgressDialog.setTitle("Log In");
        mProgressDialog.setMessage("Please wait!!....");
        mProgressDialog.show();

        String username = username_et.getText().toString(); //ACTUAL USERNAME data in the edit text
        String password = password_et.getText().toString(); //ACTUAL PASSWORD data in the edit text
        String user = "admin";
        String pass = "admin";


        if (TextUtils.isEmpty(username)) {
            username_et.setError("Please fill in this field");
            username_et.requestFocus();
            mProgressDialog.dismiss();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            password_et.setError("Please fill in this field");
            password_et.requestFocus();
            mProgressDialog.dismiss();
            return;
        }

        //admin---
       if (user.equals(username) && pass.equals(password)) {
           startActivity (new Intent(this, AdminActivity.class));
        } else {


            StringRequest stringRequest = new StringRequest(Request.Method.POST, URLS.login_api,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);

                                if (!jsonObject.getBoolean("error")) {
                                    mProgressDialog.dismiss();


                                    JSONObject jsonObjectUser = jsonObject.getJSONObject("user");
                                    User user = new User(jsonObjectUser.getInt("id"), jsonObjectUser.getString("email"), jsonObjectUser.getString("username"), jsonObjectUser.getString("image"));

                                    //store user data inside shared prefrences
                                    SharedPreferenceManager.getInstance(getApplicationContext()).storeUserData(user);

                                    //let user in
                                    finish();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class)); //Moving to Main activity(FEED) after login


                                } else {

                                    Toast.makeText(LoginActivity.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_LONG).show(); //getMessage() puts a custom message from VOLLEY LIB
                            mProgressDialog.dismiss();

                        }
                    }
            ) {

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> authenticationVariables = new HashMap<>();
                    authenticationVariables.put("username", username); // the string inside " " to be used in php script , is the KEy
                    authenticationVariables.put("password", password);
                    return authenticationVariables;
                }
            }; //End of string response


            VolleyHandler.getInstance(getApplicationContext()).addRequestToQueue(stringRequest); //Volley HANDLER

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        boolean isUserLoggedIn = SharedPreferenceManager.getInstance(getApplicationContext()).isUserLoggedIn();

        if (isUserLoggedIn) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    }




    }