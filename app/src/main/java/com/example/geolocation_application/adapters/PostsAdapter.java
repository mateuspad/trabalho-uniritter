package com.example.geolocation_application.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.geolocation_application.R;
import com.example.geolocation_application.model.Posts;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    private List<Posts> listPosts;

    public PostsAdapter(List<Posts> listPosts) {
        this.listPosts = listPosts;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_posts_viewholder, parent, false);

        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.layout.findViewById(R.id.layoutDoFundoDoPosts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.cPostsId)).setText(Integer.toString(listPosts.get(position).getUserId()));
        ((TextView) holder.layout.findViewById(R.id.postsBody)).setText(Integer.toString(listPosts.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.postsTitle)).setText(listPosts.get(position).getTitle());
        ((TextView) holder.layout.findViewById(R.id.postsBody)).setText(listPosts.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return listPosts.size();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
