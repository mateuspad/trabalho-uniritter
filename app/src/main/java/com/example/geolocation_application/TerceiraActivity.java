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
import com.example.geolocation_application.adapters.PostsAdapter;
import com.example.geolocation_application.model.Posts;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class TerceiraActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        queue.add(request);
    }

    @Override
    public void onResponse(JSONArray response) {
        List<Posts> list = new ArrayList<>();

        for(int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());

                list.add(new Posts(response.getJSONObject(i).getInt("userId"),
                        response.getJSONObject(i).getInt("id"),
                        response.getJSONObject(i).getString("title"),
                        response.getJSONObject(i).getString("body")));
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }

        PostsAdapter pAdapter = new PostsAdapter(list);
        RecyclerView rv = findViewById(R.id.rvPosts);
        rv.setAdapter(pAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rv.setLayoutManager(llm);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
    }
}
