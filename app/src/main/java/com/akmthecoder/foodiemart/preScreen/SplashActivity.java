package com.akmthecoder.foodiemart.preScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.akmthecoder.foodiemart.R;

public class SplashActivity extends AppCompatActivity {

    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        titleView = findViewById(R.id.title);
    }
}