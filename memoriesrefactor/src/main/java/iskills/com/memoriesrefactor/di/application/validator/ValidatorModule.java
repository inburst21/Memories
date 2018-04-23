package iskills.com.memoriesrefactor.di.application.validator;

import dagger.Module;
import dagger.Provides;
import iskills.com.domain.validators.MapMemoryValidator;
import iskills.com.domain.validators.MemoryValidator;
import iskills.com.memoriesrefactor.di.scopes.ApplicationScope;

/**
 * lennyhicks
 * 4/19/18
 */
@Module
public class ValidatorModule {

    @Provides
    @ApplicationScope
    public final MemoryValidator memoryValidator() {
        return new MemoryValidator();
    }

    @Provides
    @ApplicationScope
    public final MapMemoryValidator mapMemoryValidator() {
        return new MapMemoryValidator();
    }
}
