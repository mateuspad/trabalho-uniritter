package com.example.geolocation_application;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.geolocation_application.adapters.PhotosAdapter;
import com.example.geolocation_application.model.Photos;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class QuartaActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarta);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/photos";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        queue.add(request);
    }

    @Override
    public void onResponse(JSONArray response) {
        List<Photos> list = new ArrayList<>();

        for(int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());

                list.add(new Photos(response.getJSONObject(i).getInt("albumId"),
                        response.getJSONObject(i).getInt("id"),
                        response.getJSONObject(i).getString("title"),
                        response.getJSONObject(i).getString("url"),
                        response.getJSONObject(i).getString("thumbnailUrl")));
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }

        PhotosAdapter pAdapter = new PhotosAdapter(list);
        RecyclerView rv = findViewById(R.id.rvPhoto);
        rv.setAdapter(pAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rv.setLayoutManager(llm);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
    }
}
