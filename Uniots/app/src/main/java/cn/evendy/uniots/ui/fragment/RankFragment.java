package cn.evendy.uniots.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.evendy.uniots.Common;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.fragment.base.BaseFragment;

/**
 * Created by evendy .
 */
public class RankFragment extends BaseFragment {
    private int typePage;
    private View container;

    @Override
    public int inflateView() {
        return R.layout.fragment_rank;
    }

    @Override
    protected void initViews() {
        container = getView(R.id.view_rank);
        switch (typePage) {
            case Common.Page_Date: {
                container.setBackgroundColor(getResources().getColor(R.color.common_green));
                break;
            }
            case Common.Page_Week: {
                container.setBackgroundColor(getResources().getColor(R.color.common_dark));
                break;
            }
            case Common.Page_Month: {
                container.setBackgroundColor(getResources().getColor(R.color.common_yellow));
                break;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        typePage = getArguments().getInt(Common.Type_Page);
        return view;
    }
}
