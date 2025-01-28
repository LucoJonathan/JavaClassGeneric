package fr.jonathan.generic.ServiceGeneric;

import fr.jonathan.generic.dto.DtoGeneric;
import fr.jonathan.generic.entity.EntityGeneric;
import org.springframework.stereotype.Service;

@Service
public abstract class ServiceGeneric<E extends EntityGeneric, D extends DtoGeneric> {

}
