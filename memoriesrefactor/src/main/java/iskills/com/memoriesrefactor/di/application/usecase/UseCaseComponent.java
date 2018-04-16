package iskills.com.memoriesrefactor.di.application.usecase;

import dagger.Subcomponent;
import iskills.com.memoriesrefactor.di.scopes.ActivityScope;

/**
 * lennyhicks
 * 4/15/18
 */

@ActivityScope
@Subcomponent(modules = UseCaseModule.class)
public interface UseCaseComponent {

}
