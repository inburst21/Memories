package iskills.com.memories.di.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * lennyhicks
 * 4/2/18
 */
@Scope
@Retention(RUNTIME)
@Documented
public @interface ScopeAndroid {
}
