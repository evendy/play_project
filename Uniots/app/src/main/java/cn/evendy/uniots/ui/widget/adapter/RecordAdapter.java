package cn.evendy.uniots.ui.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.evendy.uniots.R;
import cn.evendy.uniots.module.Alarm;
import cn.evendy.uniots.module.DayEvent;
import cn.evendy.uniots.ui.widget.listener.RecordItemClickListener;

/**
 * Created by evendy .
 */
public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.MyViewHolder> {
    private List<DayEvent> events;
    private RecordItemClickListener listener;

    public RecordAdapter() {
    }

    public void refreshData(List<DayEvent> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    public void setRecordItemClickListener(RecordItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.list_item_activity, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (null != listener) {
            holder.itemSleep.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemSleepClick(position);
                }
            });
            holder.itemSport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemStepClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (null == events)
            return 0;
        return events.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public View itemSleep, itemSport;

        public MyViewHolder(View view) {
            super(view);
            itemSleep = view.findViewById(R.id.item_sleep);
            itemSport = view.findViewById(R.id.item_sport);
        }
    }


}
