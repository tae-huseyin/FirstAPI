package com.muelpatmore.firstapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCakeList = new ArrayList<CakeModel>();


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
                        mCakeList = new ArrayList<CakeModel>();
                        for(CakeModel c: value) {
                            Log.i("CakeList", c.getTitle());
                            mCakeList.add(c);
                        }

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
