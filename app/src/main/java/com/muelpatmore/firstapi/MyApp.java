package com.muelpatmore.firstapi;

import android.app.Application;

import com.muelpatmore.firstapi.injection.components.ApplicationComponent;
import com.muelpatmore.firstapi.injection.components.DaggerApplicationComponent;
import com.muelpatmore.firstapi.injection.modules.ApplicationModule;

/**
 * Created by TheAppExperts on 28/11/2017.
 */

public class MyApp extends Application {
    ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {//dagger
        return applicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
