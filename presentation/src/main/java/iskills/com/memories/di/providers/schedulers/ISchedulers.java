package iskills.com.memories.di.providers.schedulers;

import io.reactivex.Scheduler;

/**
 * lennyhicks
 * 4/9/18
 */
public interface ISchedulers {
    Scheduler uiThread();
    Scheduler mainThread();
}
