package cn.evendy.uniots.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import cn.evendy.uniots.Common;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.FriendActivity;
import cn.evendy.uniots.ui.activity.MyInfoActivity;
import cn.evendy.uniots.ui.activity.NotifyResultActivity;
import cn.evendy.uniots.ui.activity.SettingsActivity;
import cn.evendy.uniots.ui.activity.TopListActivity;
import cn.evendy.uniots.ui.fragment.base.BasePageFragment;

/**
 * Created by evendy .
 */
public class MineFragment extends BasePageFragment {

    private ImageView my_avatar;

    private TextView daily_steps, total_mileage, standard_number_of_days, text_sport_goal,
            text_weight_goal, text_menu_sport_result_notify, text_sleep_result_notify;

    private ListView list_my_hardware;

    @Override
    public int inflateView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViews() {
        setToolbarTitle(R.string.mine);

        my_avatar = getView(R.id.avatar);
        my_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MyInfoActivity.class));
            }
        });

        daily_steps = getView(R.id.daily_steps);
        total_mileage = getView(R.id.total_mileage);
        standard_number_of_days = getView(R.id.standard_number_of_days);
        text_sport_goal = getView(R.id.text_sport_goal);
        text_weight_goal = getView(R.id.text_weight_goal);
        text_menu_sport_result_notify = getView(R.id.text_menu_sport_result_notify);
        text_sleep_result_notify = getView(R.id.text_sleep_result_notify);


        getView(R.id.my_hardware).setOnClickListener(menuClickListener);
        getView(R.id.menu_sport_goal).setOnClickListener(menuClickListener);
        getView(R.id.menu_weight_goal).setOnClickListener(menuClickListener);
        getView(R.id.menu_sport_result_notify).setOnClickListener(menuClickListener);
        getView(R.id.menu_sleep_result_notify).setOnClickListener(menuClickListener);
        getView(R.id.menu_settings).setOnClickListener(menuClickListener);
        getView(R.id.menu_friends).setOnClickListener(menuClickListener);
        getView(R.id.menu_top_list).setOnClickListener(menuClickListener);
    }

    @Override
    protected void initToolbar() {
        enableShareBTN();
    }

    private View.OnClickListener menuClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.my_hardware: {
                    searchHardware();
                    break;
                }
                case R.id.menu_sport_goal: {
                    break;
                }
                case R.id.menu_weight_goal: {
                    break;
                }
                case R.id.menu_sport_result_notify: {
                    Intent it = new Intent(getContext(), NotifyResultActivity.class);
                    it.putExtra(Common.StringResultNotify, Common.NotifySportResult);
                    startActivity(it);
                    break;
                }
                case R.id.menu_sleep_result_notify: {
                    Intent it = new Intent(getContext(), NotifyResultActivity.class);
                    it.putExtra(Common.StringResultNotify, Common.NotifySleepResult);
                    startActivity(it);
                    break;
                }
                case R.id.menu_settings: {
                    startActivity(new Intent(getContext(), SettingsActivity.class));
                    break;
                }
                case R.id.menu_friends: {
                    startActivity(new Intent(getContext(), FriendActivity.class));
                    break;
                }
                case R.id.menu_top_list: {
                    startActivity(new Intent(getContext(), TopListActivity.class));
                    break;
                }
            }
        }
    };

    private void searchHardware() {
        toast("searchHardware");
    }
}
