package cn.evendy.uniots.ui.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import cn.evendy.uniots.R;
import cn.evendy.uniots.module.Alarm;
import cn.evendy.uniots.ui.widget.listener.AlarmItemClickListener;

/**
 * Created by evendy .
 */
public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.MyViewHolder> {
    private AlarmItemClickListener listener;
    private List<Alarm> alarms;
    private SimpleDateFormat dateFormat;

    public AlarmAdapter() {
        dateFormat = new SimpleDateFormat("hh:mm");
    }

    public void refreshData(List<Alarm> alarms) {
        this.alarms = alarms;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.list_item_alarm, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (null != listener) {
            holder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(position);
                }
            });
            holder.alarm_state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    listener.onItemStateChanged(position, isChecked);
                }
            });
        }
        Alarm item = alarms.get(position);

        holder.alarm_time.setText(dateFormat.format(item.getTime().getTime()));
        holder.alarm_state.setChecked(item.getState());
        switch (item.getRepeatType()) {
            case Alarm.TYPE_REPEAT_ONLY: {
                holder.alarm_repeat.setText(R.string.notify_one);
                break;
            }
            case Alarm.TYPE_REPEAT_WORKDAY: {
                holder.alarm_repeat.setText(R.string.workday);
                break;
            }
            case Alarm.TYPE_REPEAT_MON_TO_FIR: {
                holder.alarm_repeat.setText(R.string.monday_friday);
                break;
            }
            case Alarm.TYPE_REPEAT_EVERYDAY: {
                holder.alarm_repeat.setText(R.string.every_day);
                break;
            }

        }
    }

    @Override
    public int getItemCount() {
        if (null == alarms)
            return 0;
        return alarms.size();
    }

    public void addOnItemClickListener(AlarmItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public View container;
        public TextView alarm_time, alarm_repeat;
        public Switch alarm_state;

        public MyViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            alarm_time = (TextView) itemView.findViewById(R.id.alarm_time);
            alarm_repeat = (TextView) itemView.findViewById(R.id.alarm_repeat);
            alarm_state = (Switch) itemView.findViewById(R.id.alarm_state);
        }
    }
}
