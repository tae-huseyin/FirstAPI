package com.muelpatmore.firstapi.views.cakelist;

import com.muelpatmore.firstapi.data.IDataManager;

import com.muelpatmore.firstapi.data.network.constants.model.CakeModel;
import com.muelpatmore.firstapi.views.ui.base.BasePresenter;
import com.muelpatmore.firstapi.views.ui.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TheAppExperts on 24/11/2017.
 */

public class CakeListPresenter<V extends ICakeListMvpView>
        extends BasePresenter<V>
        implements ICakeListMvpPresenter<V> {

    @Inject
    public CakeListPresenter(IDataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onCallCakeList() {

        getCompositeDisposable().add(
                getDataManager().getFromApi_CakeList()
                .observeOn(getSchedulerProvider().ui())
                .subscribeOn(getSchedulerProvider().io())
                .subscribe(new Consumer<List<CakeModel>>() {
                    @Override
                    public void accept(List<CakeModel> cakeModels) throws Exception {
                        getMvpView().onFetchDataSuccess(cakeModels);
                    }
                },
                        new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }
}
