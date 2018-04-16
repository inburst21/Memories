package iskills.com.memoriesrefactor.di.activity.utils.android;

import dagger.Binds;
import dagger.Module;
import iskills.com.memoriesrefactor.di.activity.utils.camera.ModuleCamera;
import iskills.com.memoriesrefactor.di.activity.utils.fileProviders.ModuleFileUtils;

/**
 * lennyhicks
 * 4/15/18
 */
@Module(includes = {ModuleCamera.class, ModuleFileUtils.class})
public abstract class ModuleAndroid {

    @Binds
    abstract PresenterAndroid presenterAndroid(ImplAndroid implAndroid);
}
