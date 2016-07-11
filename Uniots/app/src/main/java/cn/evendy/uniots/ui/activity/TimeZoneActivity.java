package cn.evendy.uniots.ui.activity;

import android.os.Bundle;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;

/**
 * Created by evendy .
 */
public class TimeZoneActivity extends BaseActivity {
    @Override
    protected void initViews() {
        enableBackBTN();
        setToolbarTitle(R.string.chose_city);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timezone);
        initViews();
    }
}
