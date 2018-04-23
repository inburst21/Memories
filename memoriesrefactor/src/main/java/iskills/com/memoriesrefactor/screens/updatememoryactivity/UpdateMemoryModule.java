package iskills.com.memoriesrefactor.screens.updatememoryactivity;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import iskills.com.memoriesrefactor.screens.adapters.AdapterMemoryViewPager;

/**
 * lennyhicks
 * 4/15/18
 */
@Module(includes = UpdateMemoryFragment.class)
public class UpdateMemoryModule {

    @Provides
    Activity activity(UpdateMemoryActivity activity){
        return activity;
    }

    @Provides
    FragmentManager fragmentManager(UpdateMemoryActivity activity){
        return activity.getSupportFragmentManager();
    }

    @Provides
    AdapterMemoryViewPager getAdapter(FragmentManager fragmentManager){
        return new AdapterMemoryViewPager(fragmentManager);
    }
}
