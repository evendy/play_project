package cn.evendy.uniots.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import cn.evendy.uniots.Common;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;
import cn.evendy.uniots.ui.widget.UserGuideView;
import cn.trinea.android.common.util.PreferencesUtils;

/**
 * Created by evendy .
 */
public class GuideActivity extends BaseActivity {
    private UserGuideView guideView;

    @Override
    protected void initViews() {
        guideView = getView(R.id.view_guide);
        guideView.addPage(R.drawable.guide_1).addPage(R.drawable.guide_2).addPage(R.drawable.guide_3).addPage(R.drawable.guide_4).addPage(R.drawable.guide_5).show();
        guideView.setOnNextBTNClickListener(new UserGuideView.OnNextBTNClickListener() {
            @Override
            public void onNextBTNClick() {
                PreferencesUtils.putBoolean(getContext(), Common.UserGuide, true);
                goLogin();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (PreferencesUtils.getBoolean(getContext(), Common.UserGuide, false)) {
            goLogin();
        }

        setContentView(R.layout.activity_guide);
        initViews();
    }

    private void goLogin() {
        startActivity(new Intent(getContext(), LoginActivity.class));
        finish();
    }
}
