package com.example.splashactivity_java;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Cores extends AppCompatActivity {
    Button vermelhobutton, verdebutton, azulbutton, roxobutton, rosabutton, laranjabutton, cinzentobutton;
    ConstraintLayout layout;
    boolean RED;
    boolean GREEN;
    boolean BLUE;
    boolean ROXO;
    boolean ROSA;
    boolean LARANJA;
    boolean CINZENTO;
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
        vermelhobutton.setOnClickListener(v -> {
            layout.setBackgroundColor(Color.RED);
            RED = true;
            GREEN = false;
            BLUE = false;
            ROXO = false;
            ROSA = false;
            LARANJA = false;
            CINZENTO = false;
        });
        verdebutton.setOnClickListener(v -> {
            layout.setBackgroundColor(Color.GREEN);
            RED = false;
            GREEN = true;
            BLUE = false;
            ROXO = false;
            ROSA = false;
            LARANJA = false;
            CINZENTO = false;
        });
        azulbutton.setOnClickListener(v -> {
            layout.setBackgroundColor(Color.BLUE);
            RED = false;
            GREEN = false;
            BLUE = true;
            ROXO = false;
            ROSA = false;
            LARANJA = false;
            CINZENTO = false;

        });
        roxobutton.setOnClickListener(v -> {
            layout.setBackgroundColor(Color.rgb(128, 0, 128));
            RED = false;
            GREEN = false;
            BLUE = false;
            ROXO = true;
            ROSA = false;
            LARANJA = false;
            CINZENTO = false;
        });
        rosabutton.setOnClickListener(v -> {
            layout.setBackgroundColor(Color.rgb(255, 192, 203));
            RED = false;
            GREEN = false;
            BLUE = false;
            ROXO = false;
            ROSA = true;
            LARANJA = false;
            CINZENTO = false;
        });
        laranjabutton.setOnClickListener(v -> {
            layout.setBackgroundColor(Color.rgb(255, 140, 0));
            RED = false;
            GREEN = false;
            BLUE = false;
            ROXO = false;
            ROSA = false;
            LARANJA = true;
            CINZENTO = false;
        });
        cinzentobutton.setOnClickListener(v -> {
            layout.setBackgroundColor(Color.rgb(128, 128, 128));
            RED = false;
            GREEN = false;
            BLUE = false;
            ROXO = false;
            ROSA = false;
            LARANJA = false;
            CINZENTO = true;
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (RED){
            int red = 255;
            int green = 0;
            int blue = 0;
            outState.putInt("red", red);
            outState.putInt("green", green);
            outState.putInt("blue", blue);
            outState.putBoolean("vermelho", true);
        } else if (GREEN){
            int red = 0;
            int green = 255;
            int blue = 0;
            outState.putInt("red", red);
            outState.putInt("green", green);
            outState.putInt("blue", blue);
        } else if (BLUE){
            int red = 0;
            int green = 0;
            int blue = 255;
            outState.putInt("red", red);
            outState.putInt("green", green);
            outState.putInt("blue", blue);
        }else if (ROXO){
            int red = 128;
            int green = 0;
            int blue = 128;
            outState.putInt("red", red);
            outState.putInt("green", green);
            outState.putInt("blue", blue);
        }else if (ROSA){
            int red = 255;
            int green = 192;
            int blue = 203;
            outState.putInt("red", red);
            outState.putInt("green", green);
            outState.putInt("blue", blue);
        }else if (LARANJA){
            int red = 255;
            int green = 140;
            int blue = 0;
            outState.putInt("red", red);
            outState.putInt("green", green);
            outState.putInt("blue", blue);
        }else if (CINZENTO){
            int red = 128;
            int green = 128;
            int blue = 128;
            outState.putInt("red", red);
            outState.putInt("green", green);
            outState.putInt("blue", blue);
        }else{
            int red = 255;
            int green = 255;
            int blue = 255;
            outState.putInt("red", red);
            outState.putInt("green", green);
            outState.putInt("blue", blue);
        }
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int red = savedInstanceState.getInt("red");
        int green = savedInstanceState.getInt("green");
        int blue = savedInstanceState.getInt("blue");
        layout.setBackgroundColor(Color.rgb(red,green,blue));
        if (red==255 && green==0 && blue ==0  ){
            RED = true;
            GREEN = false;
            BLUE = false;
            ROXO = false;
            ROSA = false;
            LARANJA = false;
            CINZENTO = false;
        }else if (red==0 && green==255 && blue ==0  ){
            RED = false;
            GREEN = true;
            BLUE = false;
            ROXO = false;
            ROSA = false;
            LARANJA = false;
            CINZENTO = false;
        }else if (red==0 && green==0 && blue ==255  ){
            RED = false;
            GREEN = false;
            BLUE = true;
            ROXO = false;
            ROSA = false;
            LARANJA = false;
            CINZENTO = false;
        }else if (red==128 && green==0 && blue ==128  ){
            RED = false;
            GREEN = false;
            BLUE = false;
            ROXO = true;
            ROSA = false;
            LARANJA = false;
            CINZENTO = false;
        }else if (red==255 && green==192 && blue ==203  ){
            RED = false;
            GREEN = false;
            BLUE = false;
            ROXO = false;
            ROSA = true;
            LARANJA = false;
            CINZENTO = false;
        }else if (red==255 && green==140 && blue ==0  ){
            RED = false;
            GREEN = false;
            BLUE = false;
            ROXO = false;
            ROSA = false;
            LARANJA = true;
            CINZENTO = false;
        }else if (red==128 && green==128 && blue ==128  ){
            RED = false;
            GREEN = false;
            BLUE = false;
            ROXO = false;
            ROSA = false;
            LARANJA = false;
            CINZENTO = true;
        }else{
            RED = false;
            GREEN = false;
            BLUE = false;
            ROXO = false;
            ROSA = false;
            LARANJA = false;
            CINZENTO = false;
        }
    }
}