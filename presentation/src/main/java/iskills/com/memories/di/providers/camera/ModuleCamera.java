package iskills.com.memories.di.providers.camera;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.MainActivity;
import iskills.com.memories.di.providers.fileProviders.FileUtils;
import iskills.com.memories.di.scopes.ScopeAndroid;

/**
 * lennyhicks
 * 4/5/18
 */

@Module
public class ModuleCamera {

    @ScopeAndroid
    @Provides
    PresenterCamera utilsCamera(MainActivity activity, FileUtils fileUtils){
        return new UtilsCamera(activity, fileUtils);
    }
}
