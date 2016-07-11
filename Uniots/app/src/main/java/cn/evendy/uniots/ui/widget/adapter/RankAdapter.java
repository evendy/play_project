package cn.evendy.uniots.ui.widget.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.evendy.uniots.ui.fragment.base.BaseFragment;

/**
 * Created by evendy .
 */
public class RankAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<String> titles;
    private List<BaseFragment> fragments;

    public RankAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        titles = new ArrayList<String>();
        fragments = new ArrayList<BaseFragment>();
    }

    public RankAdapter addPage(int titleRes, BaseFragment fragment) {
        titles.add(context.getString(titleRes));
        fragments.add(fragment);
        return this;
    }

    public RankAdapter addPage(String title, BaseFragment fragment) {
        titles.add(title);
        fragments.add(fragment);
        return this;
    }

    @Override
    public int getCount() {
        if (null == fragments)
            return 0;
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}
