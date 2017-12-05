package com.muelpatmore.firstapi.views.cakelist;

import com.muelpatmore.firstapi.data.network.constants.model.CakeModel;
import com.muelpatmore.firstapi.views.ui.base.MvpView;

import java.util.List;

/**
 * Created by TheAppExperts on 24/11/2017.
 */

public interface ICakeListMvpView extends MvpView{

    void onFetchDataSuccess(List<CakeModel> cakeModels);
    void onFetchDataError(String message);

}
