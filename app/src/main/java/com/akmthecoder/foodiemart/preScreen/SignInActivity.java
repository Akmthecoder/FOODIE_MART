package com.akmthecoder.foodiemart.preScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.akmthecoder.foodiemart.R;
import com.akmthecoder.foodiemart.home.HomeActivity;
import com.akmthecoder.foodiemart.model.Connection;
import com.akmthecoder.foodiemart.model.data.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

public class SignInActivity extends AppCompatActivity {
    private AppCompatImageView backButton;
    private EditText email;
    private EditText password;
    private ConstraintLayout signInButton;
    private TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        backButton = findViewById(R.id.back_btn);
        email = findViewById(R.id.email_et);
        password = findViewById(R.id.password_et);
        signInButton = findViewById(R.id.sign_in);
        signUp = findViewById(R.id.t5);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSignIn();
            }
        });
    }

    private void doSignIn() {
        if(this.email.getText().toString().isEmpty() == false && this.password.getText().toString().isEmpty() == false){
            String emailText = this.email.getText().toString();
            String passwordText = this.password.getText().toString();
            FirebaseAuth.getInstance().signInWithEmailAndPassword(emailText,passwordText).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(SignInActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}