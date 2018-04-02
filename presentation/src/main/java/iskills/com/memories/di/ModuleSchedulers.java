package iskills.com.memories.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import iskills.com.memories.di.qualifiers.MainThread;
import iskills.com.memories.di.qualifiers.UiThread;

/**
 * lennyhicks
 * 3/30/18
 */
@Module
class ModuleSchedulers {

    @Provides
    @UiThread
    @Singleton
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @MainThread
    @Singleton
    Scheduler provideMainThread() {
        return Schedulers.io();
    }

}
