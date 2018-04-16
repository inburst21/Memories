package iskills.com.memoriesrefactor.di.activity.utils.date;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 4/3/18
 */
@Module
public abstract class ModuleDate {

    @Binds
    abstract PresenterDate presenterDate(UtilsDate utilsDate);

}
