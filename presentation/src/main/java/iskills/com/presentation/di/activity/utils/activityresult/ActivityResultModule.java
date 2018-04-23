package iskills.com.presentation.di.activity.utils.activityresult;

import dagger.Module;
import dagger.Provides;
import iskills.com.presentation.di.scopes.ActivityScope;

/**
 * lennyhicks
 * 4/15/18
 */
@Module
public class ActivityResultModule {

    @ActivityScope
    @Provides
    ActivityResultListener activityResultListener(){
        return new ActivityResultListener();
    }
}
