package iskills.com.memories.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.memories.MainActivity;
import iskills.com.memories.di.providers.activityResultListener.ModuleActivityResultListener;
import iskills.com.memories.di.providers.camera.ModuleCamera;
import iskills.com.memories.di.providers.date.ModuleDate;
import iskills.com.memories.di.providers.fileProviders.ModuleFileUtils;
import iskills.com.memories.di.providers.location.ModuleLocation;
import iskills.com.memories.di.providers.navigator.ModuleNavigator;
import iskills.com.memories.di.providers.usecases.ModuleUseCases;
import iskills.com.memories.di.providers.utilsAndroid.ModuleUtilsAndroid;
import iskills.com.memories.di.scopes.ScopeAndroid;
import iskills.com.memories.ui.adapters.ModuleViewPager;

/**
 * lennyhicks
 * 4/2/18
 */
@Module
abstract class ModuleAndroid {

    @ScopeAndroid
    @ContributesAndroidInjector(modules = {
            ModuleLocation.class,
            ModuleViews.class,
            ModuleDate.class,
            ModuleNavigator.class,
            ModuleCamera.class,
            ModuleActivityResultListener.class,
            ModuleFileUtils.class,
            ModuleUtilsAndroid.class,
            ModuleViewPager.class,
            ModuleAppDb.class,
            ModuleUseCases.class})

    abstract MainActivity mainActivity();
}
