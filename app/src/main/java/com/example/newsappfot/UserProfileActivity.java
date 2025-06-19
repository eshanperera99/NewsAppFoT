package com.example.newsappfot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {

    private Switch notificationsSwitch;
    private Button changeNameButton, changePasswordButton, emailAddressButton, signOutButton;
    private ImageView backArrow; // ✅ Back arrow icon

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile); // ✅ Make sure the XML file name is correct!

        // ✅ Find all views
        notificationsSwitch = findViewById(R.id.notificationsSwitch);
        changeNameButton = findViewById(R.id.changeNameButton);
        changePasswordButton = findViewById(R.id.changePasswordButton);
        emailAddressButton = findViewById(R.id.emailAddressButton);
        signOutButton = findViewById(R.id.signOutButton);
        backArrow = findViewById(R.id.backArrow); // ✅ Find back arrow

        // ✅ Back arrow should go back to previous screen
        if (backArrow != null) {
            backArrow.setOnClickListener(v -> onBackPressed());
        }

        // ✅ Notifications toggle listener
        notificationsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String status = isChecked ? "Enabled" : "Disabled";
            Toast.makeText(this, "Notifications " + status, Toast.LENGTH_SHORT).show();
        });

        // ✅ Change Name button
        changeNameButton.setOnClickListener(v -> {
            Toast.makeText(this, "Change Name Clicked", Toast.LENGTH_SHORT).show();
            // 👉 Optionally, open another activity here if needed
        });

        // ✅ Change Password button: open ChangePasswordActivity
        changePasswordButton.setOnClickListener(v -> {
            Intent intent = new Intent(UserProfileActivity.this, ChangePasswordActivity.class);
            startActivity(intent);
        });

        // ✅ Email Address button
        emailAddressButton.setOnClickListener(v -> {
            Toast.makeText(this, "Email Address Clicked", Toast.LENGTH_SHORT).show();
        });

        // ✅ Sign Out button: optional logout logic
        signOutButton.setOnClickListener(v -> {
            Toast.makeText(this, "Signing Out...", Toast.LENGTH_SHORT).show();
            // Example: go back to LoginActivity if needed
            // Intent intent = new Intent(UserProfileActivity.this, LoginActivity.class);
            // startActivity(intent);
            // finish();
        });
    }
}
