package cn.evendy.uniots.ui.activity;

import android.os.Bundle;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;
import cn.evendy.uniots.ui.fragment.CurrentFragment;
import cn.evendy.uniots.ui.fragment.DiscoveryFragment;
import cn.evendy.uniots.ui.fragment.MineFragment;
import cn.evendy.uniots.ui.fragment.PlayFragment;
import cn.evendy.uniots.ui.fragment.base.BasePageFragment;
import cn.evendy.uniots.ui.widget.PageContainer;

/**
 * Created by evendy .
 */
public class MainActivity extends BaseActivity {
    public static final int CurrentFragmentIndex = 0;
    public static final int DiscoveryFragmentIndex = 1;
    public static final int PlayFragmentIndex = 2;
    public static final int MineFragmentIndex = 3;

    private PageContainer pageGroup;
    private BasePageFragment currentFragment, discoveryFragment, playFragment, mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pageGroup = getView(R.id.main);
        pageGroup.setFragmentManager(getSupportFragmentManager());
        initViews();
        pageGroup.show();
    }


    @Override
    protected void initViews() {
        currentFragment = new CurrentFragment();
        discoveryFragment = new DiscoveryFragment();
        playFragment = new PlayFragment();
        mineFragment = new MineFragment();

        pageGroup.addPage(R.string.current, R.drawable.menu_current, currentFragment);
        pageGroup.addPage(R.string.discovery, R.drawable.menu_discovery, discoveryFragment);
        pageGroup.addPage(R.string.smart_play, R.drawable.menu_play, playFragment);
        pageGroup.addPage(R.string.mine, R.drawable.menu_mine, mineFragment);
    }


    private long mExitTime;

    @Override
    public void onBackPressed() {
        if (pageGroup.getResumePageIndex() == DiscoveryFragmentIndex && discoveryFragment.onBackPressed()) {
        } else if ((System.currentTimeMillis() - mExitTime) > 2000) {
            toast(R.string.exit_toast);
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

}
