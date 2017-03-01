package com.anastasiyayuragina.myco;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import java.util.ArrayList;

class AddNewDeviceAdapter extends RecyclerView.Adapter<AddNewDeviceAdapter.ViewHolder> {

    private ArrayList<Device> devices = new ArrayList<>();
    private Device selectedDevise = null;

    AddNewDeviceAdapter(ArrayList<Device> data) {
        this.devices = data;
    }

    private void setSelectedDevise(Device selectedDevise) {
        if (this.selectedDevise == null || !this.selectedDevise.equals(selectedDevise)) {
            this.selectedDevise = selectedDevise;
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_device_text_view, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Device device = devices.get(position);

        if (selectedDevise != null) {
            holder.itemView.setChecked(device.equals(selectedDevise));
        }

        holder.itemView.setText(device.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSelectedDevise(device);
            }
        });
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CheckedTextView itemView;

        ViewHolder(View view) {
            super(view);
            itemView = (CheckedTextView) view.findViewById(R.id.checked_device);
        }
    }
}
