package net.a6te.lazycoder.wallpapers.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.a6te.lazycoder.wallpapers.CategoryPresenter;
import net.a6te.lazycoder.wallpapers.MVP.MVPPresenter;
import net.a6te.lazycoder.wallpapers.MVP.MVPView;
import net.a6te.lazycoder.wallpapers.R;
import net.a6te.lazycoder.wallpapers.Utility;
import net.a6te.lazycoder.wallpapers.activity.FullscreenActivity;
import net.a6te.lazycoder.wallpapers.adapter.CategoryAdapter;
import net.a6te.lazycoder.wallpapers.interfaces.OnItemClick;
import net.a6te.lazycoder.wallpapers.models.Category;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements MVPView.CategoryView, OnItemClick{


    private View view;
    private MVPPresenter.CategoryPresenter presenter;
    private RecyclerView recyclerView;
    private Context context;
    private Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_categories, container, false);
        initializeAll();
       return view;
    }

    private void initializeAll() {
        fragment = this;
        recyclerView = view.findViewById(R.id.categoryRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        presenter = (MVPPresenter.CategoryPresenter) new CategoryPresenter(context,fragment );

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.prepareAdapter();
    }

    @Override
    public void initializeRecyclerView(RecyclerView.Adapter adapter) {
        if (adapter != null){
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onItemClickListener(String data) {
        FragmentTransaction trans = getFragmentManager()
                .beginTransaction();
				/*
				 * IMPORTANT: We use the "root frame" defined in
				 * "root_fragment.xml" as the reference to replace fragment
				 */
        Fragment mFragment = new Popular();
        Bundle bundle = new Bundle();
        bundle.putString(Utility.CATEGORY,data);
        mFragment.setArguments(bundle);

        trans.replace(R.id.categoryRootFL, mFragment);
        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        trans.addToBackStack(null);

        trans.commit();
    }
}
