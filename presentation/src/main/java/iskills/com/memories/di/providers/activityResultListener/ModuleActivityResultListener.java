package iskills.com.memories.di.providers.activityResultListener;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.di.scopes.ScopeAndroid;

/**
 * lennyhicks
 * 4/5/18
 */

@Module
public class ModuleActivityResultListener {

    @ScopeAndroid
    @Provides
    UtilsActivityResultListener getModule(){
        return new UtilsActivityResultListener();
    }

}
