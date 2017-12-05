package com.muelpatmore.firstapi.injection.components;

import com.muelpatmore.firstapi.MainActivity;
import com.muelpatmore.firstapi.injection.modules.ActivityModule;
import com.muelpatmore.firstapi.injection.scope.PerActivity;

import dagger.Component;

/**
 * Created by TheAppExperts on 28/11/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity); // change to what u want it to attach to
}
