package iskills.com.presentation.di.application.schedulers;

import io.reactivex.Scheduler;

/**
 * lennyhicks
 * 4/15/18
 */
public interface PresenterScheduler {

    Scheduler uiThread();

    Scheduler mainThread();
}
