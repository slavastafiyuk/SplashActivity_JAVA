package com.example.splashactivity_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Iniciar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);
        Button btnStart = findViewById(R.id.startButton);
        btnStart.setOnClickListener(v -> startActivity(new Intent(Iniciar.this, Settings.class)));
    }
}