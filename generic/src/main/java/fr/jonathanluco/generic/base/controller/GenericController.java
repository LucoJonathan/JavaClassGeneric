package fr.jonathanluco.generic.base.controller;


import fr.jonathanluco.generic.base.GenericId;
import fr.jonathanluco.generic.base.services.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RequiredArgsConstructor
public abstract class GenericController<
        I,
        D extends GenericId<I>,
        S extends GenericService<D,I>
        > {
    protected final S service;

    @GetMapping
    public Page<D> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    @GetMapping("{id}")
    public Optional<D> findById(@PathVariable I id) {
        return service.findById(id);
    }
    /*@PostMapping
    @PutMapping*/
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public D saveOrUpdate(@RequestBody D entity) {
        return service.saveOrUpdate(entity);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable I id) {
        service.deleteById(id);
    }
    @PatchMapping
    public Optional<D> partialUpdate(@RequestBody D dto) {
        return service.partialUpdate(dto);
    }
}