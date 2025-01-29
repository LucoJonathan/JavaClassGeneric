package fr.jonathanluco.generic.base.controller;

import fr.jonathanluco.generic.base.dto.BaseDto;
import fr.jonathanluco.generic.base.services.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RequiredArgsConstructor
public abstract class GenericController<
        D extends BaseDto,
        S extends GenericService<D,Long>
        > {
    protected final S service;

    @GetMapping
    public Page<D> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    @GetMapping("{id}")
    public Optional<D> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public D saveOrUpdate(@ModelAttribute D dto) {
        return service.saveOrUpdate(dto);
    }
/*    @PostMapping
    public D save(@RequestBody D d) {
        return service.save(d);
    }

    @PutMapping
    public D update(@RequestBody D d, @PathVariable I id) {
        return service.update(d, id);
    }*/

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
    @PatchMapping
    public Optional<D> partialUpdate(@RequestBody D dto) {
        return service.partialUpdate(dto);
    }
}