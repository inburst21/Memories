package iskills.com.presentation.screens.memoryactivity;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import iskills.com.presentation.di.activity.utils.activityresult.ActivityResultModule;
import iskills.com.presentation.screens.adapters.AdapterMemoryViewPager;

/** lennyhicks 4/15/18 */
@Module(
  includes = {
    MainActivityFragments.class,
    ActivityResultModule.class
  }
)
public class MainActivityModule {

  @Provides
  Activity activity(MainActivity activity) {
    return activity;
  }

  @Provides
  FragmentManager fragmentManager(MainActivity activity) {
    return activity.getSupportFragmentManager();
  }

  @Provides
  AdapterMemoryViewPager getAdapter(FragmentManager fragmentManager) {
    return new AdapterMemoryViewPager(fragmentManager);
  }
}
