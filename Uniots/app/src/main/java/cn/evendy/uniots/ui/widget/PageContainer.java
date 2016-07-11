package cn.evendy.uniots.ui.widget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.fragment.base.BasePageFragment;

public class PageContainer extends FrameLayout {

    private FrameLayout pageContainer;
    private ViewGroup pagerIndicator;

    private FragmentManager mFragmentManager;
    private int mFocusPageIndex = -1;

    private List<BasePageFragment> pages;
    private List<Integer> indicatorIcons;
    private List<String> titles;
    private LayoutInflater inflater;

    public PageContainer(Context context) {
        super(context);
        init();
    }

    public PageContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PageContainer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflater = LayoutInflater.from(getContext());
        View container = inflater.inflate(R.layout.view_page_container, null);
        addView(container, new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        pageContainer = (FrameLayout) container.findViewById(R.id.pager);
        pagerIndicator = (ViewGroup) container.findViewById(R.id.indicator);

        indicatorIcons = new ArrayList<Integer>();
        titles = new ArrayList<String>();
        pages = new ArrayList<BasePageFragment>();
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;

    }

    public void addPage(int titleRes, int iconRes,
                        BasePageFragment frame) {
        addPage(getContext().getString(titleRes), iconRes, frame);
    }

    public void addPage(String title, int iconRes,
                        BasePageFragment frame) {
        pages.add(frame);
        indicatorIcons.add(iconRes);
        titles.add(title);
    }

    public void show() {
        pagerIndicator.removeAllViews();
        View item;
        ImageView iconView;
        TextView titleView;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,
                LayoutParams.MATCH_PARENT, 1.0f);

        for (int i = 0; i < titles.size(); i++) {
            item = inflater.inflate(R.layout.view_item_page_indicator, null);
            iconView = (ImageView) item.findViewById(R.id.page_icon);
            titleView = (TextView) item.findViewById(R.id.page_title);
            titleView.setText(titles.get(i));
            iconView.setImageResource(indicatorIcons.get(i));
            item.setTag(i);
            item.setOnClickListener(pageSelectedListener);
            pagerIndicator.addView(item, params);
        }

        initPage();
    }

    private View.OnClickListener pageSelectedListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switchPage((Integer) v.getTag());
        }
    };

    private void initPage() {
        mFocusPageIndex = 0;
        View childView;
        ImageView iconView;
        TextView titleView;
        childView = pagerIndicator.getChildAt(mFocusPageIndex);
        iconView = (ImageView) childView.findViewById(R.id.page_icon);
        titleView = (TextView) childView.findViewById(R.id.page_title);
        titleView.setSelected(true);
        iconView.setSelected(true);

        mFragmentManager.beginTransaction().replace(pageContainer.getId(), pages.get(mFocusPageIndex)).commit();
    }


    public void switchPage(int index) {
        if (index == mFocusPageIndex)
            return;
        View childView;
        ImageView iconView;
        TextView titleView;
        childView = pagerIndicator.getChildAt(mFocusPageIndex);
        iconView = (ImageView) childView.findViewById(R.id.page_icon);
        titleView = (TextView) childView.findViewById(R.id.page_title);
        titleView.setSelected(false);
        iconView.setSelected(false);

        childView = pagerIndicator.getChildAt(index);
        iconView = (ImageView) childView.findViewById(R.id.page_icon);
        titleView = (TextView) childView.findViewById(R.id.page_title);
        titleView.setSelected(true);
        iconView.setSelected(true);

        mFragmentManager.beginTransaction().replace(pageContainer.getId(), pages.get(index)).commit();
        mFocusPageIndex = index;
    }

    public int getResumePageIndex() {
        return mFocusPageIndex;
    }
}
