package cn.evendy.uniots.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import cn.evendy.uniots.ui.widget.listener.RankPageChangeListener;

/**
 * Created by evendy .
 */
public class RankViewPager extends ViewPager {
    public RankViewPager(Context context) {
        super(context);
    }

    public RankViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void addRankPageChangeListener(final RankPageChangeListener listener) {
        if (null == listener)
            return;
        addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                listener.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
