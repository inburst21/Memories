package iskills.com.data;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;
import iskills.com.data.entities.EntityMemory;
import iskills.com.domain.model.Memory;

/**
 * lennyhicks
 * 3/29/18
 */

public class ImplMapper {

    public final Function<EntityMemory, Memory> toMemory;
    public final Function<Memory, EntityMemory> toEntity;

    public ImplMapper(Function<EntityMemory, Memory> toMemory, Function<Memory, EntityMemory> toEntity) {
        this.toMemory = toMemory;
        this.toEntity = toEntity;
    }

    public List<Memory> memoriesFromList(List<EntityMemory> entityMemories){
        ArrayList<Memory> arrayList = new ArrayList();
        for(EntityMemory entityMemory : entityMemories){
            try {
                arrayList.add(toMemory.apply(entityMemory));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

}


