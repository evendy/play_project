package cn.evendy.library.widget.pickerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.evendy.library.R;
import cn.evendy.library.widget.pickerview.lib.WheelView;
import cn.evendy.library.widget.pickerview.view.WheelTime;


/**
 * Created by evendy .
 */
public class TimePickerView extends FrameLayout {
    private Context context;
    private WheelTime wheelTime;
    private View rootView;
    private int pickerType;
    private WheelTime.Type type;
    private int pickerIndicatorType;

    public TimePickerView(Context context) {
        super(context);
        init(context, null);
    }

    public TimePickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TimePickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        initViews(attrs);
        initData();
    }

    private void initViews(AttributeSet attrs) {
        removeAllViews();
        rootView = LayoutInflater.from(context).inflate(R.layout.layout_basepickerview, null, false);
        addView(rootView, new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        ));
        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.TimePickerView, 0, 0);
        try {
            pickerType = typeArray.getInt(R.styleable.TimePickerView_picker_type, 0);
            pickerIndicatorType = typeArray.getInt(R.styleable.TimePickerView_indicator_type, WheelView.IndicatorType_Divider);
        } finally {
            typeArray.recycle();
        }

        switch (pickerType) {
            case 1:
                type = WheelTime.Type.YEAR_MONTH_DAY;
                break;
            case 2:
                type = WheelTime.Type.HOURS_MINS;
                break;
            case 3:
                type = WheelTime.Type.MONTH_DAY_HOUR_MIN;
                break;
            case 4:
                type = WheelTime.Type.YEAR_MONTH_DAY;
                break;
            default:
                type = WheelTime.Type.ALL;
        }
        wheelTime = new WheelTime(rootView, type);
    }

    private void initData() {
        //默认选中当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        wheelTime.setPicker(year, month, day, hours, minute);
        wheelTime.setIndicator(pickerIndicatorType);
        setCyclic(false);
    }

    /**
     * 设置可以选择的时间范围
     *
     * @param startYear
     * @param endYear
     */
    public void setRange(int startYear, int endYear) {
        wheelTime.setStartYear(startYear);
        wheelTime.setEndYear(endYear);
    }

    /**
     * 设置选中时间
     *
     * @param date
     */
    public void setTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null)
            calendar.setTimeInMillis(System.currentTimeMillis());
        else
            calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        wheelTime.setPicker(year, month, day, hours, minute);
    }

    /**
     * 设置是否循环滚动
     *
     * @param cyclic
     */
    public void setCyclic(boolean cyclic) {
        wheelTime.setCyclic(cyclic);
    }

    public Date getTime() {
        try {
            return WheelTime.dateFormat.parse(wheelTime.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
