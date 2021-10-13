package com.example.splashactivity_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Paint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        ////Portrait mode
        if(findViewById(R.id.paint_default) != null){
            Button btnCanvas = findViewById(R.id.canvasButton);
            btnCanvas.setOnClickListener(v -> replaceFragment(new Canvas()));
            Button btnPalette = findViewById(R.id.paletteButton);
            btnPalette.setOnClickListener(v -> replaceFragment(new Palette()));
        }
        ////landscape mode
        //if(findViewById(R.id.paint_land) != null){
        //    FragmentManager manager = this.getSupportFragmentManager();
        //    manager.beginTransaction()
        //            //.show(manager.findFragmentById(R.id.fragmentID))
        //            //.show(manager.findFragmentById(R.id.fragmnetID))
        //            .commit();
        //}



    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}