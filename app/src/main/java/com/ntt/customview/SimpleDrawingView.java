package com.ntt.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by thuatnguyen on 3/12/16.
 */
public class SimpleDrawingView extends View {
    private final ArrayList<Point> circlePoints;
    private Paint drawingPaint;
    private int paintColor = Color.BLACK;

    public SimpleDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupPaint();
        circlePoints = new ArrayList<>();
    }

    private void setupPaint() {
        drawingPaint = new Paint();
        drawingPaint.setColor(paintColor);
        drawingPaint.setAntiAlias(true);
        drawingPaint.setStrokeWidth(5);
        drawingPaint.setStyle(Paint.Style.STROKE);
        drawingPaint.setStrokeJoin(Paint.Join.ROUND);
        drawingPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final float x = event.getX();
        final float y = event.getY();
        circlePoints.add(new Point(Math.round(x), Math.round(y)));
        postInvalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(Point p: circlePoints) {
            canvas.drawCircle(p.x, p.y, 5, drawingPaint);
        }
    }
}
