package cn.evendy.uniots.ui.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.widget.listener.ItemSelectedListener;

/**
 * Created by evendy .
 */
public class SimpleItemAdapter extends RecyclerView.Adapter<SimpleItemAdapter.MyViewHolder> {
    private List<String> list;
    private ItemSelectedListener listener;
    private int selectedIndex = 0;

    public void refreshData(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addOnItemSelectedListener(ItemSelectedListener listener) {
        this.listener = listener;
    }

    public void setSelectedItem(int index) {
        selectedIndex = index;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.list_item_simple, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedIndex = position;
                if (null != listener) {
                    listener.onItemSelected(position);
                }
                notifyDataSetChanged();
            }
        });
        if (position == selectedIndex) {
            holder.item.setSelected(true);
        } else {
            holder.item.setSelected(false);
        }
        holder.item.setText(list.get(position));
    }


    @Override
    public int getItemCount() {
        if (null == list)
            return 0;
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView item;

        public MyViewHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.item);
        }
    }
}
