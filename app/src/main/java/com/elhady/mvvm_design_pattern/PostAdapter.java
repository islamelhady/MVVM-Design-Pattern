package com.elhady.mvvm_design_pattern;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    public void setMoviesList(ArrayList<Post> moviesList) {
        this.moviesList = moviesList;
    }

    private ArrayList<Post> moviesList = new ArrayList<>();

    public PostAdapter(ArrayList<Post> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.body.setText(moviesList.get(position).getBody());
        holder.title.setText(moviesList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView title,body;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);

        }
    }
}
