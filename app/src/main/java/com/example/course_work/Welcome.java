package com.example.course_work;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.course_work.databinding.ActivityWelcomeBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Welcome extends AppCompatActivity {
    private static final int menu_timetable = R.id.menu_timetable;
    private static final int menu_profile = R.id.menu_profile;
    private static final int menu_dashboard = R.id.menu_dashboard;
    private ImageButton button_logout;
    private FirebaseAuth mAuth;
    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Initialize FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();
        // Set onClickListener for logout button
        button_logout = findViewById(R.id.button_logout);
        button_logout.setOnClickListener(v -> logout());
        // Set onItemReselectedListener for bottom navigation
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == menu_timetable) {
                replaceFragment(new timetableFragment());
                return true;
            } else if (itemId == menu_profile) {
                replaceFragment(new profileFragment());
                return true;
            }else if (itemId == menu_dashboard) {
                replaceFragment(new DashboardFragment());
                return true;
            }
            else {
                Log.w("Welcome", "Unexpected item selected in bottom navigation: " + itemId);
                return true;
            }
        });
        // Add initial fragment (e.g., timetableFragment)
        replaceFragment(new DashboardFragment());
    }
    // Method to replace the current fragment with a new fragment
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation_menu, menu);
        return true;
    }

    private void logout() {
        Log.d("Logout", "Logging out...");
        mAuth.signOut();
        Intent intent = new Intent(Welcome.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish(); // Finish the current activity to prevent returning to it when pressing back
    }
}


