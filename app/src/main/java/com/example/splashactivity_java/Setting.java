package com.example.splashactivity_java;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import android.provider.Settings;

import androidx.appcompat.app.AppCompatActivity;

public class Setting extends AppCompatActivity {

    private SeekBar seekBar;
    private int brightness;
    private ContentResolver contentResolver;
    private Window window;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        seekBar = findViewById(R.id.seekbar);
        contentResolver = getContentResolver();
        window = getWindow();

        seekBar.setMax(255);
        seekBar.setKeyProgressIncrement(1);

        try {
            brightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS);
            seekBar.setProgress(brightness);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                brightness = progress;
                Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
                WindowManager.LayoutParams layoutParams = window.getAttributes();
                layoutParams.screenBrightness=brightness/(float)300;
                window.setAttributes(layoutParams);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        //Butões
        Button btnCores = findViewById(R.id.colorButton);
        btnCores.setOnClickListener(v -> startActivity(new Intent(Setting.this, Cores.class)));
        Button btnStart = findViewById(R.id.faqButton);
        btnStart.setOnClickListener(v -> startActivity(new Intent(Setting.this, FAQ.class)));
        Button btnPaint = findViewById(R.id.paintButton);
        btnPaint.setOnClickListener(v -> startActivity(new Intent(Setting.this, Draw.class)));
        Button btnMap = findViewById(R.id.mapButton);
        btnMap.setOnClickListener(v -> startActivity(new Intent(Setting.this, MAP.class)));

    }
}