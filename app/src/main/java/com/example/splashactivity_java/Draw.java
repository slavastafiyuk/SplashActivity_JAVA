package com.example.splashactivity_java;
//Canvas_Land
import static com.example.splashactivity_java.Canvas_land.colorList;
import static com.example.splashactivity_java.Canvas_land.current_brush;
import static com.example.splashactivity_java.Canvas_land.pathList;
//Canvas_Port
import static com.example.splashactivity_java.Canvas_port.pathList_port;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

public class Draw extends AppCompatActivity {
    public static Path path = new Path();
    public static Path path_port = new Path();
    public static Paint paint_brush = new Paint();
    public static Paint paint_brush_port = new Paint();
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private float mAccelCurrent;
    private float mAccel;

    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            float mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = (float) (mAccelCurrent - mAccelLast);
            mAccel = mAccel * 0.9f + delta; // perform low-cut filter
            if(findViewById(R.id.paint_port) != null){
                if (mAccel > 27) {
                    pathList_port.clear();
                    path_port.reset();
                }
            }
            if(findViewById(R.id.paint_land) != null){
                if (mAccel > 27) {
                    pathList.clear();
                    colorList.clear();
                    path.reset();
                }
            }

            if(Math.abs(x)>8.8 && Math.abs(x)<10.8){
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            }else if(Math.abs(y)>8.8 && Math.abs(y)<10.8){
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            }else if(Math.abs(z)>8.8 && Math.abs(z)<10.8){
                getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
            }else{
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }
    //-----------------------------------------------------------------PORTRAIT PAINT

    public void apagar(View view) {
        pathList_port.clear();
        path_port.reset();
    }

    //---------------------------------------------------------------LANDSCAPE PAINT

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
        startActivity(new Intent(Draw.this, Setting.class));
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }

}