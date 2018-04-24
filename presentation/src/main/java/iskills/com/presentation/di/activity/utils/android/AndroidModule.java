package iskills.com.presentation.di.activity.utils.android;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 4/15/18
 */
@Module
public abstract class AndroidModule {
    @Binds
    abstract AndroidPresenter presenterAndroid(AndroidImpl implAndroid);
}
