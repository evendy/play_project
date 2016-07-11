package cn.evendy.uniots.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cn.evendy.uniots.R;
import cn.evendy.uniots.module.Alarm;
import cn.evendy.uniots.ui.activity.base.BaseActivity;
import cn.evendy.uniots.ui.widget.adapter.AlarmAdapter;
import cn.evendy.uniots.ui.widget.listener.AlarmItemClickListener;

/**
 * Created by evendy .
 */
public class AlarmActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView recycler_view;
    private AlarmAdapter adapter;
    private List<Alarm> alarms;

    @Override
    protected void initViews() {
        enableBackBTN();
        setToolbarTitle(R.string.set_alarm);
        getView(R.id.action_add).setOnClickListener(this);
        recycler_view = getView(R.id.recycler_view);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycler_view.setLayoutManager(linearLayoutManager);

        adapter = new AlarmAdapter();
        recycler_view.setAdapter(adapter);
        adapter.addOnItemClickListener(itemClickListener);
    }

    private AlarmItemClickListener itemClickListener = new AlarmItemClickListener() {
        @Override
        public void onItemClick(int position) {
            startActivity(new Intent(getContext(), SetAlarmActivity.class));
        }

        @Override
        public void onItemStateChanged(int position, boolean isChecked) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        initViews();

        loadData();
    }

    private void loadData() {
        alarms = new ArrayList<Alarm>();
        Alarm alarm;
        for (int i = 0; i < 4; i++) {
            alarm = new Alarm();
            alarm.setState(true);
            alarm.setTime(Calendar.getInstance());
            alarm.setRepeatType(Alarm.TYPE_REPEAT_ONLY);
            alarms.add(alarm);
        }
        adapter.refreshData(alarms);
    }

    @Override
    public void onClick(View v) {
        addAlarm();
    }

    private void addAlarm() {
        startActivity(new Intent(getContext(), SetAlarmActivity.class));
    }


}
