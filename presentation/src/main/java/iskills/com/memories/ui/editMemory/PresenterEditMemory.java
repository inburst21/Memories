package iskills.com.memories.ui.editMemory;

import android.support.annotation.Nullable;

import java.util.Calendar;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseAddOrUpdateMemory;
import iskills.com.memories.di.providers.date.PresenterDate;
import iskills.com.memories.di.providers.location.PresenterLocation;
import iskills.com.memories.di.qualifiers.MainThread;
import iskills.com.memories.di.qualifiers.UiThread;
import iskills.com.memories.mvp.BasePresenter;

/**
 * lennyhicks
 * 4/5/18
 */
public class PresenterEditMemory extends BasePresenter<ContractEditMemory.View> implements ContractEditMemory.Presenter, PresenterDate.Listener, PresenterLocation.Listener {


    @Inject
    PresenterDate presenterDate;


    private Memory memory = new Memory();


    private PresenterLocation presenterLocation;
    private UseCaseAddOrUpdateMemory useCaseUpdateMemory;
    private final Scheduler main;
    private final Scheduler ui;

    @Inject
    PresenterEditMemory(ContractEditMemory.View view,
                        UseCaseAddOrUpdateMemory useCaseUpdateMemory,
                        @MainThread Scheduler main,
                        @UiThread Scheduler ui,
                        PresenterLocation presenterLocation) {
        super(view);
        this.useCaseUpdateMemory = useCaseUpdateMemory;
        this.main = main;
        this.ui = ui;

        this.presenterLocation = presenterLocation;
        this.presenterLocation.listen(this);
    }

    @Override
    public void saveMemory() {
        addDisposable(useCaseUpdateMemory.addOrUpdate(memory)
                .subscribeOn(main)
                .observeOn(ui)
                .subscribe(() -> view.showSuccess("Successful"),
                        throwable -> view.showError(throwable.getLocalizedMessage()))
        );
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
                new Thread(() -> this.presenterLocation.searchForLocation(charSequence)).start();
    }

    @Override
    public void updateValues(boolean newPhoto, byte[] imageBytes, @Nullable Long imageId) {
        memory.imageBytes = imageBytes;
        view.loadImage(imageBytes);
//        if (!newPhoto) addDisposable(useCaseGetMemoryById.getMemoryById(imageId)
//                .subscribeOn(main)
//                .observeOn(ui)
//                .subscribe(memoryFrom -> memory = memoryFrom));
//        else

    }

    @Override
    public void showMemory() {
        presenterLocation.listen(this);
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
