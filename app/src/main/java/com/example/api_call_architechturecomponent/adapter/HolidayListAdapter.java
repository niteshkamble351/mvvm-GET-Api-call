package com.example.api_call_architechturecomponent.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_call_architechturecomponent.R;
import com.example.api_call_architechturecomponent.model.HolidayModel;

import java.util.List;

public class HolidayListAdapter extends RecyclerView.Adapter<HolidayListAdapter.ViewHolder> {
    private Context mContext;
    private List<HolidayModel> mList;
    private ItemClickListener listener;

    public HolidayListAdapter(Context mContext, List<HolidayModel> mList, ItemClickListener listener) {
        this.mContext = mContext;
        this.mList = mList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(view);
    }

    public void setmList(List<HolidayModel> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(mList.get(position).getName());
        holder.localName.setText(mList.get(position).getLocalName());
        holder.date.setText(mList.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onHolidayClick(mList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, localName, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            localName = itemView.findViewById(R.id.localName);
            date = itemView.findViewById(R.id.date);
        }
    }


    public interface ItemClickListener {
        void onHolidayClick(HolidayModel holidayModel);
    }
}
