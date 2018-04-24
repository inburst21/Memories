package iskills.com.presentation.di.application.schedulers;

import io.reactivex.Scheduler;

/**
 * lennyhicks
 * 4/15/18
 */
public interface SchedulerPresenter {

    Scheduler uiThread();

    Scheduler mainThread();
}
