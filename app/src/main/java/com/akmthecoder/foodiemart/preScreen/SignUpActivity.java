package com.akmthecoder.foodiemart.preScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class SignUpActivity extends AppCompatActivity {

    private ConstraintLayout facebookBtn;
    private AppCompatImageView backButton;
    private EditText email;
    private EditText password;
    private ConstraintLayout signUpButton;
    private EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.facebookBtn = findViewById(R.id.facebook_btn);
        this.username = findViewById(R.id.username_et);
        backButton = findViewById(R.id.back_btn);
        email = findViewById(R.id.email_et);
        password = findViewById(R.id.password_et);
        signUpButton = findViewById(R.id.account_btn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSignIn();
            }
        });
        this.facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void doSignIn() {
        if(this.username.getText().toString().isEmpty() == false && email.getText().toString().isEmpty() == false && this.password.getText().toString().isEmpty() == false){
            String usernameText = this.username.getText().toString();
            String emailText = this.email.getText().toString();
            String passwordText = this.password.getText().toString();
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailText,passwordText).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        AuthResult result  = task.getResult();
                        FirebaseUser firebaseUser = result.getUser();
                        String id = firebaseUser.getUid();
                        User user = new User();
                        user.setId(id);
                        user.setUsername(usernameText);
                        user.setEmail(emailText);
                        loadDataInDatabase(user);
                    }else{
                        Toast.makeText(SignUpActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void loadDataInDatabase(User user) {
        Gson gson = new Gson();
        String userJsonString = gson.toJson(user);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(Connection.USER).child(user.getId()).setValue(userJsonString)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(SignUpActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}