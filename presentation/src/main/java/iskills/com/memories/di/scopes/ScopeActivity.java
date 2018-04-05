package iskills.com.memories.di.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * lennyhicks
 * 4/5/18
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopeActivity {
}
