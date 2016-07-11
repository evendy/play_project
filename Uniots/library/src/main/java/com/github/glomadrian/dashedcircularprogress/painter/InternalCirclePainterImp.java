package com.github.glomadrian.dashedcircularprogress.painter;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * @author Adrián García Lomas
 */
public class InternalCirclePainterImp implements InternalCirclePainter {

    private RectF internalCircle;
    private Paint internalCirclePaint;
    private int color;
    private float startAngle = 270;
    private float finishAngle = 360;
    private int width;
    private int height;
    private int internalStrokeWidth = 48;
    private int dashWith = 5;
    private int dashSpace = 5;
    private float marginTop = 45;


    public InternalCirclePainterImp(int color, int progressStrokeWidth) {
        this.color = color;
        if (progressStrokeWidth != -1) internalStrokeWidth = progressStrokeWidth;
        init();
    }

    public InternalCirclePainterImp(int color) {
        this(color, -1);
    }

    private void init() {
        initExternalCirclePainter();
    }

    private void initExternalCirclePainter() {
        internalCirclePaint = new Paint();
        internalCirclePaint.setAntiAlias(true);
        internalCirclePaint.setStrokeWidth(internalStrokeWidth);
        internalCirclePaint.setColor(color);
        internalCirclePaint.setStyle(Paint.Style.STROKE);
        internalCirclePaint.setPathEffect(new DashPathEffect(new float[]{dashWith, dashSpace},
                dashSpace));
    }

    private void initExternalCircle() {
        internalCircle = new RectF();
        float padding = internalStrokeWidth * 1.7f;
        internalCircle.set(padding, padding + marginTop, width - padding, height - padding);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawArc(internalCircle, startAngle, finishAngle, false, internalCirclePaint);
    }

    public void setColor(int color) {
        this.color = color;
        internalCirclePaint.setColor(color);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void onSizeChanged(int height, int width) {
        this.width = width;
        this.height = height;
        initExternalCircle();
    }
}
