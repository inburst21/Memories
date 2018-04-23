package iskills.com.presentation.screens.memoryactivity.memorygrid;

import java.util.List;

import iskills.com.domain.model.Memory;
import iskills.com.presentation.screens.common.BaseView;

/** lennyhicks 4/20/18 */
public interface MemoryGridView extends BaseView {
  void updateList(List<Memory> memories);
}
