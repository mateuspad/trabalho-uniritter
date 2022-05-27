package com.example.geolocation_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import com.example.geolocation_application.model.Usuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View btn1 = findViewById(R.id.button1);
        View btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
                intent.putExtra("mensagem", "opa, olá ai a mensagem");
                intent.putExtra("qtd", 189);
                Usuario usu = new Usuario(123, "jean", "1234", "Jean Paul");
                intent.putExtra("usuario", usu);
                startActivity(intent);
            }
        });
    }
}