package cn.evendy.uniots.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import cn.evendy.uniots.Common;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.AlarmActivity;
import cn.evendy.uniots.ui.activity.NotifyResultActivity;
import cn.evendy.uniots.ui.fragment.base.BasePageFragment;

/**
 * Created by evendy .
 */
public class PlayFragment extends BasePageFragment implements View.OnClickListener {
    private TextView status_notify_incoming, status_notify_alarm, status_notify_sms, status_notify_app, status_notify_timezone, status_notify_id;

    @Override
    public int inflateView() {
        return R.layout.fragment_play;
    }

    @Override
    protected void initViews() {
        status_notify_incoming = getView(R.id.status_notify_incoming);
        status_notify_alarm = getView(R.id.status_notify_alarm);
        status_notify_sms = getView(R.id.status_notify_sms);
        status_notify_app = getView(R.id.status_notify_app);
        status_notify_timezone = getView(R.id.status_notify_timezone);
        status_notify_id = getView(R.id.status_notify_broadcast);

        getView(R.id.ic_notify_incoming).setOnClickListener(menuClickListener);
        getView(R.id.ic_notify_alarm).setOnClickListener(menuClickListener);
        getView(R.id.ic_notify_sms).setOnClickListener(menuClickListener);
        getView(R.id.ic_notify_app).setOnClickListener(menuClickListener);
        getView(R.id.ic_notify_timezone).setOnClickListener(menuClickListener);
        getView(R.id.ic_notify_broadcast).setOnClickListener(menuClickListener);

        getView(R.id.part_wechat).setOnClickListener(this);
        getView(R.id.part_qq).setOnClickListener(this);

    }

    private View.OnClickListener menuClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.ic_notify_incoming: {
                    Intent it = new Intent(getContext(), NotifyResultActivity.class);
                    it.putExtra(Common.StringResultNotify, Common.NotifyIncomingResult);
                    startActivity(it);
                    break;
                }
                case R.id.ic_notify_alarm: {
                    getContext().startActivity(new Intent(getContext(), AlarmActivity.class));
                    break;
                }
                case R.id.ic_notify_sms: {
                    Intent it = new Intent(getContext(), NotifyResultActivity.class);
                    it.putExtra(Common.StringResultNotify, Common.NotifySmsResult);
                    startActivity(it);
                    break;
                }
                case R.id.ic_notify_app: {
                    Intent it = new Intent(getContext(), NotifyResultActivity.class);
                    it.putExtra(Common.StringResultNotify, Common.NotifyAppResult);
                    startActivity(it);
                    break;
                }
                case R.id.ic_notify_timezone: {

                    break;
                }
                case R.id.ic_notify_broadcast: {
                    Intent it = new Intent(getContext(), NotifyResultActivity.class);
                    it.putExtra(Common.StringResultNotify, Common.NotifyBroadcastResult);
                    startActivity(it);
                    break;
                }
            }
        }
    };

    @Override
    protected void initToolbar() {
        setToolbarTitle(R.string.smart_play);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.part_wechat: {
                break;
            }
            case R.id.part_qq: {
                break;
            }
        }
    }
}
