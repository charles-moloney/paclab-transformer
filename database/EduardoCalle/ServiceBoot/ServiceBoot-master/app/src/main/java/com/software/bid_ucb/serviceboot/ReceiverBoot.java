package com.software.bid_ucb.serviceboot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Eduardo on 31/03/2015.
 */
public class ReceiverBoot extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // LANZAR SERVICIO
        Intent serviceIntent = new Intent();
        serviceIntent.setAction("com.software.bid_ucb.MyService");
        context.startService(serviceIntent);

        // LANZAR ACTIVIDAD
        Intent i = new Intent(context, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}
