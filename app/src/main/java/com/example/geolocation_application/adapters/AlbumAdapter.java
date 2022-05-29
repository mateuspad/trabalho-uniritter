package com.example.geolocation_application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geolocation_application.model.Album;
import com.example.geolocation_application.R;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{
    private List<Album> listAlbum;

    public AlbumAdapter(List<Album> listAlbum) {
        this.listAlbum = listAlbum;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_album_viewholder, parent, false);

        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.layout.findViewById(R.id.layoutDoFundoDoAlbum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.albumUserId)).setText(Integer.toString(listAlbum.get(position).getUserId()));
        ((TextView) holder.layout.findViewById(R.id.albumId)).setText(Integer.toString(listAlbum.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.albumTitle)).setText(listAlbum.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return listAlbum.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
