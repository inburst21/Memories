package iskills.com.memoriesrefactor.screens.memoryactivity;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import iskills.com.memoriesrefactor.di.activity.utils.activityresult.ActivityResultModule;
import iskills.com.memoriesrefactor.screens.adapters.AdapterMemoryViewPager;
import iskills.com.memoriesrefactor.screens.memoryactivity.bottomnavigation.BottomNavigationViewModule;

/**
 * lennyhicks
 * 4/15/18
 */
@Module(includes = {BottomNavigationViewModule.class, MainActivityFragments.class, ActivityResultModule.class})
public class MainActivityModule {

    @Provides
    Activity activity(MainActivity activity){
        return activity;
    }
    @Provides
    FragmentManager fragmentManager(MainActivity activity){
        return activity.getSupportFragmentManager();
    }

    @Provides
    AdapterMemoryViewPager getAdapter(FragmentManager fragmentManager){
        return new AdapterMemoryViewPager(fragmentManager);
    }
}
