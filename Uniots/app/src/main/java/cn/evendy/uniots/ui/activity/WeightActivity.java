package cn.evendy.uniots.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;

import cn.evendy.uniots.Common;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;
import cn.evendy.uniots.ui.fragment.DateStepFragment;
import cn.evendy.uniots.ui.fragment.DateWeightFragment;
import cn.evendy.uniots.ui.fragment.MonthStepFragment;
import cn.evendy.uniots.ui.fragment.MonthWeightFragment;
import cn.evendy.uniots.ui.fragment.WeekStepFragment;
import cn.evendy.uniots.ui.fragment.WeekWeightFragment;
import cn.evendy.uniots.ui.fragment.base.BaseFragment;
import cn.evendy.uniots.ui.widget.listener.SelectViewLayerListener;
import cn.evendy.uniots.ui.widget.popwindow.SelectViewLayerPop;

/**
 * Created by evendy .
 */
public class WeightActivity extends BaseActivity {
    private FragmentManager fm;
    private int pageStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellowbar_container);
        fm = getSupportFragmentManager();
        initViews();
    }

    @Override
    protected void initViews() {
        enableBackBTN();
        enableMarkBTN(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectViewLayerPop.show(getContext(), new SelectViewLayerListener() {
                    @Override
                    public void onSelectedDateViewLayer() {
                        loadPage(Common.Page_Date);
                    }

                    @Override
                    public void onSelectedWeekViewLayer() {
                        loadPage(Common.Page_Week);
                    }

                    @Override
                    public void onSelectedMonthViewLayer() {
                        loadPage(Common.Page_Month);
                    }
                });
            }
        });
        enableShareBTN();
        setToolbarTitle(R.string.weight);
        loadPage(Common.Page_Date);
    }

    private void loadPage(int newViewLayer) {
        if (pageStyle == newViewLayer)
            return;
        pageStyle = newViewLayer;
        BaseFragment pageFragment;
        switch (pageStyle) {
            case Common.Page_Date: {
                pageFragment = new DateWeightFragment();
                fm.beginTransaction().replace(R.id.container, pageFragment).commit();
                break;
            }
            case Common.Page_Week: {
                pageFragment = new WeekWeightFragment();
                fm.beginTransaction().replace(R.id.container, pageFragment).commit();
                break;
            }
            case Common.Page_Month: {
                pageFragment = new MonthWeightFragment();
                fm.beginTransaction().replace(R.id.container, pageFragment).commit();
                break;
            }
        }
    }
}
