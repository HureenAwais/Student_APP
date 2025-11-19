package com.example.course_work;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {
    TextInputEditText editTextEmail, editTextPassword;
    Button button_register;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView TextView;
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(),Welcome.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth =FirebaseAuth.getInstance();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        button_register = findViewById(R.id.button_register);
        progressBar = findViewById(R.id.progressbar);
        TextView = findViewById(R.id.login_now);
        TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
        button_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password= String.valueOf(editTextPassword.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(RegistrationActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(RegistrationActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {

                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                                    "Registration successful!",
                                                    Toast.LENGTH_LONG)
                                            .show();
                                    // hide the progress bar
                                    progressBar.setVisibility(View.GONE);
                                    // if the user created intent to login activity
                                    Intent intent
                                            = new Intent(RegistrationActivity.this,
                                            Welcome.class);
                                    startActivity(intent);
                                }
                                else {
                                    // Registration failed
                                    Toast.makeText(
                                                    getApplicationContext(),
                                                    "Registration failed!!"
                                                            + " Please try again later",
                                                    Toast.LENGTH_LONG)
                                            .show();
                                    // hide the progress bar
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });


            }
        });
    }


}