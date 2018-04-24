package iskills.com.presentation.di.application.schedulers;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * lennyhicks
 * 4/9/18
 */
public class SchedulerImpl implements SchedulerPresenter {

    @Inject
    SchedulerImpl(){}

    @Override
    public Scheduler uiThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler mainThread() {
        return Schedulers.io();
    }
}
