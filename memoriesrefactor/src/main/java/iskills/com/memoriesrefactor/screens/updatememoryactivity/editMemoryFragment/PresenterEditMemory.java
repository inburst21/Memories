package iskills.com.memoriesrefactor.screens.updatememoryactivity.editMemoryFragment;

import android.support.annotation.Nullable;

import java.util.Calendar;

import javax.inject.Inject;

import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseAddOrUpdateMemory;
import iskills.com.domain.usecases.UseCaseDeleteMemory;
import iskills.com.domain.usecases.UseCaseGetMemoryById;
import iskills.com.memoriesrefactor.di.activity.utils.date.PresenterDate;
import iskills.com.memoriesrefactor.di.activity.utils.location.PresenterLocation;
import iskills.com.memoriesrefactor.di.activity.utils.schedulers.PresenterScheduler;
import iskills.com.memoriesrefactor.di.services.navigator.CallbackDeleteDialog;
import iskills.com.memoriesrefactor.di.services.navigator.PresenterNavigator;

/**
 * lennyhicks
 * 4/5/18
 */
public class PresenterEditMemory implements ContractEditMemory.Presenter, PresenterLocation.Listener, PresenterDate.Listener, CallbackDeleteDialog {

    private UseCaseDeleteMemory useCaseDeleteMemory;
    @Inject
    PresenterDate presenterDate;

    private UseCaseGetMemoryById useCaseGetMemoryById;
    PresenterLocation presenterLocation;
    private PresenterNavigator presenterNavigator;

    private Memory memory = new Memory();
    private ContractEditMemory.View view;
    private final UseCaseAddOrUpdateMemory useCaseUpdateMemory;
    private final PresenterScheduler schedulers;

    @Inject
    PresenterEditMemory(ContractEditMemory.View view,
                        UseCaseAddOrUpdateMemory useCaseUpdateMemory,
                        UseCaseGetMemoryById useCaseGetMemoryById,
                        UseCaseDeleteMemory useCaseDeleteMemory,
                        PresenterDate presenterDate,
                        PresenterLocation presenterLocation,
                        PresenterScheduler schedulers,
                        PresenterNavigator presenterNavigator) {
        this.view = view;
        this.useCaseUpdateMemory = useCaseUpdateMemory;
        this.useCaseGetMemoryById = useCaseGetMemoryById;
        this.useCaseDeleteMemory = useCaseDeleteMemory;
        this.presenterDate = presenterDate;
        this.presenterLocation = presenterLocation;
        this.presenterNavigator = presenterNavigator;
        this.presenterLocation.listen(this);
        this.schedulers = schedulers;
    }

    @Override
    public void saveMemory() {
        useCaseUpdateMemory.addOrUpdate(memory)
                .subscribeOn(schedulers.mainThread())
                .observeOn(schedulers.uiThread())
                .subscribe(() -> {
                            view.showSuccess("Successful");
                            view.dismiss();
                        },
                        throwable -> view.showError(throwable.getLocalizedMessage()));
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
        presenterDate.openDatePicker(this);
    }

    @Override
    public void onLocationChanged(CharSequence charSequence) {
        if (charSequence != null)
            if (!charSequence.toString().equals(memory.address))
                new Thread(() -> presenterLocation.searchForLocation(charSequence)).start();
    }

    @Override
    public void updateValues(boolean newPhoto, byte[] imageBytes, @Nullable Long imageId) {
        if (newPhoto) {
            memory.memoryDate = Calendar.getInstance();
            view.setDate(presenterDate.formatDate(Calendar.getInstance()));
            presenterLocation.listen(this);
            memory.id = null;
            memory.imageBytes = imageBytes;
            view.loadImage(memory.imageBytes);
        } else {
            useCaseGetMemoryById
                    .getMemoryById(imageId)
                    .subscribeOn(schedulers.mainThread())
                    .observeOn(schedulers.uiThread())
                    .subscribe(memoryFromRepo -> {
                        memory = memoryFromRepo;
                        view.setAddress(memory.address);
                        view.setDate(presenterDate.formatDate(memory.memoryDate));
                        view.setTitle(memory.title);
                        view.setComment(memory.comment);
                        view.showDeleteOption();
                        view.loadImage(memory.imageBytes);
                    });
        }

    }

    @Override
    public void onDeleteTapped() {
        presenterNavigator.showDeleteConfirmation(this);
    }

    @Override
    public void onDatePickerSet(Calendar dateFromDatePicker) {
        memory.memoryDate = dateFromDatePicker;
        view.setDate(presenterDate.formatDate(dateFromDatePicker));
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
        useCaseDeleteMemory.delete(memory)
                .subscribeOn(schedulers.mainThread())
                .observeOn(schedulers.uiThread())
                .subscribe(() -> {
                            view.showSuccess("Deleted");
                            view.dismiss();
                        },
                        throwable -> view.showError(throwable.getLocalizedMessage()));
    }
}
