package iskills.com.presentation.di.activity;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.presentation.di.activity.utils.android.AndroidModule;
import iskills.com.presentation.di.activity.utils.camera.CameraModule;
import iskills.com.presentation.di.activity.utils.date.DateModule;
import iskills.com.presentation.di.activity.utils.fileProviders.FileUtilModule;
import iskills.com.presentation.di.activity.utils.location.LocationModule;
import iskills.com.presentation.di.scopes.ActivityScope;
import iskills.com.presentation.di.activity.navigator.ModuleNavigator;
import iskills.com.presentation.screens.memoryactivity.MainActivity;
import iskills.com.presentation.screens.memoryactivity.MainActivityModule;
import iskills.com.presentation.screens.memoryactivity.bottomnavigation.BottomNavigationModule;
import iskills.com.presentation.screens.updatememoryactivity.UpdateMemoryActivity;
import iskills.com.presentation.screens.updatememoryactivity.UpdateMemoryModule;

/**
 * lennyhicks
 * 4/15/18
 */
@Module(includes = {
        AndroidModule.class,
        LocationModule.class,
        DateModule.class,
        ModuleNavigator.class,
        CameraModule.class,
        FileUtilModule.class})
public abstract class PresentationModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = { MainActivityModule.class, BottomNavigationModule.class})
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = UpdateMemoryModule.class)
    abstract UpdateMemoryActivity updateMemoryActivity();

}
