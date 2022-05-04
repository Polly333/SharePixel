package com.beproject.sharepixel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beproject.sharepixel.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NewPostActivity extends AppCompatActivity {

    Button upload_btn;
    ImageView result_iv; //Edited photo will be displayed
    Bitmap bitmap; // resultant bitmap of edited photo
    String mStoryTitle,imageToString,mProfileImage;
    //boolean OkToUpload;

    Uri outputUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        //variables
        upload_btn = (Button) findViewById(R.id.upload_btn);
        result_iv =  (ImageView) findViewById(R.id.result_iv);

        outputUri = getIntent().getData();

       //convert uri to bitmap
       try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),outputUri); //no need of GetContext for Activity, it is only for FRAGMENT

            if(bitmap != null){

                result_iv.setImageBitmap(bitmap); //SHOWING THE EDITED IMAGE IN THE IMAGE VIEW

                Log.i("bitmap",bitmap.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        result_iv.setImageBitmap(bitmap);









        //onClick listener
        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                storyAndImageTitle();

            }
        });





    }


    private void storyAndImageTitle(){

        final EditText editText = new EditText(this); //Changed from getContext() to this , as this is an ACTIVITY NOT FRAGment
        editText.setTextColor(Color.BLACK);
        editText.setHint("Set Title/Tags for story");
        editText.setHintTextColor(Color.GRAY);

        AlertDialog.Builder builder = new AlertDialog.Builder(this); //Changed from getContext() to this , as this is an ACTIVITY NOT FRAGment
        builder.setTitle("Story Title");
        builder.setCancelable(false);
        builder.setView(editText);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                //if(OkToUpload) {
                    mStoryTitle = editText.getText().toString();
                    imageToString = convertImageToString(); // IMPP
                    uploadStory();
               // }else{
                   // Toast.makeText(NewPostActivity.this,"Please take a photo first!",Toast.LENGTH_LONG).show(); // Changed to NewPostActivity.this
               // }



            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();





    }



   private String convertImageToString(){

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos); //Bitmap Converted to String
        byte[] imageByteArray = baos.toByteArray();
        String result =  Base64.encodeToString(imageByteArray,Base64.DEFAULT);

        return result;


    }



    private void uploadStory(){

      /*
        if(!OkToUpload){
            Toast.makeText(getContext(),"There is no image to upload!",Toast.LENGTH_LONG).show();

            return;
        }
           */

        //final String dateOfImage = dateOfImage();
        //final String currentTime = currentReadableTime();
        User user = SharedPreferenceManager.getInstance(this).getUserData(); //changed , is it correct for activity
        final String username = user.getUsername();
        final int user_id = user.getId();
        final String profile_image = mProfileImage;


        final ProgressDialog mProgrssDialog =  new ProgressDialog(this); //Changed
        mProgrssDialog.setTitle("Uploading Story");
        mProgrssDialog.setMessage("Please wait....");
        mProgrssDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLS.upload_story_image,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            if(!jsonObject.getBoolean("error")){
                                mProgrssDialog.dismiss();



                                Toast.makeText(NewPostActivity.this,"story uploaded successfully!",Toast.LENGTH_LONG).show(); //Changed


                                //below 3 lines are to take back to home page after photo uploaded successfully , how to do in Activity?
                              //  FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                              //  ft.replace(R.id.main_fragment_content,new HomeFragment());
                              //  ft.commit();


                            }else{

                                Toast.makeText(NewPostActivity.this,jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                            }


                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NewPostActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                        mProgrssDialog.dismiss();
                    }
                }


        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> imageMap = new HashMap<>();
               // imageMap.put("image_name",dateOfImage); //handles case if same images uploaded , to keep uniqueness
                imageMap.put("image_encoded",imageToString); //imageToString variable has the final image to be uploaded to server
                imageMap.put("title",mStoryTitle);
               // imageMap.put("time",currentTime);
                imageMap.put("username",username);
                imageMap.put("user_id",String.valueOf(user_id));
                imageMap.put("profile_image", profile_image);
                return  imageMap;
            }
        };//end of string Request

        VolleyHandler.getInstance(getApplicationContext()).addRequestToQueue(stringRequest); //changed

        //OkToUpload = false;


    }







}