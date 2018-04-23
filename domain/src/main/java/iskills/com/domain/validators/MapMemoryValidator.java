package iskills.com.domain.validators;

import iskills.com.domain.model.Memory;

/**
 * lennyhicks
 * 4/19/18
 */
public class MapMemoryValidator extends MemoryValidator {
    @Override
    public final boolean validate(final Memory memory) {
        return super.validate(memory)
                && checkNotNull(memory.lat)
                && checkNotNull(memory.lng);
    }
}
