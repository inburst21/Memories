package iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid;

import java.util.List;

import iskills.com.domain.model.Memory;
import iskills.com.memoriesrefactor.screens.common.BaseView;

/** lennyhicks 4/20/18 */
public interface MemoryGridView extends BaseView {
  void updateList(List<Memory> memories);
}
