package iskills.com.data.funtions;

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
        System.out.print(memory.address);
//        EntityMemory.Builder builder = EntityMemory.newBuilder()
//                .withTitle(memory.title)
//                .withComment(memory.comment)
//                .withAddress(memory.address)
//                .withId(memory.id)
//                .withImageBytes(memory.imageBytes)
//                .withDate(memory.memoryDate.getTimeInMillis())
//                .withLat(memory.lat)
//                .withLng(memory.lng);

        EntityMemory entityMemory = new EntityMemory();
//        entityMemory.title = memory.title;
        entityMemory.id = memory.id;
        entityMemory.imageBytes = memory.imageBytes;
//        entityMemory.address = memory.address;
//        entityMemory.comment = memory.comment;
//        entityMemory.date = memory.memoryDate.getTimeInMillis();
//        entityMemory.lat = memory.lat;
//        entityMemory.lng = memory.lng;

        if (memory.id == null) {
//            builder.withUploadTime(System.currentTimeMillis());
//            entityMemory.uploadTime = System.currentTimeMillis();
        }

        return entityMemory;
    }

}
