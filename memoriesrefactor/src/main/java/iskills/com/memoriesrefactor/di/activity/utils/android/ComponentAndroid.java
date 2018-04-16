package iskills.com.memoriesrefactor.di.activity.utils.android;

import dagger.Component;
import iskills.com.memoriesrefactor.di.activity.PresentationComponent;
import iskills.com.memoriesrefactor.di.scopes.ProviderScope;

/**
 * lennyhicks
 * 4/15/18
 */

@ProviderScope
@Component(modules = ModuleAndroid.class, dependencies = PresentationComponent.class)
public interface ComponentAndroid {
    PresenterAndroid presenter();
}
