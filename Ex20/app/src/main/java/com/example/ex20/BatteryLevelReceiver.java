package com.example.ex20;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

public class BatteryLevelReceiver extends BroadcastReceiver {
    private static final String TAG = "BatteryLevelReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = level * 100 / (float) scale;

        Log.d(TAG, "Battery level changed: " + batteryPct + "%");
        Toast.makeText(context, "Battery level: " + batteryPct + "%", Toast.LENGTH_LONG).show();
    }
}
