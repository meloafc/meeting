package com.meloafc.meeting.service.base;

import com.meloafc.meeting.model.BaseModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends BaseModel<I>, I extends Serializable> implements Service<T, I> {

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PRIVATE)
    private JpaRepository<T,I> repository;

    public AbstractService(JpaRepository<T,I> repository) {
        setRepository(repository);
    }

    @Override
    public Optional<T> findOne(I id) {
        return repository.findById(id);
    }

    @Override
    public List<T> find() {
        return repository.findAll();
    }

    @Override
    public T add(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void remove(T entity) {
        repository.delete(entity);
    }

    @Override
    public void remove(I id) {
        repository.deleteById(id);
    }
}