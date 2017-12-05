package com.muelpatmore.firstapi.data.network.constants;


import com.muelpatmore.firstapi.data.network.constants.model.CakeModel;
import com.muelpatmore.firstapi.data.network.constants.services.RequestInterface;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 24/11/2017.
 */

@Singleton
public class AppApiHelper implements ApiHelper{

    private RequestInterface requestInterface;

    @Inject
    public AppApiHelper(RequestInterface requestInterface) {
        //requestInterface = ServerConnection.getServerConnection();
        this.requestInterface = requestInterface;
    }

    @Override
    public Observable<List<CakeModel>> getFromApi_CakeList() {
        return requestInterface.getCakesList();
    }
}
