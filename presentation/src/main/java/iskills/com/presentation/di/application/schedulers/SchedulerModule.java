package iskills.com.presentation.di.application.schedulers;

import dagger.Binds;
import dagger.Module;
import iskills.com.presentation.di.scopes.ApplicationScope;

/**
 * lennyhicks
 * 3/30/18
 */
@Module
public abstract class SchedulerModule {

    @ApplicationScope
    @Binds
    abstract SchedulerPresenter getSchedulers(SchedulerImpl schedulerImpl);

}
