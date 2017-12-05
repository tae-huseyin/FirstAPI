package com.muelpatmore.firstapi.data.network.constants;


import com.muelpatmore.firstapi.data.network.constants.model.CakeModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 24/11/2017.
 */

public interface ApiHelper {
    Observable<List<CakeModel>> getFromApi_CakeList();
}
