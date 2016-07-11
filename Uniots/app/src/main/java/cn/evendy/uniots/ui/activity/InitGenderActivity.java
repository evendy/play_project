package cn.evendy.uniots.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.evendy.uniots.Common;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;

/**
 * Created by evendy .
 */
public class InitGenderActivity extends BaseActivity {
    private ViewGroup maleView, femaleView;
    private TextView maleText, femaleText;
    private View next_step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_gender);
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
                    startActivity(new Intent(getContext(), InitWeightActivity.class));
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
        setToolbarTitle(R.string.gender);
        enableBackBTN();

        maleView = getView(R.id.gender_male);
        femaleView = getView(R.id.gender_female);

        maleText = getView(R.id.gender_male_text);
        femaleText = getView(R.id.gender_female_text);

        maleView.setOnClickListener(genderSelectedListener);
        femaleView.setOnClickListener(genderSelectedListener);


    }

    private View.OnClickListener genderSelectedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.gender_female) {
                femaleText.setSelected(true);
                maleText.setSelected(false);
            } else {
                femaleText.setSelected(false);
                maleText.setSelected(true);
            }
        }
    };
}
