package com.example.course_work;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView animatedImageView = findViewById(R.id.animatedImageView);

        AnimatedVectorDrawable avd = (AnimatedVectorDrawable) animatedImageView.getDrawable();
        // Start the animation
        avd.start();


        int SPLASH_SCREEN_TIMEOUT = 2000; // 2 seconds
        new android.os.Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(mainIntent);
            finish(); // Close the splash screen activity
        }, SPLASH_SCREEN_TIMEOUT);
    }
    /* Define the animation
        ObjectAnimator animator = ObjectAnimator.ofFloat(animatedImageView, "rotation", 0f, 360f);
        animator.setDuration(8000); // Set animation duration (2 seconds)
        animator.setRepeatCount(ObjectAnimator.INFINITE); // Repeat the animation infinitely
        animator.start(); // Start the animation */
    // Start your main activity after a short delay (e.g., 2 seconds)
    // You can adjust the delay time according to your preference
}
