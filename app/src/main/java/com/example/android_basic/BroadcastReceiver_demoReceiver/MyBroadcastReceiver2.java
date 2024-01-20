package com.example.android_basic.BroadcastReceiver_demoReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver2 extends BroadcastReceiver {
    private static final String MY_KEY = "com.tinCoder.KEY";

    @Override
    public void onReceive(Context context, Intent intent) {
    String myText = "MYBroadcast2: " + intent.getStringExtra(MY_KEY);
    Toast.makeText(context, myText, Toast.LENGTH_SHORT).show();

    }
}
