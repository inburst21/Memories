package iskills.com.memories.di.providers.navigator;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.MainActivity;

/**
 * lennyhicks
 * 4/4/18
 */
@Module
public class ModuleNavigator {

    @Provides
    Navigator navigator(MainActivity mainActivity){
        return new Navigator(mainActivity);
    }

}
