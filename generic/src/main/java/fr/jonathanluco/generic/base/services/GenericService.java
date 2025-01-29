package fr.jonathanluco.generic.base.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<D, Long> {

    Page<D> findAll(Pageable pageable); // gestion de pagination
    Optional<D> findById(Long id);
    D saveOrUpdate(D dto);
    void deleteById(Long id);
    Optional<D> partialUpdate(D dto);
    D save(D dto);
    D update(D dto);
}
