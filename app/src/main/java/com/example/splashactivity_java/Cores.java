package com.example.splashactivity_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Cores extends AppCompatActivity {
    Button vermelhobutton, verdebutton, azulbutton, roxobutton, rosabutton, laranjabutton, cinzentobutton;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cores);
        //Associar id de butões a variaveis
        vermelhobutton = findViewById(R.id.VERMELHO);
        verdebutton = findViewById(R.id.VERDE);
        azulbutton = findViewById(R.id.AZUL);
        roxobutton = findViewById(R.id.ROXO);
        rosabutton = findViewById(R.id.ROSA);
        laranjabutton = findViewById(R.id.LARANJA);
        cinzentobutton = findViewById(R.id.CINZENTO);
        //layout
        layout = findViewById(R.id.EcraCores);
        //Butões com mudança de cor
        vermelhobutton.setOnClickListener(v -> layout.setBackgroundColor(Color.RED));
        verdebutton.setOnClickListener(v -> layout.setBackgroundColor(Color.GREEN));
        azulbutton.setOnClickListener(v -> layout.setBackgroundColor(Color.BLUE));
        roxobutton.setOnClickListener(v -> layout.setBackgroundColor(Color.rgb(128,0,128)));
        rosabutton.setOnClickListener(v -> layout.setBackgroundColor(Color.rgb(255,192,203)));
        laranjabutton.setOnClickListener(v -> layout.setBackgroundColor(Color.rgb(255, 140, 0)));
        cinzentobutton.setOnClickListener(v -> layout.setBackgroundColor(Color.rgb(128, 128, 128)));
    }
}