package com.hanabi.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanabi.demo.service.ServiceDemoActivity;

public class DemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_main);

        Button btnServiceDemo = (Button)findViewById(R.id.button_service_demo);
        btnServiceDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start service demo
                Intent intent = new Intent(DemoMainActivity.this, ServiceDemoActivity.class);
                DemoMainActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
