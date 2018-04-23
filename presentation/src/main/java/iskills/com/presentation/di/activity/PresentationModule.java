package iskills.com.presentation.di.activity;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.presentation.di.activity.utils.android.ModuleAndroid;
import iskills.com.presentation.di.activity.utils.date.ModuleDate;
import iskills.com.presentation.di.activity.utils.location.ModuleLocation;
import iskills.com.presentation.di.scopes.ActivityScope;
import iskills.com.presentation.di.services.navigator.ModuleNavigator;
import iskills.com.presentation.screens.memoryactivity.MainActivity;
import iskills.com.presentation.screens.memoryactivity.MainActivityModule;
import iskills.com.presentation.screens.memoryactivity.bottomnavigation.BottomNavigationModule;
import iskills.com.presentation.screens.updatememoryactivity.UpdateMemoryActivity;
import iskills.com.presentation.screens.updatememoryactivity.UpdateMemoryModule;

/**
 * lennyhicks
 * 4/15/18
 */
@Module(includes = {ModuleAndroid.class, ModuleLocation.class, ModuleDate.class, ModuleNavigator.class})
public abstract class PresentationModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = { MainActivityModule.class, BottomNavigationModule.class})
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = UpdateMemoryModule.class)
    abstract UpdateMemoryActivity updateMemoryActivity();

}
