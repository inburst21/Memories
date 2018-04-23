package iskills.com.presentation.di.services.navigator;

import dagger.Binds;
import dagger.Module;

/** lennyhicks 4/4/18 */
@Module
public abstract class ModuleNavigator {

  @Binds
  abstract PresenterNavigator navigator(Navigator navigator);
}
