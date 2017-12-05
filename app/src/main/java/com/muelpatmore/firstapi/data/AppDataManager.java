package com.muelpatmore.firstapi.data;


import android.content.Context;

import com.muelpatmore.firstapi.data.network.constants.ApiHelper;
import com.muelpatmore.firstapi.data.network.constants.AppApiHelper;
import com.muelpatmore.firstapi.data.network.constants.model.CakeModel;
import com.muelpatmore.firstapi.injection.scope.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 24/11/2017.
 */

@Singleton //makesure
public class AppDataManager  implements IDataManager{

    private ApiHelper apiHelper;

    @Inject //makesure
    public AppDataManager(@ApplicationContext Context application, AppApiHelper appApiHelper){
        //apiHelper = new AppApiHelper();
        this.apiHelper = appApiHelper; //this
    }

    public Observable<List<CakeModel>> getFromApi_CakeList(){
        return apiHelper.getFromApi_CakeList();
    }
}
