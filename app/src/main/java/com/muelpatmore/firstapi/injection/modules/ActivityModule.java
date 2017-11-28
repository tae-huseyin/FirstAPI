package com.muelpatmore.firstapi.injection.modules;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.muelpatmore.firstapi.injection.scope.ActivityContext;
import com.muelpatmore.firstapi.views.cakelist.CakeListPresenter;
import com.muelpatmore.firstapi.views.cakelist.ICakeListMvpPresenter;
import com.muelpatmore.firstapi.views.cakelist.ICakeListMvpView;
import com.muelpatmore.firstapi.views.ui.utils.rx.AppSchedulerProvider;
import com.muelpatmore.firstapi.views.ui.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by TheAppExperts on 28/11/2017.
 */

@Module
public class ActivityModule {
    /*
    * Activity
    * Presenter
    * Scheduler
    * Disposable
    * */

    AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    Context getActivityContext()
    {
        return appCompatActivity;
    }

    @Provides
    AppCompatActivity getAppCompatActivity()
    {
        return appCompatActivity;
    }

    @Provides
    SchedulerProvider appSchedulerProvider()
    {
        return new AppSchedulerProvider();
    }

    @Provides
    CompositeDisposable getCompositeDisposable()
    {
        return new CompositeDisposable();
    }

    @Provides
    ICakeListMvpPresenter<ICakeListMvpView> getCakeListPresenter(CakeListPresenter<ICakeListMvpView> cakeListMvpViewCakeListPresenter)
    {
        return cakeListMvpViewCakeListPresenter;
    }


}
