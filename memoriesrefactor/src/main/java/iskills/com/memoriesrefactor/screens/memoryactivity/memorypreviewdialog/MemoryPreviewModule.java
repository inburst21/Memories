package iskills.com.memoriesrefactor.screens.memoryactivity.memorypreviewdialog;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 4/16/18
 */
@Module
public abstract class MemoryPreviewModule {

    @Binds
    abstract ContractMemoryPreviewDialog.View view(MemoryPreviewDialog previewDialog);

    @Binds
    abstract ContractMemoryPreviewDialog.Presenter presenter(MemoryPreviewDialogPresenter previewDialogPresenter);
}
