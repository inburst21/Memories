package iskills.com.presentation.di.activity.utils.fileProviders;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 4/5/18
 */
@Module
public abstract class FileUtilModule {

    @Binds
    abstract FileUtilPresenter fileUtilPresenter(FileUtilImpl fileUtilImpl);

}
