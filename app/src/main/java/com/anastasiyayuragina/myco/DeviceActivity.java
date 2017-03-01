package com.anastasiyayuragina.myco;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class DeviceActivity extends AppCompatActivity {

    FragmentManager manager;

    enum FragmentType {
        DEVICES_LIST,
        ADD_NEW_DEVICE
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);

        manager = getSupportFragmentManager();
        Fragment fragment = DevicesListFragment.newInstance();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment, FragmentType.DEVICES_LIST.name()).commit();

        FloatingActionButton bluetooth_detect = (FloatingActionButton) findViewById(R.id.bluetooth_detect);
        bluetooth_detect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FloatingActionMenu menu = (FloatingActionMenu) findViewById(R.id.action_menu);
                CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) menu.getLayoutParams();
                p.setAnchorId(View.NO_ID);
                menu.setLayoutParams(p);
                menu.close(true);

                bluetoothDetect();
            }
        });
    }

    /**
     * Detect new bluetooth devices
     */

    public void bluetoothDetect() {
        Fragment fragment = AddNewDeviceFragment.newInstance();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment, FragmentType.ADD_NEW_DEVICE.name())
                .addToBackStack(null).commit();
    }

}
