package cn.evendy.uniots.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cn.evendy.library.widget.pickerview.TimePickerView;
import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.base.BaseActivity;
import cn.evendy.uniots.ui.widget.adapter.SimpleItemAdapter;
import cn.evendy.uniots.ui.widget.listener.ItemSelectedListener;

/**
 * Created by evendy .
 */
public class SetAlarmActivity extends BaseActivity {
    private RecyclerView recycler_view;
    private SimpleItemAdapter adapter;
    private TextView alarm_ringtone;
    private TimePickerView time_picker;

    @Override
    protected void initViews() {
        initToolbar();

        time_picker = getView(R.id.time_picker);

        recycler_view = getView(R.id.list_repeat);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycler_view.setLayoutManager(linearLayoutManager);
        adapter = new SimpleItemAdapter();
        recycler_view.setAdapter(adapter);
        adapter.addOnItemSelectedListener(listener);

        getView(R.id.alarm_ringtone_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("choose ringtone...");
            }
        });
        alarm_ringtone = getView(R.id.alarm_ringtone);


    }

    private void initToolbar() {
        View cancelBTN = getView(R.id.menu_cancel);
        cancelBTN.setVisibility(View.VISIBLE);
        cancelBTN.setOnClickListener(menuClickListener);
        View sureBTN = getView(R.id.menu_sure);
        sureBTN.setVisibility(View.VISIBLE);
        sureBTN.setOnClickListener(menuClickListener);

        setToolbarTitle(R.string.set_alarm);
    }

    private View.OnClickListener menuClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.menu_cancel: {
                    finish();
                    break;
                }
                case R.id.menu_sure: {
                    toast(getInfo());
                    finish();
                    break;
                }
            }
        }
    };

    private String getInfo() {
        StringBuffer sb = new StringBuffer();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        sb.append(format.format(time_picker.getTime()));
        return sb.toString();

    }

    private ItemSelectedListener listener = new ItemSelectedListener() {
        @Override
        public void onItemSelected(int position) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);
        initViews();
        loadRepeatData();
    }

    private void loadRepeatData() {
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.repeat_type));
        adapter.refreshData(list);
    }

}
