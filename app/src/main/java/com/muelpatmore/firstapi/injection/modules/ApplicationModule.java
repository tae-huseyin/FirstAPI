package com.muelpatmore.firstapi.injection.modules;

import android.app.Application;
import android.content.Context;

import com.muelpatmore.firstapi.data.AppDataManager;
import com.muelpatmore.firstapi.data.IDataManager;
import com.muelpatmore.firstapi.data.network.constants.ApiHelper;
import com.muelpatmore.firstapi.data.network.constants.AppApiHelper;
import com.muelpatmore.firstapi.injection.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TheAppExperts on 28/11/2017.
 */
@Module //step1
public class ApplicationModule {
    /*
    * application context
    * datamanager
    * apihelper
    *
    * */

    Application application;

    public ApplicationModule(Application application)
    {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context getContext()
    {
        return application;
    }

    @Provides
    Application getApplication()
    {
        return  application;
    }

    @Provides
    @Singleton
    IDataManager getDataManager(AppDataManager appDataManager)
    {
        return appDataManager;
    }


    @Provides
    @Singleton
    ApiHelper getApiHelper(AppApiHelper appApiHelper)
    {
        return appApiHelper;
    }

}
