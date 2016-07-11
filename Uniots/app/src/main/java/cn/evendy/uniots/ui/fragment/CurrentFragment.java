package cn.evendy.uniots.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.glomadrian.dashedcircularprogress.DashedCircularProgress;

import java.util.ArrayList;
import java.util.List;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.activity.SleepActivity;
import cn.evendy.uniots.ui.activity.StepActivity;
import cn.evendy.uniots.ui.fragment.base.BasePageFragment;
import cn.evendy.uniots.module.DayEvent;
import cn.evendy.uniots.ui.widget.adapter.RecordAdapter;
import cn.evendy.uniots.ui.widget.listener.RecordItemClickListener;

/**
 * Created by evendy .
 */
public class CurrentFragment extends BasePageFragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecordAdapter rAdapter;
    private View dashboardView;
    private DashedCircularProgress dashboard;

    private List<DayEvent> events;

    @Override
    public int inflateView() {
        return R.layout.fragment_current;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    @Override
    protected void initViews() {
        setToolbarTitle(R.string.current);
        dashboardView = getView(R.id.dashboard_container);
        dashboardView.setOnClickListener(this);
        dashboard = getView(R.id.dashboard);

        initRecyclerView();
    }

    private void loadData() {
        events = new ArrayList<DayEvent>();
        events.add(new DayEvent());
        events.add(new DayEvent());
        events.add(new DayEvent());

        rAdapter.refreshData(events);
        animate();
    }

    private void animate() {
        dashboard.setValue(40);
    }

    private void initRecyclerView() {
        recyclerView = getView(R.id.my_records);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        rAdapter = new RecordAdapter();
        recyclerView.setAdapter(rAdapter);

        rAdapter.setRecordItemClickListener(recordItemClickListener);
    }

    RecordItemClickListener recordItemClickListener = new RecordItemClickListener() {

        @Override
        public void onItemSleepClick(int index) {
            goDateSleepPage(index);
        }

        @Override
        public void onItemStepClick(int index) {
            goDateSportPage(index);
        }
    };

    @Override
    protected void initToolbar() {
        enableShareBTN();
        enableSportBTN();
        setToolbarTitle(getString(R.string.today_activity));
    }

    @Override
    public void onClick(View v) {
        goDateSportPage(0);
    }

    private void goDateSportPage(int date) {
        Intent it = new Intent(getContext(), StepActivity.class);
        getContext().startActivity(it);
    }

    private void goDateSleepPage(int date) {
        Intent it = new Intent(getContext(), SleepActivity.class);
        getContext().startActivity(it);
    }
}