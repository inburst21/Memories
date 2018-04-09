package iskills.com.memories.ui.allMemories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import iskills.com.domain.model.Memory;
import iskills.com.memories.di.providers.date.PresenterDate;
import iskills.com.memories.ui.adapters.ViewMemoryHolder;

/**
 * lennyhicks
 * 4/5/18
 */
public class PresenterMemoryGrid {

    public PresenterDate utilsDate;

    private List<Memory> memories = new ArrayList<>();


    @Inject
    public PresenterMemoryGrid(PresenterDate utilsDate) {
        this.utilsDate = utilsDate;
    }


    public int getMemoryCount() {
        return memories.size();
    }

    public void onBindViewHolderMemory(ViewMemoryHolder holder, int position) {
        Memory memory = memories.get(position);
        if (memory.imageBytes != null) {
            holder.setMemoryDate(utilsDate.formatDate(memories.get(position).memoryDate));
            holder.setMemoryImage(memories.get(position).imageBytes);
        }
    }

    public void updateList(List<Memory> memories) {
        this.memories = memories;
    }
}
