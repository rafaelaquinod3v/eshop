package sv.com.eshop.core;

import java.util.Optional;

public interface DomainRepository<T, ID> {
    Optional<T> findById(ID id);
    <S extends T> S save(S entity);    
    void delete(T entity);
}
