package cn.evendy.uniots.ui.widget.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;

import cn.evendy.uniots.R;
import cn.evendy.uniots.utils.AppUtils;

/**
 * Created by evendy .
 */
public class UpdateAppDialog extends DialogFragment {

    private View view, dialog_check_update, dialog_updating_app, dialog_update_error;
    private NumberProgressBar pBar;

    private TextView dialog_newest;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_update, container);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        dialog_check_update.setVisibility(View.VISIBLE);

        mHandler.sendEmptyMessageDelayed(1, 2000);
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int code = msg.what;
            switch (code) {
                case 1: {
                    dialog_check_update.setVisibility(View.GONE);
                    dialog_newest.setVisibility(View.VISIBLE);

                    String newVersion = getString(R.string.already_newest) + "  " + AppUtils.getAppVersionName(getContext());
                    dialog_newest.setText(newVersion);

                    mHandler.sendEmptyMessageDelayed(2, 2000);
                    break;
                }
                case 2: {
                    setCancelable(false);
                    dialog_newest.setVisibility(View.GONE);
                    dialog_updating_app.setVisibility(View.VISIBLE);

                    updating();
                    break;
                }
                case 3: {
                    updating();
                    break;
                }
                case 4: {
                    setCancelable(true);
                    dialog_updating_app.setVisibility(View.GONE);
                    dialog_update_error.setVisibility(View.VISIBLE);
                }
            }
        }
    };

    private void updating() {
        if (pBar.getProgress() < 100) {
            pBar.incrementProgressBy(5);
            mHandler.sendEmptyMessageDelayed(3, 1000);
        } else {
            mHandler.sendEmptyMessageDelayed(4, 1000);
        }

    }

    private void initViews() {
        pBar = getView(R.id.number_progress_bar);
        dialog_newest = getView(R.id.dialog_newest);

        dialog_check_update = getView(R.id.dialog_check_update);
        dialog_updating_app = getView(R.id.dialog_updating_app);
        dialog_update_error = getView(R.id.dialog_update_error);

        getView(R.id.dialog_cancel_one).setOnClickListener(btnOnClickListener);
        getView(R.id.dialog_go_set).setOnClickListener(btnOnClickListener);
        getView(R.id.dialog_cancel).setOnClickListener(btnOnClickListener);
        getView(R.id.dialog_hide).setOnClickListener(btnOnClickListener);
    }

    private View.OnClickListener btnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.dialog_cancel:
                case R.id.dialog_cancel_one: {
                    cancelUpdate();
                    dismiss();
                    break;
                }
                case R.id.dialog_hide: {
                    dismiss();
                    break;
                }
                case R.id.dialog_go_set: {
                    dismiss();
                    break;
                }

            }
        }
    };

    private void cancelUpdate() {
        toast("cancelUpdate...");
    }

    protected <V extends View> V getView(int id) {
        return (V) view.findViewById(id);
    }

    protected void toast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
