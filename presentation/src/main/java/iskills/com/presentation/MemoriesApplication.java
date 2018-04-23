package iskills.com.presentation;

import android.app.Activity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerApplication;
import iskills.com.presentation.di.application.DaggerApplicationComponent;

/**
 * lennyhicks
 * 4/14/18
 */
public class MemoriesApplication extends DaggerApplication {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
    }

}
