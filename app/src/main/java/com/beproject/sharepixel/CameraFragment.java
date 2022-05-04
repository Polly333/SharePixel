package com.beproject.sharepixel;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.app.Activity.RESULT_OK;


public class CameraFragment extends Fragment {

    Button capture_btn, upload_btn; //Edit BUTTON --> Changed to upload_btn
    ImageView captured_iv; //To show edited image
    Uri mImageUri,outputUri;
    final int CAPTURE_IMAGE = 1,GALLARY_PICK=2;
    Bitmap bitmap;
    String mStoryTitle,imageToString,mProfileImage;
    boolean OkToUpload;
    public static int count = 0; //added for camera
    String dir; //added for camera


    public CameraFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        capture_btn = (Button) view.findViewById(R.id.capture_btn);
        upload_btn = (Button) view.findViewById(R.id.upload_btn);
        captured_iv = (ImageView) view.findViewById(R.id.captured_iv);

        OkToUpload = false;

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getProfileImage(); //getting profile image

        //added for camera

        dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";
        File newdir = new File(dir);
        if (!newdir.exists()) {
            newdir.mkdir();
        }

       //-------



        capture_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String[] options = {"Choose From Gallery","Take Photo"};
                AlertDialog.Builder build = new AlertDialog.Builder(v.getContext());
                build.setTitle("Choose Image");
                build.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        switch (which) {
                            //choose from gallery
                            case 0:
                                Intent galleryIntent = new Intent();
                                galleryIntent.setType("image/*");
                                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(galleryIntent, "Select Image"), GALLARY_PICK);

                                break;

                            //take a photo using camera
                            case 1:

                                capturePhoto();

                                break;


                        }


                    }
                });

                build.show();






            }
        });


        //onClick listener
        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                storyAndImageTitle();

            }
        });


    }


    private void capturePhoto() {

        // Here, the counter will be incremented each time, and the
        // picture taken by camera will be stored as 1.jpg,2.jpg
        // and likewise.
        count++;
        String file = dir+count+".jpg";
        File newfile = new File(file);
        try {
            newfile.createNewFile();
        }
        catch (IOException e)
        {
        }

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //String imageName = "image.jpg";
        //mImageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), imageName)); //result stored in  mImageUri
        mImageUri = FileProvider.getUriForFile( this.getContext(), BuildConfig.APPLICATION_ID + ".provider", newfile); //context ka pb
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
        startActivityForResult(cameraIntent, CAPTURE_IMAGE);


    }


    //EDITING
    /*private void  editPhoto(){


        // If the input image uri for DS Photo Editor is "mImageUri", launch the editor UI

        // using the following code

        Intent dsPhotoEditorIntent = new Intent( CameraFragment.this.getActivity(), DsPhotoEditorActivity.class);

        dsPhotoEditorIntent.setData(mImageUri);


        // This is optional. By providing an output directory, the edited photo

        // will be saved in the specified folder on your device's external storage;

        // If this is omitted, the edited photo will be saved to a folder

        // named "DS_Photo_Editor" by default.

        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "SHAREPIXEL");

        startActivityForResult(dsPhotoEditorIntent, 200);



    } */




    //Fot both the start ACtivity method


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAPTURE_IMAGE){

            if(resultCode == RESULT_OK){

                if(mImageUri != null){

                    //convert uri to bitmap
                   /* try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),mImageUri);

                        if(bitmap != null){

                            captured_iv.setImageBitmap(bitmap); //SHOWING THE ORIGINAL IMAGE IN THE IMAGE VIEW

                            //Log.i("bitmap",bitmap.toString());
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    } */

                    Intent dsPhotoEditorIntent = new Intent( CameraFragment.this.getActivity(), DsPhotoEditorActivity.class);

                    dsPhotoEditorIntent.setData(mImageUri);


                    dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "SHAREPIXEL");

                    startActivityForResult(dsPhotoEditorIntent, 200);




                }

            }

        }




        if(requestCode == GALLARY_PICK){

            if(resultCode == RESULT_OK){


                mImageUri = data.getData(); //gallery selected image ka URI
                if(mImageUri != null) {

                   /* try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);

                        if (bitmap != null) {

                            //OkToUpload =  true;   //ADD LATER
                            captured_iv.setImageBitmap(bitmap);

                            //Log.i("bitmap", bitmap.toString());
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                      */

                    //ADDED FOR EDITING

                   // private void  editPhoto(){


                        // If the input image uri for DS Photo Editor is "mImageUri", launch the editor UI

                        // using the following code

                        Intent dsPhotoEditorIntent = new Intent( CameraFragment.this.getActivity(), DsPhotoEditorActivity.class);

                        dsPhotoEditorIntent.setData(mImageUri);


                        // This is optional. By providing an output directory, the edited photo

                        // will be saved in the specified folder on your device's external storage;

                        // If this is omitted, the edited photo will be saved to a folder

                        // named "DS_Photo_Editor" by default.

                        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "SHAREPIXEL");

                        startActivityForResult(dsPhotoEditorIntent, 200);



                    //}






                }

            }


        }










        //if resultCode wala part not added acc to DsPhoto Editor SDK


        if(requestCode==200){
           // Intent resultIntent = new Intent(CameraFragment.this.getActivity(),NewPostActivity.class);
            outputUri = data.getData();

           // resultIntent.setData(outputUri);
           // startActivity(resultIntent);

            if(outputUri!= null){
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), outputUri);

                    if (bitmap != null) {

                        //OkToUpload =  true;   //ADD LATER
                        OkToUpload = true;
                        captured_iv.setImageBitmap(bitmap);

                        //Log.i("bitmap", bitmap.toString());
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }




        }





    }




    private void storyAndImageTitle(){

        final EditText editText = new EditText(getContext());
        editText.setTextColor(Color.BLACK);
        editText.setHint("Set Title/Tags for post");
        editText.setHintTextColor(Color.GRAY);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Post Title");
        builder.setCancelable(false);
        builder.setView(editText);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                if(OkToUpload) {
                    mStoryTitle = editText.getText().toString();
                    imageToString = convertImageToString();
                    uploadStory();
                }else{
                    Toast.makeText(getContext(),"Please take a photo first!", Toast.LENGTH_LONG).show();
                }



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
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] imageByteArray = baos.toByteArray();
        String result =  Base64.encodeToString(imageByteArray,Base64.DEFAULT);

        return result;


    }



    private void getProfileImage(){


        User user = SharedPreferenceManager.getInstance(getContext()).getUserData();
        int user_id = user.getId();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLS.get_user_data+user_id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            if(!jsonObject.getBoolean("error")){

                                JSONObject jsonObjectUser =  jsonObject.getJSONObject("user");

                                mProfileImage =  jsonObjectUser.getString("image");



                            }else{

                                Toast.makeText(getContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                            }


                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                }


        );

        VolleyHandler.getInstance(getContext().getApplicationContext()).addRequestToQueue(stringRequest);
    }

    private void uploadStory(){


        if(!OkToUpload){
            Toast.makeText(getContext(),"There is no image to upload!",Toast.LENGTH_LONG).show();

            return;
        }


        final String dateOfImage = dateOfImage();
        final String currentTime = currentReadableTime();
        User user = SharedPreferenceManager.getInstance(getContext()).getUserData();
        final String username = user.getUsername();
        final int user_id = user.getId();
        final String profile_image = mProfileImage;


        final ProgressDialog mProgrssDialog =  new ProgressDialog(getContext());
        mProgrssDialog.setTitle("Uploading Post");
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



                                Toast.makeText(getContext(),"Post uploaded successfully!",Toast.LENGTH_LONG).show();

                                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.main_fragment_content,new HomeFragment());
                                ft.commit();


                            }else{

                                Toast.makeText(getContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                            }


                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                        mProgrssDialog.dismiss();
                    }
                }


        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> imageMap = new HashMap<>();
                imageMap.put("image_name",dateOfImage); //should be unique eg 1532262046724
                imageMap.put("image_encoded",imageToString);
                imageMap.put("title",mStoryTitle);
                imageMap.put("time",currentTime); //eg 4/3/2022 18:45:00
                imageMap.put("username",username);
                imageMap.put("user_id",String.valueOf(user_id));
                imageMap.put("profile_image", profile_image);
                return  imageMap;
            }
        };//end of string Request

        VolleyHandler.getInstance(getContext().getApplicationContext()).addRequestToQueue(stringRequest);

        OkToUpload = false;


    }



    private String dateOfImage(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }



    private String currentReadableTime(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());
        return date.toString();


    }
















}