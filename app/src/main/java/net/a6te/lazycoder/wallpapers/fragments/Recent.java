package net.a6te.lazycoder.wallpapers.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.a6te.lazycoder.wallpapers.CategoryPresenter;
import net.a6te.lazycoder.wallpapers.MVP.MVPPresenter;
import net.a6te.lazycoder.wallpapers.MVP.MVPView;
import net.a6te.lazycoder.wallpapers.R;
import net.a6te.lazycoder.wallpapers.RecentPresenter;
import net.a6te.lazycoder.wallpapers.Utility;
import net.a6te.lazycoder.wallpapers.activity.FullscreenActivity;
import net.a6te.lazycoder.wallpapers.interfaces.OnItemClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class Recent extends Fragment implements MVPView.RecentView, OnItemClick{

    private View view;
    private MVPPresenter.RecentlyPresenter presenter;
    private RecyclerView recyclerView;
    private Context context;
    private Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_recent, container, false);

        initializeAll();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        return view;
    }

    private void initializeAll() {
        fragment = this;
        recyclerView = view.findViewById(R.id.recentRv);
        presenter = new RecentPresenter(context,fragment );
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
        startActivity(new Intent(getActivity(), FullscreenActivity.class).putExtra(Utility.IMAGE_URL, data));
    }
}
