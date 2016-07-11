package cn.evendy.uniots.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import cn.evendy.uniots.Common;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;
import cn.evendy.uniots.ui.fragment.RankFragment;
import cn.evendy.uniots.ui.fragment.base.BaseFragment;
import cn.evendy.uniots.ui.widget.RankViewPager;
import cn.evendy.uniots.ui.widget.adapter.RankAdapter;
import cn.evendy.uniots.ui.widget.listener.RankPageChangeListener;

/**
 * Created by evendy .
 */
public class TopListActivity extends BaseActivity {
    private TextView my_rank;
    private RankViewPager viewpager;
    private RankAdapter rAdapter;

    @Override
    protected void initViews() {
        enableBackBTN();
        setToolbarTitle(R.string.top_list);
        my_rank = getView(R.id.my_rank);
        viewpager = getView(R.id.viewpager);

        RankFragment dateFragment = new RankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Common.Type_Page, Common.Page_Date);
        dateFragment.setArguments(bundle);

        RankFragment weekFragment = new RankFragment();
        bundle = new Bundle();
        bundle.putInt(Common.Type_Page, Common.Page_Week);
        weekFragment.setArguments(bundle);

        RankFragment monthFragment = new RankFragment();
        bundle = new Bundle();
        bundle.putInt(Common.Type_Page, Common.Page_Month);
        monthFragment.setArguments(bundle);

        rAdapter = new RankAdapter(getContext(), getSupportFragmentManager());
        rAdapter.addPage(R.string.current_day, dateFragment).addPage(R.string.week, weekFragment).addPage(R.string.month, monthFragment);
        viewpager.setAdapter(rAdapter);
        viewpager.addRankPageChangeListener(new RankPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                my_rank.setText(++position + "");
            }
        });
        viewpager.setCurrentItem(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toplist);
        initViews();
    }
}
