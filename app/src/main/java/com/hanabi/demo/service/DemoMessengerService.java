package com.hanabi.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by justyn on 16/9/7.
 */
public class DemoMessengerService extends Service {

    private final static String LOG_TAG = "DemoMessengerService";

    public final static int MSG_SAY_HELLO = 1;

    private final Messenger mMessenger = new Messenger(new MessengerHandler());

    @Override
    public void onCreate() {
        Log.v(LOG_TAG, "messenger service creating...");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.v(LOG_TAG, "messenger service starting...");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(LOG_TAG, "messenger service start command...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.v(LOG_TAG, "messenger service destroying...");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(LOG_TAG, "messenger service binding...");
        return mMessenger.getBinder();
    }

    class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
                    break;
                default:
                    super.handleMessage(msg);
            }

        }
    }
}
