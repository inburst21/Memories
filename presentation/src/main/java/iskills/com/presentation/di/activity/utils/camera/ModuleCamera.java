package iskills.com.presentation.di.activity.utils.camera;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 4/5/18
 */

@Module
public abstract class ModuleCamera {

    @Binds
    abstract PresenterCamera utilsCamera(UtilsCamera camera);
}
