package com.example.geolocation_application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geolocation_application.R;
import com.example.geolocation_application.model.Comments;

import org.w3c.dom.Comment;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>{
    private List<Comments> listComments;

    public CommentsAdapter(List<Comments> listComment) {
        this.listComments = listComments;
    }

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comments_viewholder, parent, false);

        return new CommentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {
        holder.layout.findViewById(R.id.cFundoLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.cPostId)).setText(Integer.toString(listComments.get(position).getPostId()));
        ((TextView) holder.layout.findViewById(R.id.cUserId)).setText(Integer.toString(listComments.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.cName)).setText(listComments.get(position).getName());
        ((TextView) holder.layout.findViewById(R.id.cEmail)).setText(listComments.get(position).getEmail());
        ((TextView) holder.layout.findViewById(R.id.cBody)).setText(listComments.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return listComments.size();
    }


    class CommentsViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public CommentsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}

