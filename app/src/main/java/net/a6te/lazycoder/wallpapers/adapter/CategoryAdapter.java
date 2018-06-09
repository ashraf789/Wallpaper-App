package net.a6te.lazycoder.wallpapers.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.a6te.lazycoder.wallpapers.R;
import net.a6te.lazycoder.wallpapers.interfaces.OnItemClick;
import net.a6te.lazycoder.wallpapers.models.Category;

import java.util.List;

/**
 * Created by lazycoder on 3/5/18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<Category> categories;
    private Context context;
    private OnItemClick onItemClick;
    private Fragment fragment;

    public CategoryAdapter(List<Category> categories, Context context,Fragment fragment) {
        this.categories = categories;
        this.context = context;
        this.fragment = fragment;
        onItemClick = (OnItemClick) fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categorie_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d("TEST", "onBindViewHolder: "+position);
        final Category category = categories.get(position);

        holder.category.setText(categories.get(position).getName());
        Picasso.with(context)
                .load(Integer.valueOf(categories.get(position).getImageUrl()))
                .resize(600,600)
                .placeholder(R.drawable.banner)
                .into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onItemClickListener(category.getName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView category;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(View itemView) {

            super(itemView);
            category = itemView.findViewById(R.id.categoryTitleTv);
            imageView = itemView.findViewById(R.id.categoryIv);
            cardView = itemView.findViewById(R.id.categoryCV);
        }
    }
}
