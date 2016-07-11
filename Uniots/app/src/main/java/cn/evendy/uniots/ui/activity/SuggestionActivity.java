package cn.evendy.uniots.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;

/**
 * Created by evendy .
 */
public class SuggestionActivity extends BaseActivity {
    @Override
    protected void initViews() {
        enableBackBTN();
        setToolbarTitle(R.string.suggestion);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        initViews();
    }
}
