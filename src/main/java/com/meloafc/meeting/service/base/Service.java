package com.meloafc.meeting.service.base;

import com.meloafc.meeting.model.BaseModel;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Service<T extends BaseModel<I>, I extends Serializable> {
    Optional<T> findOne(I id);
    List<T> find();
    T add(T entity);
    T update(T entity);
    void remove(T entity);
    void remove(I id);
}

