package iskills.com.domain.repository;

/**
 * lennyhicks
 * 3/29/18
 */

public interface ImageModelMapper<E, M> {
    M fromEntity(E entity);
    E toEntity(M model);
}
