package com.example.consultants.week3daily4.UI.main;

import com.example.consultants.week3daily4.UI.base.BasePresenter;
import com.example.consultants.week3daily4.UI.base.BaseView;

public interface MainContract {

    //Communicate from presenter to the view
    interface View extends BaseView {

    }

    //Communicate from view to the presenter
    interface Presenter extends BasePresenter<View>{
        void playMusic();
        void pauseMusic();
        void stopMusic();
    }
}
