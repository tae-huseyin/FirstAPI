package com.muelpatmore.firstapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.muelpatmore.firstapi.services.RequestInterface;
import com.muelpatmore.firstapi.services.ServerConnection;
import com.muelpatmore.firstapi.util.constants.CakeModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RequestInterface requestInterface;

    private ArrayList<CakeModel> mCakeList;
    private RecyclerView recyclerView;


    public void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Log.d("initRecyclerView", recyclerView.toString());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Log.d("initRecyclerView", recyclerView.toString());

        // give data, model and view.
        recyclerView.setAdapter(new CakeAdapter(mCakeList, R.layout.cake_item, getApplicationContext()));
        Log.d("initRecyclerView", recyclerView.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCakeList = new ArrayList<CakeModel>();
        getAPIData();

        Log.i("onCreate()", "reading local cake list");
        for(CakeModel c : mCakeList) Log.i("local cake", c.getTitle());

        //initRecyclerView();

    }

    private void getAPIData() {
        requestInterface = ServerConnection.getServerConnection();
        requestInterface.getCakesList()
                .observeOn(AndroidSchedulers.mainThread())
                // ensure to reference plural Schedulers class
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<CakeModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<CakeModel> value) {
                        mCakeList = new ArrayList<>(value);
                        for(CakeModel c: value) {
                            Log.i("CakeList", c.getTitle());
                            //mCakeList.add(c);
                        }
                        Log.i("CakeList (local)", "size: "+mCakeList.size());
                        initRecyclerView();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
