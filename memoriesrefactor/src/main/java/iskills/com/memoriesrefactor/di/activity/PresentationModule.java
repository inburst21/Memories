package iskills.com.memoriesrefactor.di.activity;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.memoriesrefactor.di.activity.utils.android.ModuleAndroid;
import iskills.com.memoriesrefactor.di.activity.utils.date.ModuleDate;
import iskills.com.memoriesrefactor.di.activity.utils.location.ModuleLocation;
import iskills.com.memoriesrefactor.di.scopes.ActivityScope;
import iskills.com.memoriesrefactor.di.services.navigator.ModuleNavigator;
import iskills.com.memoriesrefactor.screens.memoryactivity.MainActivity;
import iskills.com.memoriesrefactor.screens.memoryactivity.MainActivityModule;
import iskills.com.memoriesrefactor.screens.memoryactivity.bottomnavigation.BottomNavigationModule;
import iskills.com.memoriesrefactor.screens.updatememoryactivity.UpdateMemoryActivity;
import iskills.com.memoriesrefactor.screens.updatememoryactivity.UpdateMemoryModule;

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
