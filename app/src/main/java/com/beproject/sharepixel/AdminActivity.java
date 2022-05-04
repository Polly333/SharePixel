package com.beproject.sharepixel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beproject.sharepixel.models.User;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class AdminActivity extends AppCompatActivity {


    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mActionDrawerToggle;
    NavigationView mNavigationView;
    User user;
    String mImageProfile,mEmail,mUsername ;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //layout variables
        mDrawerLayout = findViewById(R.id.admin_drawer_layout);
        mNavigationView = findViewById(R.id.admin_nav_view);


        mActionDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mActionDrawerToggle);
        mActionDrawerToggle.syncState();

        // assigning ID of the toolbar to a variable
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);

        //changed as keeps throws NULLPOINTEXCEPTION
        //if(getSupportActionBar() != null) {
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // assigning ID of the toolbar to a variable
        // toolbar = (Toolbar) findViewById(R.id.my_toolbar);

        // using toolbar as ActionBar
        setSupportActionBar(toolbar); //set


        ActionBar actionbar = getSupportActionBar(); //get
        //actionbar.setTitle("SharePixel");
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_home_menu);


        // }






        //user = SharedPreferenceManager.getInstance(this).getUserData();

        Log.i("oncreate","create");




        //Default fragment to be displayed
        changeFragmentDisplay(R.id.admin_home);


        //Listener for navigation view
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                changeFragmentDisplay(item.getItemId());
                return true;
            }
        });

    }

    private void changeFragmentDisplay(int item){

        Fragment fragment = null;

        if(item == R.id.admin_home)
        {
            fragment = new AdminHomeFragment();

        }

        else if(item == R.id.admin_log_out){

            logUserOutIFTheyWant();


        }
        else {
            Toast.makeText(AdminActivity.this , "Error", Toast.LENGTH_LONG).show();

        }

        //Hiding Navigation Drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);




        if(fragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.admin_fragment_content,fragment);
            ft.commit();

        }



    }


    private void logUserOutIFTheyWant(){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log Out");
        builder.setMessage("Are you sure you want to log out?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                /*SharedPreferenceManager sharedPrefrenceManger = SharedPreferenceManager.getInstance(getApplicationContext());
                sharedPrefrenceManger.logUserOut();*/
                startActivity(new Intent(AdminActivity.this,LoginActivity.class));
                dialog.dismiss();


            }
        });


        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mActionDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    /*@Override
    protected void onStart() {
        super.onStart();

        boolean isUserLoggedIn = SharedPreferenceManager.getInstance(getApplicationContext()).isUserLoggedIn();

        if (!isUserLoggedIn) {
            startActivity(new Intent(AdminActivity.this , LoginActivity.class));
        }
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onpause","pause");

    }


    /*@Override
    protected void onResume() {
        super.onResume();
        Log.i("onresume","resume");

        boolean isUserLoggedIn = SharedPreferenceManager.getInstance(getApplicationContext()).isUserLoggedIn();

        if (!isUserLoggedIn) {
            //  startActivity(new Intent(MainActivity.this, LoginActivity.class));
        } else {
            getUserData();

        }



    }*/


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onrestart","restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onstop","stop");
    }













}