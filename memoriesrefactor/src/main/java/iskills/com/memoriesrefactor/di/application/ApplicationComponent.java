package iskills.com.memoriesrefactor.di.application;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import iskills.com.domain.repository.RepositoryMemory;
import iskills.com.memoriesrefactor.MemoriesApplication;
import iskills.com.memoriesrefactor.di.activity.PresentationModule;
import iskills.com.memoriesrefactor.di.activity.utils.date.PresenterDate;
import iskills.com.memoriesrefactor.di.activity.utils.schedulers.PresenterScheduler;
import iskills.com.memoriesrefactor.di.application.usecase.UseCaseComponent;
import iskills.com.memoriesrefactor.di.application.usecase.UseCaseModule;
import iskills.com.memoriesrefactor.di.scopes.ApplicationScope;

/**
 * lennyhicks
 * 4/14/18
 */

@ApplicationScope
@Component(modules = {
        ApplicationModule.class,
        DatabaseModule.class,
        AndroidSupportInjectionModule.class,
        PresentationModule.class,
        UseCaseModule.class})

public interface ApplicationComponent extends AndroidInjector<MemoriesApplication> {

    Application app();
    RepositoryMemory repo();
    UseCaseComponent useCases();
    PresenterScheduler scheduler();
    PresenterDate date();

    @Component.Builder
    interface Builder {
        @BindsInstance
        ApplicationComponent.Builder application(Application application);
        ApplicationComponent build();
    }
}
