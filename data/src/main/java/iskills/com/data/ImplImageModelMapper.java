package iskills.com.data;

import iskills.com.data.entities.EntityMemory;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.ImageModelMapper;

/**
 * lennyhicks
 * 3/29/18
 */

public class ImplImageModelMapper implements ImageModelMapper<EntityMemory, Memory> {
    @Override
    public Memory fromEntity(EntityMemory entity) {
        //Long id, byte[] imageBytes, String title, String comment, long memoryDate, String address, Double lat, Double lng
        return new Memory(entity.id, entity.imageBytes, entity.imageTitle, entity.imageComment, entity.date, entity.address, entity.lat, entity.lng);
    }

    @Override
    public EntityMemory toEntity(Memory model) {
        if (model.getId() != null) {
            return new EntityMemory(model.id, model.imageBytes, model.comment, model.memoryDate.getTimeInMillis(), model.lat, model.lng, model.title);
        } else {
            //byte[] imageBytes, String title, String comment, long memoryDate, String address, Double lat, Double lng, long uploadTime
            return new EntityMemory(model.imageBytes, model.title, model.comment, model.memoryDate.getTimeInMillis(), model.address, model.lat, model.lng, System.currentTimeMillis());        }
    }
}


