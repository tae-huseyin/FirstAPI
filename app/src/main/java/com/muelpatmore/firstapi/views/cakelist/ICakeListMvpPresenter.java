package com.muelpatmore.firstapi.views.cakelist;

import com.muelpatmore.firstapi.views.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 24/11/2017.
 */

public interface ICakeListMvpPresenter<V extends ICakeListMvpView> extends MvpPresenter<V>{
    void onCallCakeList();

}
