package fr.jonathan.generic.ServiceGeneric;

import fr.jonathan.generic.dto.DtoGeneric;
import fr.jonathan.generic.entity.EntityGeneric;
import fr.jonathan.generic.mapper.MapperGeneric;
import fr.jonathan.generic.repository.RepositoryGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class ServiceGeneric<E extends EntityGeneric, D extends DtoGeneric> {

    @Autowired
    private RepositoryGeneric<E> repositoryGeneric;

    @Autowired
    private MapperGeneric<E, D> mapperGeneric;

    public D save(D dto){
        E entity = mapperGeneric.toEntity(dto);
        entity = repositoryGeneric.save(entity);
        return mapperGeneric.toDto(entity);
    }

    public Optional<D> findById(Long id){
        return repositoryGeneric.findById(id).map(mapperGeneric::toDto);
    }

    public D update(D dto){
        E entity = mapperGeneric.toEntity(dto);
        repositoryGeneric.saveAndFlush(entity);
        return mapperGeneric.toDto(entity);
    }

    public void delete(Long id){
        repositoryGeneric.deleteById(id);
    }

}
