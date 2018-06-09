package net.a6te.lazycoder.wallpapers;

import android.content.Context;
import android.support.v4.app.Fragment;

import net.a6te.lazycoder.wallpapers.MVP.MVPPresenter;
import net.a6te.lazycoder.wallpapers.MVP.MVPView;
import net.a6te.lazycoder.wallpapers.adapter.WallpaperAdapter;
import net.a6te.lazycoder.wallpapers.models.Category;

import java.util.ArrayList;

/**
 * Created by lazycoder on 3/7/18.
 */

public class CategoryDetailsPresenter implements MVPPresenter.CategoryDetailsPresenter{
    private net.a6te.lazycoder.wallpapers.MVP.MVPView.CategoryDetailsView MVPView;
    private Context context;
    private WallpaperAdapter adapter;
    private ArrayList<Category> categories;
    private Fragment fragment;

    public CategoryDetailsPresenter(Context context, Fragment fragment) {
        this.MVPView = (net.a6te.lazycoder.wallpapers.MVP.MVPView.CategoryDetailsView) fragment;
        this.context = context;
        categories = new ArrayList<>();
        this.fragment = fragment;
    }

    @Override
    public void prepareAdapter() {
        sampleData();
        adapter = new WallpaperAdapter(categories,context,fragment);
        MVPView.initializeRecyclerView(adapter);
    }

    public void sampleData(){
        categories.add(new Category("Movie",String.valueOf(R.drawable.img1)));
        categories.add(new Category("Nature",String.valueOf(R.drawable.img2)));
        categories.add(new Category("Photography",String.valueOf(R.drawable.img3)));
        categories.add(new Category("Study",String.valueOf(R.drawable.img4)));
        categories.add(new Category("Study",String.valueOf(R.drawable.img5)));
        categories.add(new Category("Study",String.valueOf(R.drawable.img6)));
    }
}
