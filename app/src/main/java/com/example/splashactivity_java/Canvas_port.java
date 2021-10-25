package com.example.splashactivity_java;

import static com.example.splashactivity_java.Draw.paint_brush_port;
import static com.example.splashactivity_java.Draw.path_port;

import androidx.annotation.Nullable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Canvas_port extends View {
    public static ArrayList<Path> pathList_port = new ArrayList<>();
    public ViewGroup.LayoutParams params;


    public Canvas_port(Context context) {
        super(context);
        init(context);
    }
    public Canvas_port(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public Canvas_port(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context){
        paint_brush_port.setAntiAlias(true);
        paint_brush_port.setColor(Color.BLACK);
        paint_brush_port.setStyle(Paint.Style.STROKE);
        paint_brush_port.setStrokeCap(Paint.Cap.ROUND);
        paint_brush_port.setStrokeJoin(Paint.Join.ROUND);
        paint_brush_port.setStrokeWidth(10f);
        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path_port.moveTo(x,y);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                path_port.lineTo(x,y);
                pathList_port.add(path_port);
                invalidate();
                return true;
            default:
                return false;
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        for(int i=0;i<pathList_port.size();i++){
            canvas.drawPath(pathList_port.get(i), paint_brush_port);
            invalidate();
        }
    }
}