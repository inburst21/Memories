package iskills.com.presentation.screens.updatememoryactivity;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

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

}
