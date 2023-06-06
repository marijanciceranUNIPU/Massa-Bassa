package com.hr.unipu.MassaBassa;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ManualsVideosAdapter extends RecyclerView.Adapter<ManualsVideosAdapter.ViewHolder> {

    private List<ManualVideoItem> manualVideoList;

    public ManualsVideosAdapter(List<ManualVideoItem> manualVideoList) {
        this.manualVideoList = manualVideoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manual_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ManualVideoItem item = manualVideoList.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.descriptionTextView.setText(item.getDescription());

        // Prikazivanje thumbnaila videa pomoću Glide biblioteke
        Glide.with(holder.itemView.getContext())
                .load(item.getThumbnailUrl())  // URL pretpregleda (thumbnail)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.placeholder)
                        .error(R.drawable.error)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(holder.thumbnailImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrlInBrowser(item.getUrl(), holder.itemView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return manualVideoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        ImageView thumbnailImageView;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            thumbnailImageView = itemView.findViewById(R.id.thumbnailImageView);
        }
    }

    private void openUrlInBrowser(String url, View itemView) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        itemView.getContext().startActivity(intent);
    }
}