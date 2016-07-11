package cn.evendy.uniots.ui.fragment.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.ShareActivity;
import cn.evendy.uniots.ui.activity.SportActivity;

public abstract class BaseFragment extends Fragment {

    protected <V extends View> V getView(View container, int id) {
        return (V) container.findViewById(id);
    }

    protected <V extends View> V getActivityView(int id) {
        return (V) getActivity().findViewById(id);
    }

    public abstract int inflateView();

    protected void toast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    protected void toast(int resId) {
        toast(getString(resId));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(inflateView(), null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    protected <V extends View> V getView(int id) {
        return (V) view.findViewById(id);
    }

    public Context getContext() {
        return getActivity();
    }

    protected abstract void initViews();

    private TextView mTitle;

    protected void setToolbarTitle(String title) {
        mTitle = getView(R.id.toolbar_title);
        mTitle.setText(title);
    }

    protected void setToolbarTitle(int resId) {
        setToolbarTitle(getString(resId));
    }

    protected void enableShareBTN() {
        final View shareBTN = getView(R.id.menu_share);
        if (null != shareBTN) {
            shareBTN.setVisibility(View.VISIBLE);
            shareBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getContext().startActivity(new Intent(getContext(), ShareActivity.class));
                }
            });
        }
    }

    protected void enableMarkBTN() {
        View markBTN = getView(R.id.menu_mark);
        if (null != markBTN) {
            markBTN.setVisibility(View.VISIBLE);
            markBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("mark...");
                }
            });
        }
    }

    protected void enableSportBTN() {
        View sportBTN = getView(R.id.menu_sport);
        if (null != sportBTN) {
            if (null != sportBTN) {
                sportBTN.setVisibility(View.VISIBLE);
                sportBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getContext().startActivity(new Intent(getContext(), SportActivity.class));
                    }
                });
            }
        }
    }

}
