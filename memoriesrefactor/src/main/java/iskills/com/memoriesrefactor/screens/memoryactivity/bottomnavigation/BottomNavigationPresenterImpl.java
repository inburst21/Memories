package iskills.com.memoriesrefactor.screens.memoryactivity.bottomnavigation;

import javax.inject.Inject;

import iskills.com.memoriesrefactor.di.services.navigator.PresenterNavigator;

/** lennyhicks 4/14/18 */
public class BottomNavigationPresenterImpl implements BottomNavigationPresenter {

  private final PresenterNavigator navigator;

  @Inject
  public BottomNavigationPresenterImpl(PresenterNavigator navigator) {
    this.navigator = navigator;
  }

  @Override
  public void onAddMemoryTapped() {
    navigator.toUploadScreen();
  }

  @Override
  public void onMemoryGridTapped() {
    navigator.toMemoriesScreen();
  }

  @Override
  public void onMemoryMapTapped() {
    navigator.toMapScreen();
  }
}
