package iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import iskills.com.domain.model.Memory;
import iskills.com.memoriesrefactor.di.services.navigator.PresenterNavigator;
import iskills.com.memoriesrefactor.screens.adapters.MemoryHolderFragment;

/** lennyhicks 4/5/18 */
public class MemoryGridAdapterPresenter {

  private final PresenterNavigator presenterNavigator;

  private List<Memory> memories = new ArrayList<>();

  @Inject
  public MemoryGridAdapterPresenter(PresenterNavigator presenterNavigator) {
    this.presenterNavigator = presenterNavigator;
  }

  public int getMemoryCount() {
    return memories.size();
  }

  public void onBindViewHolderMemory(final MemoryHolderFragment holder, int position) {

    Memory memory = memories.get(position);
    if (memory.imageBytes != null) {
      holder.setMemoryDate(memory.memoryDate);
      holder.setMemoryImage(memory.imageBytes);
    }
  }

  public void updateList(List<Memory> memories) {
    this.memories = memories;
  }

  public void onMemoryTapped(int position) {
    presenterNavigator.openPreviewDialog(memories.get(position).id);
  }
}
