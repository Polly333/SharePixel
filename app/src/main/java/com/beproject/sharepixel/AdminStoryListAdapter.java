package com.beproject.sharepixel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beproject.sharepixel.models.Story;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdminStoryListAdapter extends ArrayAdapter<Story> {

    private Context mContext;
    ArrayList<Story> storyArrayList;

    public AdminStoryListAdapter(@NonNull Context context, int resource, ArrayList<Story> list) {
        super(context, resource, list);
        this.mContext = context;

    }


    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Story getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(@Nullable Story item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {

            LayoutInflater li = LayoutInflater.from(mContext);
            view = li.inflate(R.layout.admin_feed_single_item, null);
        }

        Story story = getItem(position);
        if (story != null) {
            CircleImageView profile_photo = (CircleImageView) view.findViewById(R.id.profile_photo);
            SquareImageView story_image = view.findViewById(R.id.story_image);
            TextView username = view.findViewById(R.id.username_tv);
            TextView number_of_likes = view.findViewById(R.id.num_of_likes);
            TextView tage = view.findViewById(R.id.image_tags);
            TextView date = view.findViewById(R.id.image_time);
            final ImageView redHeart = view.findViewById(R.id.red_heart);
            final ImageView redReport = view.findViewById(R.id.red_report); // report
            TextView number_of_reports = view.findViewById(R.id.num_of_reports); // report


            // Picasso.get().load(story.getProfile_image()).error(R.drawable.user).into(profile_photo); //extra added
            //Picasso.get().load(story.getStory_image()).error(R.drawable.user).into(story_image); //extra added


            if (story.getProfile_image().isEmpty()) {
                profile_photo.setImageResource(R.drawable.user);
            } else {
                Picasso.get().load(story.getProfile_image()).error(R.drawable.user).into(profile_photo);
            }
            if (story.getStory_image().isEmpty()) {
                profile_photo.setImageResource(R.drawable.user);
            } else {
                Picasso.get().load(story.getStory_image()).error(R.drawable.user).into(story_image);
            }

            username.setText(story.getUsername());
            number_of_likes.setText(story.getLike() + " likes");

            number_of_reports.setText(story.getReport() + " reports"); //report

            tage.setText(story.getTitle());
            date.setText(story.getTime());


            int story_id = story.getId();

            Button remove_btn = (Button) view.findViewById(R.id.remove_btn);

            //onClick listener
            remove_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    removeReportedStory(story_id);

                }
            });



        }


        return view;
    }

    private void removeReportedStory(int story_id) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLS.remove_story+story_id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObject = new JSONObject(response);

                            if(!jsonObject.getBoolean("error")){

                                String message = jsonObject.getString("message");

                                Log.i("removeStory",message);



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












}