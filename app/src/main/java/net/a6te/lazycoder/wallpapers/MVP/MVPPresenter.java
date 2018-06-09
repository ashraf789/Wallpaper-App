package net.a6te.lazycoder.wallpapers.MVP;


/**
 * Created by lazycoder on 3/5/18.
 */

public interface MVPPresenter {

    interface CategoryPresenter{
        void prepareAdapter();
    }

    interface PopularPresenter{
        void prepareAdapter();
    }

    interface RecentlyPresenter{
        void prepareAdapter();
    }
    interface CategoryDetailsPresenter{
        void prepareAdapter();
    }



}
