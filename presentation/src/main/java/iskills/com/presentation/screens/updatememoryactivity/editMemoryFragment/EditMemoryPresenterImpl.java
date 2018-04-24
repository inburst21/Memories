package iskills.com.presentation.screens.updatememoryactivity.editMemoryFragment;

import android.support.annotation.Nullable;

import java.util.Calendar;

import javax.inject.Inject;

import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseAddOrUpdateMemory;
import iskills.com.domain.usecases.UseCaseDeleteMemory;
import iskills.com.domain.usecases.UseCaseGetMemoryById;
import iskills.com.presentation.di.activity.utils.date.DatePresenter;
import iskills.com.presentation.di.activity.utils.location.LocationPresenter;
import iskills.com.presentation.di.application.schedulers.SchedulerPresenter;
import iskills.com.presentation.screens.updatememoryactivity.CallbackDeleteDialog;
import iskills.com.presentation.di.activity.navigator.PresenterNavigator;
import iskills.com.presentation.screens.common.BasePresenter;

/** lennyhicks 4/5/18 */
public class EditMemoryPresenterImpl extends BasePresenter<EditMemoryView>
    implements EditMemoryPresenter,
        LocationPresenter.Listener,
        DatePresenter.Listener,
        CallbackDeleteDialog {

  private final UseCaseAddOrUpdateMemory useCaseUpdateMemory;
  private final UseCaseDeleteMemory useCaseDeleteMemory;
  private final UseCaseGetMemoryById useCaseGetMemoryById;

  private final DatePresenter datePresenter;
  private final LocationPresenter locationPresenter;
  private final PresenterNavigator presenterNavigator;
  private final SchedulerPresenter schedulers;

  private Memory memory = new Memory();

  @Inject
  EditMemoryPresenterImpl(
      EditMemoryView view,
      UseCaseAddOrUpdateMemory useCaseUpdateMemory,
      UseCaseGetMemoryById useCaseGetMemoryById,
      UseCaseDeleteMemory useCaseDeleteMemory,
      DatePresenter datePresenter,
      LocationPresenter locationPresenter,
      SchedulerPresenter schedulers,
      PresenterNavigator presenterNavigator) {
    super(view);
    this.useCaseUpdateMemory = useCaseUpdateMemory;
    this.useCaseGetMemoryById = useCaseGetMemoryById;
    this.useCaseDeleteMemory = useCaseDeleteMemory;
    this.datePresenter = datePresenter;
    this.locationPresenter = locationPresenter;
    this.presenterNavigator = presenterNavigator;
    this.locationPresenter.listen(this);
    this.schedulers = schedulers;
  }

  @Override
  public void saveMemory() {
    addDisposable(
        useCaseUpdateMemory
            .addOrUpdate(memory)
            .subscribeOn(schedulers.mainThread())
            .observeOn(schedulers.uiThread())
            .subscribe(
                () -> {
                  view.showSuccess("Successful");
                  view.dismiss();
                },
                throwable -> view.showError(throwable.getLocalizedMessage())));
  }

  @Override
  public void onCommentChanged(CharSequence charSequence) {
    memory.comment = charSequence.toString();
  }

  @Override
  public void onTitleChanged(CharSequence charSequence) {
    memory.title = charSequence.toString();
  }

  @Override
  public void onDateTapped() {
    datePresenter.openDatePicker(this);
  }

  @Override
  public void onLocationChanged(CharSequence charSequence) {
    memory.address = charSequence.toString();
    if (!charSequence.toString().isEmpty() || charSequence.length() > 3)
      if (!charSequence.toString().equals(memory.address))
        new Thread(() -> locationPresenter.searchForLocation(charSequence)).start();
  }

  @Override
  public void updateValues(byte[] imageBytes, @Nullable Long imageId) {
    if (imageBytes != null) {
      memory.memoryDate = datePresenter.formatDate(Calendar.getInstance());
      view.setDate(memory.memoryDate);
      memory.imageBytes = imageBytes;
      view.loadImage(memory.imageBytes);
      locationPresenter.listen(this);
    } else {
      addDisposable(
          useCaseGetMemoryById
              .getMemoryById(imageId)
              .subscribeOn(schedulers.mainThread())
              .observeOn(schedulers.uiThread())
              .subscribe(
                  memoryFromRepo -> {
                    memory = memoryFromRepo;
                    view.setAddress(memory.address);
                    view.setDate(memory.memoryDate);
                    view.setTitle(memory.title);
                    view.setComment(memory.comment);
                    view.showDeleteOption();
                    view.loadImage(memory.imageBytes);
                  }));
    }
  }

  @Override
  public void onDeleteTapped() {
    presenterNavigator.showDeleteConfirmation(this);
  }

  public void onDatePickerSet(String dateFromDatePicker) {
    memory.memoryDate = dateFromDatePicker;
    view.setDate(memory.memoryDate);
  }

  @Override
  public void onLocationFound(double lat, double lng, String address) {
    memory.address = address;
    memory.lat = lat;
    memory.lng = lng;
    view.setAddress(memory.address);
  }

  @Override
  public void onDelete() {
    addDisposable(
        useCaseDeleteMemory
            .delete(memory)
            .subscribeOn(schedulers.mainThread())
            .observeOn(schedulers.uiThread())
            .subscribe(
                () -> {
                  view.showSuccess("Deleted");
                  view.dismiss();
                },
                throwable -> view.showError(throwable.getLocalizedMessage())));
  }
}
