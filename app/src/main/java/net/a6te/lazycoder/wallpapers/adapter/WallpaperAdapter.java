package net.a6te.lazycoder.wallpapers.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.a6te.lazycoder.wallpapers.R;
import net.a6te.lazycoder.wallpapers.interfaces.OnItemClick;
import net.a6te.lazycoder.wallpapers.models.Category;

import java.util.ArrayList;

/**
 * Created by lazycoder on 3/6/18.
 */

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.ViewHolder> {

    private ArrayList<Category> categories;
    private Context context;
    private OnItemClick onItemClick;

    public WallpaperAdapter(ArrayList<Category> categories, Context context,Fragment fragment) {
        this.categories = categories;
        this.context = context;
        onItemClick = (OnItemClick) fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wallpaper_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Picasso.with(context)
                .load(Integer.valueOf(categories.get(position).getImageUrl()))
                .resize(600,600)
                .placeholder(R.drawable.banner)
                .into(holder.wallpaperIv);

        holder.wallpaperCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onItemClickListener(categories.get(position).getImageUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView wallpaperIv;
        CardView wallpaperCV;

        public ViewHolder(View itemView) {
            super(itemView);
            wallpaperIv = itemView.findViewById(R.id.popularIv);
            wallpaperCV = itemView.findViewById(R.id.wallpaperCV);
        }
    }
}
