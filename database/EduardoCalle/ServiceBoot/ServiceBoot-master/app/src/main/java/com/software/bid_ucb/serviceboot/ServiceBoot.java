package com.software.bid_ucb.serviceboot;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Eduardo on 31/03/2015.
 */
public class ServiceBoot extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"Servicio creado",Toast.LENGTH_LONG).show();  //Saca un mensaje temporal en la pantalla
        Log.d("SERVICEBOOT","Servicio creado");  //Postea mensajes en el LogCat
        // Esta es una prueba del servicio de GitHub
        // pruelsjfs

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Servicio destruido", Toast.LENGTH_LONG).show();
        Log.d("SERVICEBOOT", "Servicio destruido");
    }
}
