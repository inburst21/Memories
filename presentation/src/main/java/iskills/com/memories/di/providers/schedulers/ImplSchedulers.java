package iskills.com.memories.di.providers.schedulers;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * lennyhicks
 * 4/9/18
 */
public class ImplSchedulers implements ISchedulers {

    @Inject
    ImplSchedulers(){}

    public Scheduler uiThread() {
        return AndroidSchedulers.mainThread();
    }

    public Scheduler mainThread() {
        return Schedulers.io();
    }
}
