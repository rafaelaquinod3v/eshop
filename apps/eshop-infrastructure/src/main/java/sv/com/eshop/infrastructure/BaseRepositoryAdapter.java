package sv.com.eshop.infrastructure;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.com.eshop.core.DomainRepository;
import sv.com.eshop.core.PageQuery;
import sv.com.eshop.core.PagedResult;

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
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public PagedResult<T> findAll(PageQuery query) {
        Pageable pageable = PageRequest.of(query.getPage(), query.getSize());
        Page<T> springPage = repository.findAll(pageable);
        return new PagedResult<>(springPage.getContent(), springPage.getTotalElements(), springPage.getSize());
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
