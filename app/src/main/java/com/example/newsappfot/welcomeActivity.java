package com.example.newsappfot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class welcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button exploreButton = findViewById(R.id.exploreButton);
        exploreButton.setOnClickListener(v -> {
            Intent intent = new Intent(welcomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Optional: Close WelcomeActivity
        });
    }
}