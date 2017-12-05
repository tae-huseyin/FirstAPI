package com.muelpatmore.firstapi.data.network.constants.services;

import com.muelpatmore.firstapi.data.network.constants.constant.API_List;
import com.muelpatmore.firstapi.data.network.constants.model.CakeModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Samuel on 22/11/2017.
 */

public interface RequestInterface {

    @GET(API_List.CAKE_LIST_API)
    // ensure Observable if from reactivex library (unless data is >1,000)
    // List as JSON schema starts with an array ( '[' )
    Observable<List<CakeModel>> getCakesList();
}
