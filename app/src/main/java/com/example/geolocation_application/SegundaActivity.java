package com.example.geolocation_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.geolocation_application.adapters.UsuarioAdapter;
import com.example.geolocation_application.model.Usuario;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SegundaActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        TextView tv = findViewById(R.id.textView2);


        //tv.setText(getIntent().getStringExtra("mensagem"));


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/users";

        // Request a string response from the provided URL.
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url, null,this, this);


        // Add the request to the RequestQueue.
        queue.add(request);


    }

    @Override
    public void onResponse(JSONArray response) {


        List<Usuario> lista = new ArrayList<>();


        for (int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());

                lista.add(new Usuario(response.getJSONObject(i).getInt("id"),
                        response.getJSONObject(i).getString("email"),
                        "1234", response.getJSONObject(i).getString("name")));



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        UsuarioAdapter uAdapt = new UsuarioAdapter(lista);

        RecyclerView rv = findViewById(R.id.rvUsuarios);
        RecyclerView rv2 = findViewById(R.id.rvUsuarios2);
        rv.setAdapter(uAdapt);
        rv2.setAdapter(uAdapt);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        LinearLayoutManager llm2 = new LinearLayoutManager(this);//,LinearLayoutManager.HORIZONTAL,false);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
//        rv.setLayoutManager(llm);
        rv.setLayoutManager(llm);
        rv2.setLayoutManager(llm2);
//        rv.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}