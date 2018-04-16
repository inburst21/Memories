package iskills.com.memoriesrefactor.di.activity;

import dagger.Component;
import iskills.com.memoriesrefactor.di.scopes.ActivityScope;

/**
 * lennyhicks
 * 4/15/18
 */

@ActivityScope
@Component(modules = PresentationModule.class)
public interface PresentationComponent {

}
