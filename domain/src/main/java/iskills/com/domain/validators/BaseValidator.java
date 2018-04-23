package iskills.com.domain.validators;

/**
 * lennyhicks
 * 4/19/18
 */
abstract class BaseValidator<T> {
    abstract boolean validate(T type);
    boolean checkNotNull(Object object){
        return object != null;
    }
    boolean checkNotNullOrEmpty(String string){
        return checkNotNull(string) && !string.isEmpty();
    }
}
