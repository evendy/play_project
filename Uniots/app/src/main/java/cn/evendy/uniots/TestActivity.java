package cn.evendy.uniots;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.evendy.library.widget.pickerview.TimePickerView;
import cn.evendy.uniots.ui.activity.base.BaseActivity;

/**
 * Created by evendy .
 */
public class TestActivity extends BaseActivity {
    private TimePickerView time_picker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initViews();
    }

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

    @Override
    protected void initViews() {
        getView(R.id.get_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("get time --- " + getTime(time_picker.getTime()));
            }
        });
        time_picker = getView(R.id.time_picker);
    }
}
