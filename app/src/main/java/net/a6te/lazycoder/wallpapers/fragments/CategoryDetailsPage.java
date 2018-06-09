package net.a6te.lazycoder.wallpapers.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.a6te.lazycoder.wallpapers.CategoryDetailsPresenter;
import net.a6te.lazycoder.wallpapers.MVP.MVPPresenter;
import net.a6te.lazycoder.wallpapers.MVP.MVPView;
import net.a6te.lazycoder.wallpapers.PopularPresenter;
import net.a6te.lazycoder.wallpapers.R;
import net.a6te.lazycoder.wallpapers.Utility;
import net.a6te.lazycoder.wallpapers.activity.FullscreenActivity;
import net.a6te.lazycoder.wallpapers.interfaces.OnItemClick;


public class CategoryDetailsPage extends Fragment implements MVPView.CategoryDetailsView, OnItemClick{


    private View rootView;
    private RecyclerView recyclerView;
    private Context context;
    private MVPPresenter.CategoryDetailsPresenter presenter;
    private RecyclerView.Adapter adapter;
    private Fragment fragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_category_details_page, container, false);
        initializeAll();

        return rootView;
    }

    private void initializeAll() {
        fragment = this;
        recyclerView = rootView.findViewById(R.id.categoryDetailsRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
        presenter = new CategoryDetailsPresenter(context,fragment);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.prepareAdapter();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void initializeRecyclerView(RecyclerView.Adapter adapter) {
        if (adapter != null){
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClickListener(String data) {
        startActivity(new Intent(getActivity(), FullscreenActivity.class).putExtra(Utility.IMAGE_URL, data));
    }
}
