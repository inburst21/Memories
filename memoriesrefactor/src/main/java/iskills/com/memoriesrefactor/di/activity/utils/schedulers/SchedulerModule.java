package iskills.com.memoriesrefactor.di.activity.utils.schedulers;

import dagger.Binds;
import dagger.Module;
import iskills.com.memoriesrefactor.di.scopes.ApplicationScope;

/**
 * lennyhicks
 * 3/30/18
 */
@Module
public abstract class SchedulerModule {

    @ApplicationScope
    @Binds
    abstract PresenterScheduler getSchedulers(ImplSchedulers implSchedulers);

}
