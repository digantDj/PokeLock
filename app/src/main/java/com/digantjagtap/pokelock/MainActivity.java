package com.digantjagtap.pokelock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PowerManager;
import android.widget.Toast;
import android.view.View;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    PowerManager.WakeLock wakeLock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void acquirewakeLock(View v) {

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK,
                "My wakelook");
        wakeLock.acquire();
        Toast acquire = Toast.makeText(getApplicationContext(), "Wake Lock ON",
                Toast.LENGTH_SHORT);
        acquire.show();

        /* Code for Notificaion */

    }

    public void releaseWakelock(View v) {
        wakeLock.release();
        Toast release = Toast.makeText(getApplicationContext(),
                "Wake Lock OFF", Toast.LENGTH_SHORT);
        release.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
