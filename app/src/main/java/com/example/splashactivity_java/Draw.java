package com.example.splashactivity_java;

import static com.example.splashactivity_java.Canvas_land.colorList;
import static com.example.splashactivity_java.Canvas_land.current_brush;
import static com.example.splashactivity_java.Canvas_land.pathList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Draw extends AppCompatActivity {
    public static Path path = new Path();
    public static Paint paint_brush = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        //Portrait mode
        if(findViewById(R.id.paint_default) != null){
            Button btnCanvas = findViewById(R.id.canvasButton);
            btnCanvas.setOnClickListener(v -> replaceFragment(new Canvas()));
            Button btnPalette = findViewById(R.id.paletteButton);
            btnPalette.setOnClickListener(v -> replaceFragment(new Palette()));
        }
        //landscape mode
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

    public void pencil(View view) {
        paint_brush.setColor(Color.BLACK);
        currentColor(paint_brush.getColor());
    }

    public void eraser(View view) {
        pathList.clear();
        colorList.clear();
        path.reset();
    }

    public void redColor(View view) {
        paint_brush.setColor(Color.RED);
        currentColor(paint_brush.getColor());
    }

    public void yellowColor(View view) {
        paint_brush.setColor(Color.YELLOW);
        currentColor(paint_brush.getColor());
    }

    public void greenColor(View view) {
        paint_brush.setColor(Color.GREEN);
        currentColor(paint_brush.getColor());
    }

    public void magentaColor(View view) {
        paint_brush.setColor(Color.MAGENTA);
        currentColor(paint_brush.getColor());
    }

    public void blueColor(View view) {
        paint_brush.setColor(Color.BLUE);
        currentColor(paint_brush.getColor());
    }

    public void currentColor(int c){
        current_brush = c;
        path = new Path();
    }

    public void voltar(View view) {
        startActivity(new Intent(Draw.this, Settings.class));
    }
}