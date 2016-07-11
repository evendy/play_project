package cn.evendy.uniots.ui.activity.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.ShareActivity;
import cn.evendy.uniots.ui.activity.SportActivity;

/**
 * Created by evendy .
 */
public abstract class BaseActivity extends AppCompatActivity {
    private TextView mTitle;

    protected abstract void initViews();

    protected <V extends View> V getView(View container, int id) {
        return (V) container.findViewById(id);
    }

    protected <V extends View> V getView(int id) {
        return (V) findViewById(id);
    }

    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void toast(int resId) {
        toast(getString(resId));
    }

    protected Context getContext() {
        return this;
    }

    protected void setToolbarTitle(String title) {
        mTitle = getView(R.id.toolbar_title);
        mTitle.setText(title);
    }

    protected void setToolbarTitle(int resId) {
        setToolbarTitle(getString(resId));
    }

    protected void enableBackBTN() {
        View backMenu = getView(R.id.menu_back);
        if (null != backMenu) {
            backMenu.setVisibility(View.VISIBLE);
            backMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    protected void enableShareBTN() {
        final View shareBTN = getView(R.id.menu_share);
        if (null != shareBTN) {
            shareBTN.setVisibility(View.VISIBLE);
            shareBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), ShareActivity.class));
                }
            });
        }
    }

    protected void enableMarkBTN(final View.OnClickListener listener) {
        View markBTN = getView(R.id.menu_mark);
        if (null != markBTN) {
            markBTN.setVisibility(View.VISIBLE);
            if (null != listener)
                markBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onClick(v);
                    }
                });
        }
    }

}
