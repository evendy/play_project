package cn.evendy.uniots.ui.widget.popwindow;

import android.content.Context;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.widget.listener.SelectViewLayerListener;

/**
 * Created by evendy .
 */
public class SelectViewLayerPop extends PopupWindow {
    public static void show(Context context, final SelectViewLayerListener listener) {
        View popupView = LayoutInflater.from(context).inflate(R.layout.popup_select_viewlayer, null,
                false);
        popupView.setFocusable(true); // 这个很重要
        popupView.setFocusableInTouchMode(true);
        final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.AnimationFade);
        popupView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });

        if (null != listener) {
            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    switch (id) {
                        case R.id.view_date: {
                            listener.onSelectedDateViewLayer();

                            break;
                        }
                        case R.id.view_week: {
                            listener.onSelectedWeekViewLayer();
                            break;
                        }
                        case R.id.view_month: {
                            listener.onSelectedMonthViewLayer();
                            break;
                        }
                    }
                    popupWindow.dismiss();
                }
            };
            popupView.findViewById(R.id.view_date).setOnClickListener(clickListener);
            popupView.findViewById(R.id.view_week).setOnClickListener(clickListener);
            popupView.findViewById(R.id.view_month).setOnClickListener(clickListener);
        }

        popupWindow.showAtLocation(popupView, Gravity.TOP | Gravity.RIGHT, 0, 80);
    }
}
