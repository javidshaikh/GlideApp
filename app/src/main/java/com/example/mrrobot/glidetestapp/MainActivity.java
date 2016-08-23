package com.example.mrrobot.glidetestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String imgUrl = "https://api.flickr.com/services/rest/?method=flickr.interestingness.getList&api_key=4c66b329cc51b9c428f78bbdf3733aeb&per_page=1&page=1&format=json";

        JsonObjectRequest Data = new JsonObjectRequest(Request.Method.POST,
                imgUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject photo = response.getJSONObject("photos");
                    JSONArray photoarry = photo.getJSONArray("photo");
                    JSONObject pointerone = photoarry.getJSONObject(0);
                    Log.v("Value: ", pointerone.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());


            }
        });


    }
}
