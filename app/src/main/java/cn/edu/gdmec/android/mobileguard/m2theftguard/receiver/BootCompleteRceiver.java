package cn.edu.gdmec.android.mobileguard.m2theftguard.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.edu.gdmec.android.mobileguard.App;

/**
 * Created by asus on 2017/10/20.
 */

public class BootCompleteRceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ((App)(context.getApplicationContext())).correctSIM();
    }
}
