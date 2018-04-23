package iskills.com.presentation.di.application;

import dagger.Module;
import iskills.com.presentation.di.application.schedulers.SchedulerModule;
import iskills.com.presentation.di.application.usecase.UseCaseModule;
import iskills.com.presentation.di.application.validator.ValidatorModule;

/** lennyhicks 4/14/18 */
@Module(includes = {
        SchedulerModule.class,
        ValidatorModule.class,
        UseCaseModule.class})
class ApplicationModule {}
