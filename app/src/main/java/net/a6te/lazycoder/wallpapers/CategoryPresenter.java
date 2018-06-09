package net.a6te.lazycoder.wallpapers;

import android.support.v4.app.Fragment;
import android.content.Context;

import net.a6te.lazycoder.wallpapers.MVP.MVPPresenter;
import net.a6te.lazycoder.wallpapers.MVP.MVPView;
import net.a6te.lazycoder.wallpapers.adapter.CategoryAdapter;
import net.a6te.lazycoder.wallpapers.models.Category;

import java.util.ArrayList;

/**
 * Created by lazycoder on 3/5/18.
 */

public class CategoryPresenter implements MVPPresenter.CategoryPresenter {

    private MVPView.CategoryView MVPView;
    private Context context;
    private CategoryAdapter adapter;
    private ArrayList<Category> categories;
    private Fragment fragment;

    public CategoryPresenter(Context context, Fragment fragment) {
        this.MVPView = (net.a6te.lazycoder.wallpapers.MVP.MVPView.CategoryView) fragment;
        this.context = context;
        this.fragment = fragment;
        categories = new ArrayList<>();
    }

    @Override
    public void prepareAdapter() {
        sampleData();
        adapter = new CategoryAdapter(categories,context,fragment);
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
