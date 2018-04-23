package iskills.com.memoriesrefactor.di.application;

import dagger.Module;
import iskills.com.memoriesrefactor.di.application.schedulers.SchedulerModule;
import iskills.com.memoriesrefactor.di.application.usecase.UseCaseModule;
import iskills.com.memoriesrefactor.di.application.validator.ValidatorModule;

/** lennyhicks 4/14/18 */
@Module(includes = {
        SchedulerModule.class,
        ValidatorModule.class,
        UseCaseModule.class})
class ApplicationModule {}
