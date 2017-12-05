package com.muelpatmore.firstapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.muelpatmore.firstapi.data.network.constants.model.CakeModel;
import com.muelpatmore.firstapi.injection.components.ActivityComponent;
import com.muelpatmore.firstapi.injection.components.DaggerActivityComponent;
import com.muelpatmore.firstapi.injection.modules.ActivityModule;
import com.muelpatmore.firstapi.views.cakelist.CakeListPresenter;
import com.muelpatmore.firstapi.views.cakelist.ICakeListMvpView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


//appdatamanager @inject
//listpresenter
//@singleton for only 1 instance


public class MainActivity extends AppCompatActivity implements ICakeListMvpView{

    //private ArrayList<CakeModel> mCakeList;
    //private RecyclerView recyclerView;
    @Inject
    CakeListPresenter<MainActivity> cakeListPresenter;

    ActivityComponent activityComponent;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public void injectDagger()
    {
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MyApp)getApplicationContext()).getApplicationComponent())
                .build();

        activityComponent.inject(this);
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public void setActivityComponent(ActivityComponent activityComponent) {
        this.activityComponent = activityComponent;
    }

    public void initRecyclerView() {
        //recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Log.d("initRecyclerView", recyclerView.toString());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Log.d("initRecyclerView", recyclerView.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectDagger();
        ButterKnife.bind(this);
        initRecyclerView();
        initializePresenter();

        cakeListPresenter.onCallCakeList();

    }

    public void initializePresenter()
    {
        //cakeListPresenter = new CakeListPresenter<>(new AppDataManager(), new AppSchedulerProvider(), new CompositeDisposable());
        cakeListPresenter.onAttach(this);
    }

    private void getAPIData()
    {

    }

    @Override
    public void onFetchDataSuccess(List<CakeModel> cakeModels) {

        // give data, model and view.
        recyclerView.setAdapter(new CakeAdapter((ArrayList<CakeModel>) cakeModels, R.layout.cake_item, getApplicationContext()));
        Log.d("initRecyclerView", recyclerView.toString());
    }

    @Override
    public void onFetchDataError(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
