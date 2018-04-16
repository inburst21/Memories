package iskills.com.memoriesrefactor.di.activity.utils.schedulers;

import io.reactivex.Scheduler;

/**
 * lennyhicks
 * 4/15/18
 */
public interface PresenterScheduler {

    Scheduler uiThread();

    Scheduler mainThread();
}
