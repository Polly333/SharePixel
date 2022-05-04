package com.beproject.sharepixel;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beproject.sharepixel.models.Story;
import com.beproject.sharepixel.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class AdminHomeFragment extends Fragment {

    ListView admin_feed_lv;
    ArrayList<Story> arrayListStories;
    AdminStoryListAdapter storyListAdapter;
    ProgressDialog mProgrssDialog;
    JSONArray jsonArrayIds;



    public AdminHomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_admin_home, container, false);

        admin_feed_lv = view.findViewById(R.id.admin_feed_lv);


        arrayListStories = new ArrayList<Story>();

        mProgrssDialog = new ProgressDialog(getContext());
        mProgrssDialog.setTitle("News Feed");
        mProgrssDialog.setMessage("Updating News Feed....");

        storyListAdapter = new AdminStoryListAdapter(getContext(),R.layout.admin_feed_single_item,arrayListStories);
        admin_feed_lv.setAdapter(storyListAdapter);


      getLatestNewsFeed();


        return view;
    }



    private void getLatestNewsFeed(){



        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLS.reported_news_feed,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            if(!jsonObject.getBoolean("error")){

                                mProgrssDialog.dismiss();

                                JSONArray jsonObjectStories =  jsonObject.getJSONArray("stories");

                                Log.i("arrayStories",jsonObjectStories.toString());

                                for(int i = 0 ; i<jsonObjectStories.length(); i++){
                                    JSONObject jsonObjectSingleStory = jsonObjectStories.getJSONObject(i);
                                    Log.i("jsonsinglestory",jsonObjectSingleStory.toString());

                                    //BELOW CHANGED
                                    Story story = new Story(jsonObjectSingleStory.getInt("id"),jsonObjectSingleStory.getInt("user_id")
                                            ,jsonObjectSingleStory.getInt("num_of_likes"),jsonObjectSingleStory.getInt("num_of_reports"),jsonObjectSingleStory.getString("image_url")
                                            ,jsonObjectSingleStory.getString("title"),jsonObjectSingleStory.getString("time")
                                            , jsonObjectSingleStory.getString("profile_image"),jsonObjectSingleStory.getString("username"));


                                    arrayListStories.add(story);
                                    //storyListAdapter.add(story);
                                }


                                storyListAdapter.notifyDataSetChanged();

                            }else{

                                Toast.makeText(getContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                                mProgrssDialog.dismiss();
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


        );

        VolleyHandler.getInstance(getContext()).addRequestToQueue(stringRequest);
        // Volley.newRequestQueue(getContext().getApplicationContext()).add(stringRequest);

    }






}