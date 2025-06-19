package com.example.newsappfot;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText currentPassword, newPassword, repeatPassword;
    Button changePasswordButton;
    ImageView backArrow; // ✅ Back arrow icon

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        // ✅ Link views
        currentPassword = findViewById(R.id.currentPassword);
        newPassword = findViewById(R.id.newPassword);
        repeatPassword = findViewById(R.id.repeatNewPassword); // Corrected ID
        changePasswordButton = findViewById(R.id.changePasswordButton);
        backArrow = findViewById(R.id.backArrow);

        // ✅ Back arrow click: just finish to go back to UserProfileActivity
        backArrow.setOnClickListener(v -> {
            finish();
        });

        // ✅ Change password button logic
        changePasswordButton.setOnClickListener(v -> {
            String current = currentPassword.getText().toString().trim();
            String newPass = newPassword.getText().toString().trim();
            String repeat = repeatPassword.getText().toString().trim();

            if (current.isEmpty() || newPass.isEmpty() || repeat.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!newPass.equals(repeat)) {
                Toast.makeText(this, "New passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: Call your real password update logic here
            Toast.makeText(this, "Password Changed Successfully (demo)", Toast.LENGTH_SHORT).show();
        });
    }
}
