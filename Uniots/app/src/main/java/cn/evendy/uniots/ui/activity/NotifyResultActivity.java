package cn.evendy.uniots.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Switch;
import android.widget.TextView;

import cn.evendy.uniots.Common;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;

/**
 * Created by evendy .
 */
public class NotifyResultActivity extends BaseActivity {

    private int notifyResult;
    private TextView open_notify_text, notify_tips;
    private Switch toggle_notify;

    @Override
    protected void initViews() {
        enableBackBTN();
        open_notify_text = getView(R.id.open_notify_text);
        notify_tips = getView(R.id.notify_tips);
        toggle_notify = getView(R.id.toggle_notify);

        switch (notifyResult) {
            case Common.NotifySportResult: {
                setToolbarTitle(R.string.notify_sport);
                open_notify_text.setText(R.string.notify_sport_open);
                notify_tips.setText(R.string.notify_sport_report);
                break;
            }
            case Common.NotifySleepResult: {
                setToolbarTitle(R.string.notify_sleep);
                open_notify_text.setText(R.string.notify_sleep_open);
                notify_tips.setText(R.string.notify_sleep_report);
                break;
            }
            case Common.NotifyIncomingResult: {
                setToolbarTitle(R.string.notify_incoming);
                open_notify_text.setText(R.string.notify_incoming_open);
                notify_tips.setText(R.string.notify_incoming_report);
                break;
            }

            case Common.NotifySmsResult: {
                setToolbarTitle(R.string.notify_sms);
                open_notify_text.setText(R.string.notify_sms_open);
                notify_tips.setText(R.string.notify_sms_report);
                break;
            }
            case Common.NotifyAppResult: {
                setToolbarTitle(R.string.notify_app);
                open_notify_text.setText(R.string.notify_app_open);
                notify_tips.setText(R.string.notify_app_report);
                break;
            }
            case Common.NotifyBroadcastResult: {
                setToolbarTitle(R.string.broadcast_id);
                open_notify_text.setText(R.string.notify_broadcast_open);
                notify_tips.setText(R.string.notify_broadcast_report);
                break;
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_result);
        notifyResult = getIntent().getIntExtra(Common.StringResultNotify, Common.NotifySportResult);

        initViews();
    }
}
