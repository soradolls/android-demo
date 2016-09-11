package com.hanabi.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by justyn on 16/9/4.
 */
public class DemoService extends Service {

    private static final String LOG_TAG = "DemoService";

    private IBinder mBinder = new DemoBinder();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(LOG_TAG, "demo service start command...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        Log.v(LOG_TAG, "demo service create...");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.v(LOG_TAG, "demo service starting...");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.v(LOG_TAG, "demo service destroy...");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(LOG_TAG, "demo service binding...");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(LOG_TAG, "demo service unbinding...");
        return super.onUnbind(intent);
    }

    public class DemoBinder extends Binder {

    }
}
