package fr.jonathan.generic.controller;

import fr.jonathan.generic.ServiceGeneric.ServiceGeneric;
import fr.jonathan.generic.dto.DtoGeneric;
import org.springframework.web.bind.annotation.*;

public abstract class ControllerGeneric<D extends DtoGeneric> {

    private ServiceGeneric<?, D> serviceGeneric;

    @PostMapping
    public D save(@RequestBody D dto) {
        return serviceGeneric.save(dto);
    }
    @GetMapping(value = "/{id}")
    public D findById(@PathVariable Long id) {
        return serviceGeneric.findById(id).orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
    }
    @PutMapping(value = "/{id}")
    public D update(@PathVariable Long id, @RequestBody D dto) {
        dto.setId(id);
        return serviceGeneric.update(dto);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        serviceGeneric.delete(id);
    }
}
