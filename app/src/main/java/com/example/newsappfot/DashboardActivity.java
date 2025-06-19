package com.example.newsappfot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private TextView tabTech, tabSport, tabAcademic, tabFacultyEvents;
    private ImageView featuredImage;
    private RecyclerView topStoriesRecyclerView;
    private TopStoriesAdapter adapter;
    private BottomNavigationView bottomNavigationView;  // ✅ Bottom Navigation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        // ✅ Find views by ID
        tabTech = findViewById(R.id.tabTech);
        tabSport = findViewById(R.id.tabSport);
        tabAcademic = findViewById(R.id.tabAcademic);
        tabFacultyEvents = findViewById(R.id.tabFacultyEvents);
        featuredImage = findViewById(R.id.featuredImage);
        topStoriesRecyclerView = findViewById(R.id.topStoriesRecyclerView);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // ✅ Setup RecyclerView layout
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ✅ Load default content
        loadDashboard("Tech");

        // ✅ Tab click listeners
        tabTech.setOnClickListener(v -> loadDashboard("Tech"));
        tabSport.setOnClickListener(v -> loadDashboard("Sport"));
        tabAcademic.setOnClickListener(v -> loadDashboard("Academic"));
        tabFacultyEvents.setOnClickListener(v -> loadDashboard("Faculty Events"));

        // ✅ BottomNavigation click handler
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                // Already on Home
                return true;
            } else if (id == R.id.nav_explore) {
                startActivity(new Intent(this, NewsFeedActivity.class));
                return true;
            } else if (id == R.id.nav_bookmark) {
                startActivity(new Intent(this, BookmarkActivity.class));
                return true;
            } else if (id == R.id.nav_profile) {
                // 👉 IMPORTANT: Make sure UserProfileActivity is declared in your Manifest!
                startActivity(new Intent(this, UserProfileActivity.class));
                return true;
            } else {
                return false;
            }
        });

        // ✅ Set Home selected by default
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }

    private void loadDashboard(String category) {
        // ✅ Update featured image safely
        try {
            switch (category) {
                case "Tech":
                    featuredImage.setImageResource(R.drawable.tech_banner);
                    break;
                case "Sport":
                    featuredImage.setImageResource(R.drawable.sport_banner);
                    break;
                case "Academic":
                    featuredImage.setImageResource(R.drawable.academic_banner);
                    break;
                case "Faculty Events":
                    featuredImage.setImageResource(R.drawable.faculty_banner);
                    break;
                default:
                    featuredImage.setImageResource(R.drawable.uoc_background);
                    break;
            }
        } catch (Exception e) {
            featuredImage.setImageResource(R.drawable.uoc_background);
        }

        // ✅ Update top stories list
        List<TopStory> stories = new ArrayList<>();
        switch (category) {
            case "Tech":
                stories.add(new TopStory("Student of the Year - General Convocation 2020",
                        "University of Colombo, Sri Lanka",
                        "Jul 13, 2020 • 2 min read",
                        R.drawable.uoc_background));
                stories.add(new TopStory("Uni non-academic staff launch satyagraha campaign",
                        "Staff Union",
                        "Jul 20, 2025 • 6 min read",
                        R.drawable.uoc_background));
                stories.add(new TopStory("Edith Cowan University Delegation Fosters Collaboration",
                        "International Relations",
                        "Jul 25, 2025 • 5 min read",
                        R.drawable.uoc_background));
                break;
            case "Sport":
                stories.add(new TopStory("Inter-Faculty Football Championship",
                        "University Stadium",
                        "Aug 1, 2025 • 4 min read",
                        R.drawable.sport_image));
                stories.add(new TopStory("Annual Swimming Gala",
                        "Swimming Complex",
                        "Sep 5, 2025 • 3 min read",
                        R.drawable.sport_image));
                break;
            case "Academic":
                stories.add(new TopStory("Research Symposium 2025",
                        "Faculty of Science",
                        "Oct 10, 2025 • 5 min read",
                        R.drawable.academic_image));
                stories.add(new TopStory("Guest Lecture Series",
                        "Auditorium Hall",
                        "Oct 15, 2025 • 2 min read",
                        R.drawable.academic_image));
                break;
            default:
                stories.add(new TopStory("Annual Faculty Day",
                        "Faculty of Arts",
                        "Nov 12, 2025 • 3 min read",
                        R.drawable.faculty_image));
                stories.add(new TopStory("Faculty Awards Ceremony",
                        "Main Hall",
                        "Dec 1, 2025 • 4 min read",
                        R.drawable.faculty_image));
                break;
        }

        // ✅ Bind to adapter
        adapter = new TopStoriesAdapter(this, stories);
        topStoriesRecyclerView.setAdapter(adapter);

        // ✅ Update tab highlights
        updateTabColors(category);
    }

    private void updateTabColors(String selected) {
        int activeColor = Color.parseColor("#FF6B35");
        int defaultColor = Color.parseColor("#888888");

        tabTech.setTextColor(selected.equals("Tech") ? activeColor : defaultColor);
        tabSport.setTextColor(selected.equals("Sport") ? activeColor : defaultColor);
        tabAcademic.setTextColor(selected.equals("Academic") ? activeColor : defaultColor);
        tabFacultyEvents.setTextColor(selected.equals("Faculty Events") ? activeColor : defaultColor);
    }
}
