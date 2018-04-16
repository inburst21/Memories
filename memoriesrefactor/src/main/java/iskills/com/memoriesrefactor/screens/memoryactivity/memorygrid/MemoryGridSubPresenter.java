package iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import iskills.com.domain.model.Memory;
import iskills.com.memoriesrefactor.di.activity.utils.date.PresenterDate;
import iskills.com.memoriesrefactor.di.services.navigator.PresenterNavigator;
import iskills.com.memoriesrefactor.screens.adapters.ViewHolderMemory;

/**
 * lennyhicks
 * 4/5/18
 */
public class MemoryGridSubPresenter {

    private PresenterDate utilsDate;
    private PresenterNavigator presenterNavigator;

    private List<Memory> memories = new ArrayList<>();

    @Inject
    public MemoryGridSubPresenter(PresenterDate utilsDate, PresenterNavigator presenterNavigator) {
        this.utilsDate = utilsDate;
        this.presenterNavigator = presenterNavigator;
    }


    public int getMemoryCount() {
        return memories.size();
    }

    public void onBindViewHolderMemory(ViewHolderMemory holder, int position) {

        Memory memory = memories.get(position);
        if (memory.imageBytes != null) {
            holder.setMemoryDate(utilsDate.formatDate(memories.get(position).memoryDate));
            holder.setMemoryImage(memories.get(position).imageBytes);
        }
    }

    public void updateList(List<Memory> memories) {
        this.memories = memories;
    }

    public void onMemoryTapped(int position) {
        presenterNavigator.openPreviewDialog(memories.get(position).id);
    }
}
