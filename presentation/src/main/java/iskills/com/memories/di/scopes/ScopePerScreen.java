package iskills.com.memories.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * lennyhicks
 * 3/30/18
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopePerScreen {
}
