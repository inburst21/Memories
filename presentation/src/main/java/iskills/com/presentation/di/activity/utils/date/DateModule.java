package iskills.com.presentation.di.activity.utils.date;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 4/3/18
 */
@Module
public abstract class DateModule {

    @Binds
    abstract DatePresenter presenterDate(DateUtils utilsDate);

}
