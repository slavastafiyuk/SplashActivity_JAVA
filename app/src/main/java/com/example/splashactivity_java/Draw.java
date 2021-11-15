package com.example.splashactivity_java;
//Canvas_Land
import static com.example.splashactivity_java.Canvas_land.colorList;
import static com.example.splashactivity_java.Canvas_land.current_brush;
import static com.example.splashactivity_java.Canvas_land.pathList;
import static com.example.splashactivity_java.Canvas_port.pathList_port;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Draw extends AppCompatActivity implements SensorEventListener{
    public static Path path = new Path();
    public static Path path_port = new Path();
    public static Paint paint_brush = new Paint();
    public static Paint paint_brush_port = new Paint();
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private float mAccelCurrent;
    private float mAccel;
    Button buttonApagar;
    Button buttonPincel;

    TextView textView;
    SensorManager senManager;
    Sensor sensor;

    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            float mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt(x*x + y*y + z*z);
            float delta = mAccelCurrent - mAccelLast;
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
            if(Math.abs(x)>9.65 && Math.abs(x)<9.95){
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            }else if(Math.abs(y)>9.65 && Math.abs(y)<9.95){
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            }else if(Math.abs(z)>9.65 && Math.abs(z)<9.95){
                getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
            }
            //else{
            //    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            //}
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        textView = findViewById(R.id.textView2);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        senManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = senManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        buttonApagar = findViewById(R.id.apagarButton);
        buttonPincel = findViewById(R.id.ButtonPincel);

        if(findViewById(R.id.paint_port) != null){
            buttonApagar.setOnTouchListener(new View.OnTouchListener() {
                final GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public void onLongPress(MotionEvent e) {
                        if (paint_brush_port.getStrokeWidth()==10f){
                            paint_brush_port.setStrokeWidth(40f);
                        }else{
                            paint_brush_port.setStrokeWidth(10f);
                        }
                        super.onLongPress(e);
                    }

                    @Override
                    public boolean onDoubleTap(MotionEvent e) {
                        getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                        return super.onDoubleTap(e);
                    }

                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        pathList_port.clear();
                        path_port.reset();
                        return super.onSingleTapConfirmed(e);
                    }
                });
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    gestureDetector.onTouchEvent(event);
                    return false;
                }
            });
        }
        if(findViewById(R.id.paint_land) != null){
            buttonPincel.setOnTouchListener(new View.OnTouchListener() {
                final GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public void onLongPress(MotionEvent e) {
                        if (paint_brush.getStrokeWidth()==10f){
                            paint_brush.setStrokeWidth(20f);
                        }else{
                            paint_brush.setStrokeWidth(10f);
                        }
                        super.onLongPress(e);
                    }

                    @Override
                    public boolean onDoubleTap(MotionEvent e) {
                        getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                        return super.onDoubleTap(e);
                    }

                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        paint_brush.setColor(Color.BLACK);
                        currentColor(paint_brush.getColor());
                        return super.onSingleTapConfirmed(e);
                    }
                });
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    gestureDetector.onTouchEvent(event);
                    return false;
                }
            });
        }
    }
    //-----------------------------------------------------------------PORTRAIT PAINT
    //public void apagar(View view) {
    //    pathList_port.clear();
    //    path_port.reset();
    //}
    //---------------------------------------------------------------LANDSCAPE PAINT
    //public void pencil(View view) {
    //    paint_brush.setColor(Color.BLACK);
    //    currentColor(paint_brush.getColor());
    //}
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
        senManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
        senManager.unregisterListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(findViewById(R.id.paint_port) != null) {
            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                textView.setText("" + event.values[0]);
                if (event.values[0]>=10) {
                    ContentResolver cResolver = this.getApplicationContext().getContentResolver();
                    Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, 255);
                }else if (event.values[0]<10) {
                    ContentResolver cResolver = this.getApplicationContext().getContentResolver();
                    Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, 0);
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}