package iskills.com.data.funtions;

import io.reactivex.functions.Function;
import iskills.com.data.entities.EntityMemory;
import iskills.com.domain.model.Memory;

/**
 * lennyhicks
 * 4/7/18
 */
public class FunctionToModel implements Function<EntityMemory, Memory> {

    @Override
    public Memory apply(EntityMemory entityMemory) {

//        System.out.print(entityMemory.uploadTime + " llllllllllllllllllllll");
        return Memory.newBuilder()
//                .withTitle(entityMemory.title)
//                .withComment(entityMemory.comment)
//                .withAddress(entityMemory.address)
                .withId(entityMemory.id)
                .withImageBytes(entityMemory.imageBytes)
//                .withMemoryDate(entityMemory.date)
//                .withLat(entityMemory.lat)
                .build();
    }
}
