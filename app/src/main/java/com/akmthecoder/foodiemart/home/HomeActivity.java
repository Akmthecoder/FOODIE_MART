package com.akmthecoder.foodiemart.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.akmthecoder.foodiemart.R;
import com.akmthecoder.foodiemart.ui.CartBottomFragment;
import com.google.android.gms.dynamic.SupportFragmentWrapper;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CartBottomFragment fragment = new CartBottomFragment();
        FragmentManager fm = getSupportFragmentManager();
        fragment.show(fm,"");
    }
}