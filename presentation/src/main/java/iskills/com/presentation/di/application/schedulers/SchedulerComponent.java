package iskills.com.presentation.di.application.schedulers;

import dagger.Component;
import iskills.com.presentation.di.scopes.ApplicationScope;

/**
 * lennyhicks
 * 4/9/18
 */
@ApplicationScope
@Component(modules = SchedulerModule.class)
public interface SchedulerComponent {
    PresenterScheduler schedulers();
}
