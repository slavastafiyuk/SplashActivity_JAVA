package com.example.splashactivity_java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //Butões
        Button btnCores = findViewById(R.id.colorButton);
        btnCores.setOnClickListener(v -> startActivity(new Intent(Settings.this, Cores.class)));
        Button btnStart = findViewById(R.id.faqButton);
        btnStart.setOnClickListener(v -> startActivity(new Intent(Settings.this, FAQ.class)));
        Button btnPaint = findViewById(R.id.paintButton);
        btnPaint.setOnClickListener(v -> startActivity(new Intent(Settings.this, Draw.class)));
        Button btnMap = findViewById(R.id.mapButton);
        btnMap.setOnClickListener(v -> startActivity(new Intent(Settings.this, MAP.class)));

    }
}