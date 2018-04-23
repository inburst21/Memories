package iskills.com.presentation.screens.memoryactivity.memorygrid;

import javax.inject.Inject;

import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.presentation.di.application.schedulers.PresenterScheduler;
import iskills.com.presentation.screens.common.BasePresenter;

/** lennyhicks 4/1/18 */
public class MemoryGridPresenterImpl extends BasePresenter<MemoryGridView>
    implements MemoryGridPresenter {
  private final UseCaseGetAllMemories useCaseGetAllMemories;
  private final PresenterScheduler schedulers;

  @Inject
  MemoryGridPresenterImpl(
      MemoryGridView view,
      UseCaseGetAllMemories useCaseGetAllMemories,
      PresenterScheduler schedulers) {
    super(view);
    this.useCaseGetAllMemories = useCaseGetAllMemories;
    this.schedulers = schedulers;
  }

  @Override
  public void getAllMemories() {
    addDisposable(
        useCaseGetAllMemories
            .getAllMemories()
            .subscribeOn(schedulers.mainThread())
            .observeOn(schedulers.uiThread())
            .subscribe(
                list -> view.updateList(list),
                throwable -> view.showError(throwable.getLocalizedMessage())));
  }
}
