package net.a6te.lazycoder.wallpapers.MVP;

import android.support.v7.widget.RecyclerView;

/**
 * Created by lazycoder on 3/5/18.
 */

public interface MVPView {
    interface CategoryView{
        void initializeRecyclerView(RecyclerView.Adapter adapter);
    }
    interface PopularView{
        void initializeRecyclerView(RecyclerView.Adapter adapter);
    }
    interface RecentView{
        void initializeRecyclerView(RecyclerView.Adapter adapter);
    }
    interface CategoryDetailsView{
        void initializeRecyclerView(RecyclerView.Adapter adapter);
    }


}
