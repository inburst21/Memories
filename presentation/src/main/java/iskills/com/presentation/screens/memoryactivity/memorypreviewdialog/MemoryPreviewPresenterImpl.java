package iskills.com.presentation.screens.memoryactivity.memorypreviewdialog;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseGetMemoryById;
import iskills.com.presentation.di.application.schedulers.SchedulerPresenter;
import iskills.com.presentation.di.activity.navigator.PresenterNavigator;

/** lennyhicks 4/16/18 */
public class MemoryPreviewPresenterImpl implements MemoryPreviewPresenter {

  private CompositeDisposable disposable = new CompositeDisposable();
  private final MemoryPreviewView view;
  private final UseCaseGetMemoryById useCaseGetMemoryById;
  private final PresenterNavigator navigator;
  private final SchedulerPresenter schedulers;
  private Memory memory;

  @Inject
  public MemoryPreviewPresenterImpl(
      MemoryPreviewView view,
      UseCaseGetMemoryById useCaseGetMemoryById,
      PresenterNavigator navigator,
      SchedulerPresenter schedulers) {
    this.view = view;
    this.useCaseGetMemoryById = useCaseGetMemoryById;
    this.navigator = navigator;
    this.schedulers = schedulers;
  }

  @Override
  public void loadMemory(Long id) {
    disposable.add(useCaseGetMemoryById
            .getMemoryById(id)
            .subscribeOn(schedulers.mainThread())
            .observeOn(schedulers.uiThread())
            .subscribe(
                memoryFromRepo -> {
                  memory = memoryFromRepo;
                  view.setAddress(memory.address);
                  view.setDate(memory.memoryDate);
                  view.setTitle(memory.title);
                  view.setComment(memory.comment);
                  view.loadImage(memory.imageBytes);
                }));
  }

  @Override
  public void editMemory() {
    onClose();
    navigator.toEditMemoryScreen(memory.id);
  }

  @Override
  public void onClose() {
    disposable.dispose();
    view.dismiss();
  }
}
