package iskills.com.presentation.screens.memoryactivity.memorymap;

import javax.inject.Inject;

import io.reactivex.Flowable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.domain.validators.MapMemoryValidator;
import iskills.com.presentation.di.application.schedulers.SchedulerPresenter;
import iskills.com.presentation.di.activity.navigator.PresenterNavigator;
import iskills.com.presentation.screens.common.BasePresenter;

/** lennyhicks 4/8/18 */
public class ViewMapPresenterImpl extends BasePresenter<MemoryMapView>
    implements MemoryMapPresenter {

  private final UseCaseGetAllMemories useCaseGetAllMemories;
  private final SchedulerPresenter schedulers;
  private final PresenterNavigator presenterNavigator;
  private final MapMemoryValidator mapMemoryValidator;

  @Inject
  ViewMapPresenterImpl(
      MemoryMapView view,
      UseCaseGetAllMemories useCaseGetAllMemories,
      SchedulerPresenter schedulers,
      PresenterNavigator presenterNavigator,
      MapMemoryValidator mapMemoryValidator) {
    super(view);
    this.useCaseGetAllMemories = useCaseGetAllMemories;
    this.schedulers = schedulers;
    this.presenterNavigator = presenterNavigator;
    this.mapMemoryValidator = mapMemoryValidator;
  }

  @Override
  public final void loadMemories() {
    addDisposable(
        useCaseGetAllMemories
            .getAllMemories()
            .subscribeOn(schedulers.mainThread())
            .flatMap(
                list -> {
                  for (Memory memory : list) {
                    addMemory(memory);
                  }
                  return Flowable.just(list);
                })
            .subscribe());
  }

  private void addMemory(final Memory memory) {
    if (mapMemoryValidator.validate(memory)) {
      view.addMemory(memory.id, memory.title, memory.comment, memory.lat, memory.lng);
    } else {
      view.showError("MemoryViewHolder was missing required components");
    }
  }

  @Override
  public final void onMemorySelected(long memoryId) {
    presenterNavigator.openPreviewDialog(memoryId);
  }
}
