package iskills.com.memoriesrefactor.screens.memoryactivity.memorypreviewdialog;

import dagger.Binds;
import dagger.Module;

/** lennyhicks 4/16/18 */
@Module
public abstract class MemoryPreviewModule {

  @Binds
  abstract MemoryPreviewView view(MemoryPreviewDialog previewDialog);

  @Binds
  abstract MemoryPreviewPresenter presenter(
      MemoryPreviewPresenterImpl previewDialogPresenter);
}
