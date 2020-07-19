package com.meloafc.meeting.mapper;

import com.meloafc.meeting.model.BaseModel;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericMapper<E extends BaseModel, D> {

    D convertToDTO(E entity);

    E convertToEntity(D dto);

    default List<D> convertToListDTO(Collection<E> collection) {
        return collection.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    default List<E> convertToListEntity(Collection<D> collection) {
        return collection.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

}
