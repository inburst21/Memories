package iskills.com.memoriesrefactor.di.activity;


import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import iskills.com.memoriesrefactor.di.activity.utils.android.ModuleAndroid;
import iskills.com.memoriesrefactor.screens.memoryactivity.MainActivity;
import iskills.com.memoriesrefactor.screens.memoryactivity.MainActivityModule;
import iskills.com.memoriesrefactor.screens.updatememoryactivity.UpdateMemoryActivity;

/**
 * lennyhicks
 * 4/15/18
 */
@Module(includes = {AndroidInjectionModule.class, ModuleAndroid.class})
public abstract class PresentationModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = UpdateMemoryActivity.class)
    abstract UpdateMemoryActivity updateMemoryActivity();

}
