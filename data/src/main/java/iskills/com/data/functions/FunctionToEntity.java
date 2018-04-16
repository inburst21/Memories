package iskills.com.data.functions;

import io.reactivex.functions.Function;
import iskills.com.data.entities.EntityMemory;
import iskills.com.domain.model.Memory;

/**
 * lennyhicks
 * 4/7/18
 */
public class FunctionToEntity implements Function<Memory, EntityMemory> {

    @Override
    public EntityMemory apply(Memory memory) {
        EntityMemory.Builder builder = EntityMemory.newBuilder()
                .withTitle(memory.title)
                .withComment(memory.comment)
                .withAddress(memory.address)
                .withId(memory.id)
                .withImageBytes(memory.imageBytes)
                .withDate(memory.memoryDate.getTimeInMillis())
                .withLat(memory.lat)
                .withLng(memory.lng);

        if (memory.id == null) {
            builder.withUploadTime(System.currentTimeMillis());
        }

        return builder.build();
    }

}
