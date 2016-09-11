package com.hanabi.demo.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hanabi.demo.R;

/**
 * Created by justyn on 16/9/4.
 */
public class ServiceDemoActivity extends AppCompatActivity {

    private boolean mBound = false;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DemoService.DemoBinder binder = (DemoService.DemoBinder)service;
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_demo_main);

        Button btnStartService = (Button)findViewById(R.id.button_start_service);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDemoActivity.this, DemoService.class);
                ServiceDemoActivity.this.startService(intent);
            }
        });

        Button btnBindService = (Button)findViewById(R.id.button_bind_service);
        btnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDemoActivity.this, DemoService.class);
                bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
            }
        });

        Button btnMessengerService = (Button)findViewById(R.id.button_messenger_service);
        btnMessengerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDemoActivity.this, ServiceMessengerDemoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent intent = new Intent(this, DemoService.class);
        stopService(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }
}
