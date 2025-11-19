package com.example.course_work;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {
    TextInputEditText editTextEmail, editTextPassword;
    Button button_Login;

    FirebaseAuth mAuth;
    ProgressBar progressBar;
    android.widget.TextView TextView;
    @Override
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
        setContentView(R.layout.activity_main2);
        // Find the toolbar view and set it as the action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth =FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.email);
        // Find the TextInputLayout by its ID
        TextInputLayout emailTextInputLayout = findViewById(R.id.emailTextInputLayout);
// Set the hint text color to white
        emailTextInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.BLACK));
        // Find the TextInputLayout by its ID
        TextInputLayout passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout);
// Set the hint text color to white
        passwordTextInputLayout.setDefaultHintTextColor(ColorStateList.valueOf(Color.BLACK));
        editTextPassword = findViewById(R.id.password);
        button_Login = findViewById(R.id.button_Login);
        progressBar = findViewById(R.id.progressbar);
        TextView = findViewById(R.id.register_now);
        TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
        button_Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password= String.valueOf(editTextPassword.getText());
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity2.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity2.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                // signin existing user
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                                new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(
                                            @NonNull Task<AuthResult> task)
                                    {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(),
                                                            "Login successful!!",
                                                            Toast.LENGTH_LONG)
                                                    .show();
                                            // hide the progress bar
                                            progressBar.setVisibility(View.GONE);
                                            // if sign-in is successful
                                            // intent to home activity
                                            Intent intent
                                                    = new Intent(MainActivity2.this,
                                                    Welcome.class);
                                            startActivity(intent);
                                        }
                                        else {
                                            // sign-in failed
                                            Toast.makeText(getApplicationContext(),
                                                            "Login failed!!",
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