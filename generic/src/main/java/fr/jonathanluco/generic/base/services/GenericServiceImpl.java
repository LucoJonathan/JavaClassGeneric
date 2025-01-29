package fr.jonathanluco.generic.base.services;

import fr.jonathanluco.generic.base.dto.BaseDto;
import fr.jonathanluco.generic.base.entity.BaseEntity;
import fr.jonathanluco.generic.base.mapper.GenericMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@AllArgsConstructor
public class GenericServiceImpl<
        D extends BaseDto,
        E extends BaseEntity,
        R extends JpaRepository<E, Long>,
        M extends GenericMapper<D, E>
        > implements GenericService<D, Long> {
    protected R repository;
    protected M mapper;

    @Override
    public Page<D> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public Optional<D> findById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public D saveOrUpdate(D dto) {
        return mapper.toDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<D> partialUpdate(D dto) {
        return repository.findById(dto.getId())
                .map(e -> mapper.toDto(repository.save(mapper.partialUpdate(dto, e))));
    }

    @Override
    public D save(D dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public D update(D dto) {
        return mapper.toDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }
}
