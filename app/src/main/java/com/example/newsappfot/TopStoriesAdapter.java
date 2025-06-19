package com.example.newsappfot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoryViewHolder> {

    private Context context;
    private List<TopStory> stories;

    public TopStoriesAdapter(Context context, List<TopStory> stories) {
        this.context = context;
        this.stories = stories;
    }

    @NonNull
    @Override
    public TopStoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top_story, parent, false);
        return new TopStoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopStoryViewHolder holder, int position) {
        TopStory story = stories.get(position);
        holder.title.setText(story.getTitle());
        holder.subtitle.setText(story.getSubtitle());
        holder.date.setText(story.getDate());
        holder.image.setImageResource(story.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, NewsFeedActivity.class);
            intent.putExtra("title", story.getTitle());
            intent.putExtra("subtitle", story.getSubtitle());
            intent.putExtra("date", story.getDate());
            intent.putExtra("imageResId", story.getImageResId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public static class TopStoryViewHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle, date;
        ImageView image;

        public TopStoryViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.storyImage);
            title = itemView.findViewById(R.id.storyTitle);
            subtitle = itemView.findViewById(R.id.storySubtitle);
            date = itemView.findViewById(R.id.storyDate);
        }
    }
}
