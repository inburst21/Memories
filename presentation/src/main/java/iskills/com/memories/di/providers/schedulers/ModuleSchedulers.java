package iskills.com.memories.di.providers.schedulers;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 3/30/18
 */
@Module
public abstract class ModuleSchedulers {

    @Binds
    @Singleton
    abstract ISchedulers getSchedulers(ImplSchedulers implSchedulers);

}
