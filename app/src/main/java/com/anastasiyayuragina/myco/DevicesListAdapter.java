package com.anastasiyayuragina.myco;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

class DevicesListAdapter extends RecyclerView.Adapter<DevicesListAdapter.ViewHolder> {
    private ArrayList<Device> devices = new ArrayList<>();

    DevicesListAdapter(ArrayList<Device> data) {
        devices = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_name_card, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setText(devices.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemView;

        ViewHolder(View view) {
            super(view);
            itemView = (TextView) view.findViewById(R.id.card_device_name);
        }
    }
}
