package com.muelpatmore.firstapi.injection.components;

import android.app.Application;
import android.content.Context;

import com.muelpatmore.firstapi.MyApp;
import com.muelpatmore.firstapi.data.IDataManager;
import com.muelpatmore.firstapi.data.network.constants.ApiHelper;
import com.muelpatmore.firstapi.injection.modules.ApplicationModule;
import com.muelpatmore.firstapi.injection.modules.NetworkModule;
import com.muelpatmore.firstapi.injection.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TheAppExperts on 28/11/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    void inject(MyApp myApp);

    @ApplicationContext
    Context context();

    Application application();

    IDataManager getDataManager();

    //void inject(ServerConnection serverConnection);
    ApiHelper getApiHelper();
}
