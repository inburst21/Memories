package iskills.com.memoriesrefactor.screens.updatememoryactivity.editMemoryFragment;

import android.support.annotation.Nullable;

import java.util.Calendar;

import javax.inject.Inject;

import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseAddOrUpdateMemory;
import iskills.com.memoriesrefactor.di.activity.utils.date.PresenterDate;
import iskills.com.memoriesrefactor.di.activity.utils.location.PresenterLocation;
import iskills.com.memoriesrefactor.di.activity.utils.schedulers.PresenterScheduler;

/**
 * lennyhicks
 * 4/5/18
 */
public class PresenterEditMemory implements ContractEditMemory.Presenter, PresenterLocation.Listener, PresenterDate.Listener {

    @Inject
    PresenterDate presenterDate;

    PresenterLocation presenterLocation;

    private Memory memory = new Memory();
    private ContractEditMemory.View view;
    private final UseCaseAddOrUpdateMemory useCaseUpdateMemory;
    private final PresenterScheduler schedulers;

    @Inject
    PresenterEditMemory(ContractEditMemory.View view,
                        UseCaseAddOrUpdateMemory useCaseUpdateMemory,
                        PresenterLocation presenterLocation,
                        PresenterScheduler schedulers) {
        this.view = view;
        this.useCaseUpdateMemory = useCaseUpdateMemory;
        this.presenterLocation = presenterLocation;
        this.presenterLocation.listen(this);
        this.schedulers = schedulers;
    }

    public void saveMemory() {
        useCaseUpdateMemory.addOrUpdate(memory)
                .subscribeOn(schedulers.mainThread())
                .observeOn(schedulers.uiThread())
                .subscribe(() -> view.showSuccess("Successful"),
                        throwable -> view.showError(throwable.getLocalizedMessage()));
    }


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
        if (newPhoto){
            memory.memoryDate = Calendar.getInstance();
            view.setDate(presenterDate.formatDate(Calendar.getInstance()));
            presenterLocation.listen(this);

        }
        memory.id = imageId;
        memory.imageBytes = imageBytes;
        view.loadImage(imageBytes);

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
}
