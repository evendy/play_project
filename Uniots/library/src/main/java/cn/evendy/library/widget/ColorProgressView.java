package cn.evendy.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import cn.evendy.library.R;

/**
 * Created by evendy .
 */
public class ColorProgressView extends View {
    private int maxProgress = 100;
    private int progress = 0;
    private int circularColor;
    private int progressColor;
    private int hintColor;
    private int contentColor;
    private String hintStr;

    private float circle_width = dipToPx(5);
    private float hint_textsize = dipToPx(20);
    private float content_textsize = dipToPx(15);

    private Paint circularPaint, progressPaint, hintPaint, contetPaint;

    public ColorProgressView(Context context) {
        super(context);
        init(context, null);
    }

    public ColorProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ColorProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        circularColor = getResources().getColor(R.color.circle_color);
        progressColor = getResources().getColor(R.color.progress_color);
        contentColor = hintColor = getResources().getColor(R.color.content_color);

        if (null != attrs) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ColorProgressBar, 0, 0);
            contentColor = a.getColor(R.styleable.ColorProgressBar_content_color, contentColor);
            hintColor = a.getColor(R.styleable.ColorProgressBar_hint_color, hintColor);
            circularColor = a.getColor(R.styleable.ColorProgressBar_circular_color, circularColor);
            progressColor = a.getColor(R.styleable.ColorProgressBar_cur_progress_color, progressColor);
            circle_width = a.getDimension(R.styleable.ColorProgressBar_circle_width, circle_width);
            hint_textsize = a.getDimension(R.styleable.ColorProgressBar_hint_textsize, hint_textsize);
            content_textsize = a.getDimension(R.styleable.ColorProgressBar_content_textsize, content_textsize);

            maxProgress = a.getInt(R.styleable.ColorProgressBar_max_value, maxProgress);
            progress = a.getInt(R.styleable.ColorProgressBar_current_value, progress);
            hintStr = a.getString(R.styleable.ColorProgressBar_string_unit);
            a.recycle();
        }


        initPaint();
    }

    private void initPaint() {
        circularPaint = new Paint();
        circularPaint.setAntiAlias(true);
        circularPaint.setStyle(Paint.Style.STROKE);
        circularPaint.setColor(circularColor);
        circularPaint.setStrokeWidth(circle_width);

        progressPaint = new Paint();
        progressPaint.setAntiAlias(true);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setColor(progressColor);
        progressPaint.setStrokeWidth(circle_width);

        hintPaint = new Paint();
        hintPaint.setAntiAlias(true);
        hintPaint.setColor(hintColor);
        hintPaint.setTextAlign(Paint.Align.CENTER);
        hintPaint.setTextSize(hint_textsize);

        contetPaint = new Paint();
        contetPaint.setAntiAlias(true);
        contetPaint.setColor(contentColor);
        contetPaint.setTextAlign(Paint.Align.CENTER);
        contetPaint.setTextSize(content_textsize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centre = (getWidth() > getHeight() ? getHeight() : getWidth()) / 2;
        int radius = Math.round(centre - circle_width / 2);
        RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius); // 用于定义的圆弧的形状和大小的界限

        //整个弧
        canvas.drawArc(oval, 0, 360, false, circularPaint);
        //当前进度
        float currentAngle = progress * 360 / maxProgress;
        canvas.drawArc(oval, -90, currentAngle, false, progressPaint);

        String progressStr = progress + "";
        if (null != hintStr) {
            Rect rec = new Rect();
            contetPaint.getTextBounds(progressStr, 0, progressStr.length(), rec);
            Rect rec2 = new Rect();
            hintPaint.getTextBounds(hintStr, 0, hintStr.length(), rec2);
            canvas.drawText(progressStr, centre, centre, contetPaint);
            canvas.drawText(hintStr, centre, centre + rec2.height() * 7 / 5, hintPaint);
        } else {
            Rect rec2 = new Rect();
            contetPaint.getTextBounds(progressStr, 0, progressStr.length(), rec2);
            canvas.drawText(progressStr, centre, centre + rec2.height() / 2, contetPaint);
        }

        invalidate();
    }


    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        postInvalidate();
    }

    /**
     * dip 转换成px
     *
     * @param dip
     * @return
     */
    private int dipToPx(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f * (dip >= 0 ? 1 : -1));
    }
}
