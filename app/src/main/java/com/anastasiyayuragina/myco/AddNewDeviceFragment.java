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

public class AddNewDeviceFragment extends Fragment {

    private ArrayList<Device> devicesArray;

    public static AddNewDeviceFragment newInstance() {

        Bundle args = new Bundle();
        AddNewDeviceFragment fragment = new AddNewDeviceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        devicesList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.check_new_device, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            AddNewDeviceAdapter adapter = new AddNewDeviceAdapter(devicesArray);
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(layoutManager);

            RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(context);
            recyclerView.addItemDecoration(dividerItemDecoration);

            recyclerView.setAdapter(adapter);
        }

        return view;
    }

    /**
     *  Add new device in pairs list
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
