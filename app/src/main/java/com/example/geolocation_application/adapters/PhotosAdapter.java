package com.example.geolocation_application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.geolocation_application.R;
import com.example.geolocation_application.model.Photos;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {
    private List<Photos> listPhoto;

    public PhotosAdapter(List<Photos> listPhoto) {
        this.listPhoto = listPhoto;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_photos_viewholder, parent, false);

        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.layout.findViewById(R.id.pFundoLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.photosAlbumId)).setText(Integer.toString(listPhoto.get(position).getAlbumId()));
        ((TextView) holder.layout.findViewById(R.id.photosId)).setText(Integer.toString(listPhoto.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.photosTitle)).setText(listPhoto.get(position).getTitle());
        ((TextView) holder.layout.findViewById(R.id.photosUrl)).setText(listPhoto.get(position).getUrl());
        ((TextView) holder.layout.findViewById(R.id.photosThumbnailUrl)).setText(listPhoto.get(position).getThumbnailUrl());
    }

    @Override
    public int getItemCount() {
        return listPhoto.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
