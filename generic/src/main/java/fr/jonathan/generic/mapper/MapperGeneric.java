package fr.jonathan.generic.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface MapperGeneric<E, D> {
    D toDto(E entity);
    E toEntity(D dto);
}
