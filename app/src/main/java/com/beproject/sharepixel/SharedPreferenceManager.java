package com.beproject.sharepixel;

import android.content.Context;
import android.content.SharedPreferences;

import com.beproject.sharepixel.models.User;

public class SharedPreferenceManager {

    private static final String FILENAME = "SHAREPIXELLOGIN";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String IMAGE = "image";
    private static final String ID = "id";

    private static SharedPreferenceManager mSharedPreferenceManager;
    private static Context mContext;

    private SharedPreferenceManager(Context context) {
        this.mContext = context;
    }

    public static synchronized SharedPreferenceManager getInstance(Context context){

        if(mSharedPreferenceManager == null){
            mSharedPreferenceManager = new SharedPreferenceManager(context);
        }
        return mSharedPreferenceManager;
    }


    public void updateProfileImage(String imageUrl){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(IMAGE,imageUrl);
        editor.apply();

    }

    public void updateEmail(String email){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMAIL,email);
        editor.apply();

    }




    public void storeUserData(User user){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME,user.getUsername());
        editor.putString(EMAIL,user.getEmail());
        editor.putString(IMAGE,user.getImage());
        editor.putInt(ID,user.getId());
        editor.apply();

    }

    public boolean isUserLoggedIn(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);

        if(sharedPreferences.getString(USERNAME,null) != null){
            return true;
        }

        return false;
    }


    public void logUserOut(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();


    }

    //to use this for displaying user info in the Profile page , rather than calling the database again
    public User getUserData(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        User user = new User(sharedPreferences.getInt(ID,-1),sharedPreferences.getString(EMAIL,null),sharedPreferences.getString(USERNAME,null),sharedPreferences.getString(IMAGE,null));
        return user;
    }


}
