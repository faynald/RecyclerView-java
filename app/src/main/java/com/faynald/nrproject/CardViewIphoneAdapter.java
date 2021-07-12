package com.faynald.nrproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.BreakIterator;
import java.util.ArrayList;

public class CardViewIphoneAdapter extends RecyclerView.Adapter<CardViewIphoneAdapter.CardViewHolder> {
    private ArrayList<iphone> listIphone;

    public CardViewIphoneAdapter(ArrayList<iphone> list){
        this.listIphone = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_iphone, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        iphone ipin = listIphone.get(position);

        Glide.with(holder.itemView.getContext())
                .load(ipin.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(ipin.getName());
        holder.tvDetail.setText(ipin.getDetail());

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite " + listIphone.get(holder.getBindingAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Share " + listIphone.get(holder.getBindingAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), listIphone.get(holder.getBindingAdapterPosition()).getName() + " Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listIphone.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;
        public TextView tvName, tvDetail;
        public Button btnFavorite, btnShare;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnFavorite = itemView.findViewById(R.id.button_favorite);
            btnShare = itemView.findViewById(R.id.button_share);
        }
    }
}
