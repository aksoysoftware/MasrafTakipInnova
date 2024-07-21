package com.innova.masraftakip.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseMapper<E, D> {

    D toDto(E entity);

    E toEntity(D dto);

    default List<D> toDto(List<E> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    default List<E> toEntity(List<D> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}