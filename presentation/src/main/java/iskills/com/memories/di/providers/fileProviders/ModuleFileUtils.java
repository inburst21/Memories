package iskills.com.memories.di.providers.fileProviders;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.MainActivity;

/**
 * lennyhicks
 * 4/5/18
 */
@Module
public class ModuleFileUtils {

    @Provides
    FileUtils fileUtils(MainActivity activity) {
        return new FileUtils(activity);
    }

}
