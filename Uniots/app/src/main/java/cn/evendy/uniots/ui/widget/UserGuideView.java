package cn.evendy.uniots.ui.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.evendy.uniots.R;

/**
 * Created by evendy .
 */
public class UserGuideView extends FrameLayout {
    private LayoutInflater inflater;
    private ViewGroup pagerIndicator;
    private ViewPager pageContainer;
    private View guideEnd;

    private List<View> pictueres;

    private ViewPagerAdapter mAdapter;

    public UserGuideView(Context context) {
        super(context);
        init();
    }

    public UserGuideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UserGuideView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    private void init() {
        inflater = LayoutInflater.from(getContext());
        View container = inflater.inflate(R.layout.view_guide, null);
        addView(container, new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        pageContainer = (ViewPager) container.findViewById(R.id.pager);
        pagerIndicator = (ViewGroup) container.findViewById(R.id.indicator_container);

        pictueres = new ArrayList<View>();

        guideEnd = container.findViewById(R.id.guide_end);
        guideEnd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextBTNClickListener.onNextBTNClick();
            }
        });
    }


    public UserGuideView addPage(int imgRes) {
        View view = inflater.inflate(R.layout.view_guide_item, null);
        view.setBackgroundResource(imgRes);
        pictueres.add(view);
        return this;
    }

    public void show() {
        pagerIndicator.removeAllViews();
        ImageView iconView;
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < pictueres.size(); i++) {
            iconView = new ImageView(getContext());
            iconView.setImageResource(R.drawable.ic_page_indicator);
            iconView.setPadding(10, 10, 10, 10);
            pagerIndicator.addView(iconView, params);

            if (i == 0) {
                iconView.setSelected(true);
            }
        }

        mAdapter = new ViewPagerAdapter(pictueres);
        pageContainer.setAdapter(mAdapter);
        //绑定回调
        pageContainer.addOnPageChangeListener(pageChangeListener);
    }

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == pictueres.size() - 1) {
                pagerIndicator.setVisibility(View.GONE);
                guideEnd.setVisibility(View.VISIBLE);
            } else {
                pagerIndicator.setVisibility(View.VISIBLE);
                guideEnd.setVisibility(View.GONE);
                for (int i = 0; i < pictueres.size() - 1; i++) {
                    pagerIndicator.getChildAt(i).setSelected(false);
                }
                pagerIndicator.getChildAt(position).setSelected(true);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    class ViewPagerAdapter extends PagerAdapter {
        private List<View> views;

        public ViewPagerAdapter(List<View> views) {
            this.views = views;
        }

        @Override
        public int getCount() {
            if (null == views)
                return 0;
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {  //这个方法用来实例化页卡
            container.addView(views.get(position), 0);//添加页卡
            return views.get(position);
        }

        //销毁arg1位置的界面
        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(views.get(arg1));
        }

    }

    public interface OnNextBTNClickListener {
        void onNextBTNClick();
    }

    private OnNextBTNClickListener onNextBTNClickListener;

    public void setOnNextBTNClickListener(OnNextBTNClickListener onNextBTNClickListener) {
        this.onNextBTNClickListener = onNextBTNClickListener;
    }

}
