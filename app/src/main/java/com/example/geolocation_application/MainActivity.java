package com.example.geolocation_application;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View btn1 = findViewById(R.id.button1);
        View btn2 = findViewById(R.id.button2);
        View btn3 = findViewById(R.id.button3);
        View btn4 = findViewById(R.id.button4);
        View btn5= findViewById(R.id.button5);
        View btn6 = findViewById(R.id.button6);
        View btn7 = findViewById(R.id.button7);

        //Muda para o Maps
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
            }
        });

        //Muda para os usuários
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
                startActivity(intent);
            }
        });

        //Muda para Posts
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TerceiraActivity.class);
                startActivity(intent);
            }
        });

        //Muda para Albums
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuartaActivity.class);
                startActivity(intent);
            }
        });

        //Muda para Photos
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuintaActivity.class);
                startActivity(intent);
            }
        });

        //Muda para Todos
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SextaActivity.class);
                startActivity(intent);
            }
        });

        //Muda para Comments
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SetimaActivity.class);
                startActivity(intent);
            }
        });
    }
}