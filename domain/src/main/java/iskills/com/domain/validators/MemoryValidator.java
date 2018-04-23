package iskills.com.domain.validators;

import iskills.com.domain.model.Memory;

/** lennyhicks 4/19/18 */
public class MemoryValidator extends BaseValidator<Memory> {
    @Override
    public boolean validate(final Memory memory) {
        return checkNotNull(memory)
                && checkNotNull(memory.imageBytes)
                && checkNotNullOrEmpty(memory.title)
                && checkNotNullOrEmpty(memory.comment)
                && checkNotNull(memory.address)
                && checkNotNull(memory.memoryDate);
    }
}
