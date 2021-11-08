package com.example.splashactivity_java;
//Canvas_Land
import static com.example.splashactivity_java.Canvas_land.colorList;
import static com.example.splashactivity_java.Canvas_land.current_brush;
import static com.example.splashactivity_java.Canvas_land.pathList;
//Canvas_Port
import static com.example.splashactivity_java.Canvas_port.pathList_port;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import android.widget.Toast;

public class Draw extends AppCompatActivity {
    public static Path path = new Path();
    public static Path path_port = new Path();
    public static Paint paint_brush = new Paint();
    public static Paint paint_brush_port = new Paint();
    private SensorManager mSensorManager;
    private SensorManager SensorManager;
    private Sensor mAccelerometer;
    private Sensor gyroscopeSensor;
    private SensorEventListener gyroscopeEventListener;
    private float mAccelCurrent;
    private float mAccel;
    //private Gyroscope gyroscope;

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
        SensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscopeSensor = SensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if(gyroscopeSensor == null){
            Toast.makeText(this, "Não é possivel visualizar o Gyroscope neste dispositivo", Toast.LENGTH_SHORT).show();
            finish();
        }

        gyroscopeEventListener = new SensorEventListener() {
           @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
              // listener.onRotation(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);

               if(sensorEvent.values[2] > 1.57f){
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }else if(sensorEvent.values[2] < -1.57f){
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        /*gyroscope=new Gyroscope(this);
        gyroscope.setListener(new Gyroscope.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
                if(rz > 1.0f){
                    findViewById(R.id.paint_land).setBackgroundColor(Color.GREEN);
                    findViewById(R.id.paint_port).setBackgroundColor(Color.GREEN);
                }else if(rz < -1.0f){
                    findViewById(R.id.paint_land).setBackgroundColor(Color.YELLOW);
                    findViewById(R.id.paint_port).setBackgroundColor(Color.YELLOW);
                }
            }
        });*/



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
        startActivity(new Intent(Draw.this, Settings.class));
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        SensorManager.registerListener(gyroscopeEventListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_FASTEST);
        //gyroscope.register();
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
        SensorManager.unregisterListener(gyroscopeEventListener);
        //gyroscope.unregister();
    }

}