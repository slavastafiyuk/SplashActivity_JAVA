package com.example.splashactivity_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Load extends AppCompatActivity {
    Thread timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        timer = new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (this){
                        wait(1000);
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Load.this, Iniciar.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}