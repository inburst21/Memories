package iskills.com.memoriesrefactor.screens.memoryactivity.memorypreviewdialog;

import javax.inject.Inject;

import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseGetMemoryById;
import iskills.com.memoriesrefactor.di.activity.utils.date.PresenterDate;
import iskills.com.memoriesrefactor.di.activity.utils.schedulers.PresenterScheduler;
import iskills.com.memoriesrefactor.di.services.navigator.PresenterNavigator;

/**
 * lennyhicks
 * 4/16/18
 */
public class MemoryPreviewDialogPresenter implements ContractMemoryPreviewDialog.Presenter {


    private ContractMemoryPreviewDialog.View view;
    private final UseCaseGetMemoryById useCaseGetMemoryById;
    private final PresenterNavigator navigator;
    private final PresenterScheduler schedulers;
    private PresenterDate presenterDate;
    private Memory memory;

    @Inject
    public MemoryPreviewDialogPresenter(ContractMemoryPreviewDialog.View view,
                                        UseCaseGetMemoryById useCaseGetMemoryById,
                                        PresenterNavigator navigator,
                                        PresenterScheduler schedulers,
                                        PresenterDate presenterDate) {
        this.view = view;
        this.useCaseGetMemoryById = useCaseGetMemoryById;
        this.navigator = navigator;
        this.schedulers = schedulers;
        this.presenterDate = presenterDate;
    }

    @Override
    public void showImage(Long id) {
        useCaseGetMemoryById
                .getMemoryById(id)
                .subscribeOn(schedulers.mainThread())
                .observeOn(schedulers.uiThread())
                .subscribe(memoryFromRepo -> {
                    memory = memoryFromRepo;
                    view.setAddress(memory.address);
                    view.setDate(presenterDate.formatDate(memory.memoryDate));
                    view.setTitle(memory.title);
                    view.setComment(memory.comment);
                    view.loadImage(memory.imageBytes);
                });
    }

    @Override
    public void editMemory() {
        navigator.toEditMemoryScreen(memory.id);
        view.dismiss();
    }

    @Override
    public void onClose() {
        view.dismiss();
    }
}
