package com.akmthecoder.foodiemart.preScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.akmthecoder.foodiemart.R;
import com.akmthecoder.foodiemart.home.HomeActivity;

public class SignUpActivity extends AppCompatActivity {

    private ConstraintLayout facebookBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.facebookBtn = findViewById(R.id.facebook_btn);

        this.facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}