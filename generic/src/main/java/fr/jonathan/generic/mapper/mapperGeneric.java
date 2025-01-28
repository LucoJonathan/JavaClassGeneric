package fr.jonathan.generic.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface mapperGeneric<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
}
