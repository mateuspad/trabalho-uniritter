package com.example.geolocation_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.geolocation_application.adapters.UsuarioAdapter;
import com.example.geolocation_application.model.Usuario;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class SegundaActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/users";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,this, this);
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
                        response.getJSONObject(i).getString("userName"),
                        response.getJSONObject(i).getString("email")
                ));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        UsuarioAdapter uAdapt = new UsuarioAdapter(lista);

        RecyclerView rv = findViewById(R.id.rvUsuarios);
        rv.setAdapter(uAdapt);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        rv.setLayoutManager(llm);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}