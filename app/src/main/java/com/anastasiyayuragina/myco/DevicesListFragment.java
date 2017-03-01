package com.anastasiyayuragina.myco;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class DevicesListFragment extends Fragment {

    private ArrayList<Device> devicesArray;

    public static DevicesListFragment newInstance() {

        Bundle args = new Bundle();
        DevicesListFragment fragment = new DevicesListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        devicesList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.devices_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            DevicesListAdapter rvAdapter = new DevicesListAdapter(devicesArray);
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(rvAdapter);

        }

        return view;
    }

    /**
     * List of pairing devices
     */

    private void devicesList() {

        devicesArray = new ArrayList<>();
        devicesArray.add(new SomeDevice("device 1"));
        devicesArray.add(new SomeDevice("device 2"));
        devicesArray.add(new SomeDevice("device 3"));
        devicesArray.add(new SomeDevice("device 4"));
        devicesArray.add(new SomeDevice("device 5"));

    }
}
