package cn.evendy.uniots.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.evendy.uniots.Common;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;

/**
 * Created by evendy .
 */
public class InitBornActivity extends BaseActivity {
    private View next_step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_born);
        initViews();

        build();
    }

    private void build() {
        if (Common.EventModify == getIntent().getIntExtra(Common.StringEventModify, 0)) {
            getView(R.id.modify_container).setVisibility(View.VISIBLE);

            getView(R.id.btn_cancel).setOnClickListener(btnClickListener);
            getView(R.id.btn_save).setOnClickListener(btnClickListener);
        } else {
            next_step = getView(R.id.next_step);
            next_step.setVisibility(View.VISIBLE);
            next_step.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    verifyInputInfo();
                }
            });
        }

    }

    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (R.id.btn_cancel == v.getId()) {
                finish();
            } else {
                saveInfo();
                finish();
            }
        }
    };

    private void saveInfo() {
        toast("save info...");
    }

    @Override
    protected void initViews() {
        setToolbarTitle(R.string.born);
        enableBackBTN();
    }

    private void verifyInputInfo() {
        startActivity(new Intent(getContext(), InitSportActivity.class));
    }
}
