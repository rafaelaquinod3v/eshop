package sv.com.eshop.infrastructure;

import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.com.eshop.core.DomainRepository;

public abstract class BaseRepositoryAdapter<T, ID, R extends JpaRepository<T, ID>> 
    implements DomainRepository<T, ID> {
    
    protected final R repository;

    protected BaseRepositoryAdapter(R repository){
        this.repository = repository;
    }

    @Override
    public Optional<T> findById(ID id){
        Objects.requireNonNull(id);
        return repository.findById(id);
    }

    @Override
    public <S extends T> S save(S entity){
        Objects.requireNonNull(entity);
        return repository.save(entity);
    }

    @Override
    public void delete(T entity){
        Objects.requireNonNull(entity);
        repository.delete(entity);
    }
}
