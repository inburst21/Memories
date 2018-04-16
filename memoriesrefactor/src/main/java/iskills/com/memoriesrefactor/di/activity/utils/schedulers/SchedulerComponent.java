package iskills.com.memoriesrefactor.di.activity.utils.schedulers;

import dagger.Component;
import iskills.com.memoriesrefactor.di.scopes.ApplicationScope;

/**
 * lennyhicks
 * 4/9/18
 */
@ApplicationScope
@Component(modules = SchedulerModule.class)
public interface SchedulerComponent {
    PresenterScheduler schedulers();
}
