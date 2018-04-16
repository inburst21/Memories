package iskills.com.memoriesrefactor.di.application;

import dagger.Module;
import iskills.com.memoriesrefactor.di.activity.utils.date.ModuleDate;
import iskills.com.memoriesrefactor.di.activity.utils.schedulers.SchedulerModule;

/**
 * lennyhicks
 * 4/14/18
 */
@Module(includes = {SchedulerModule.class, ModuleDate.class})
public class ApplicationModule {

}
