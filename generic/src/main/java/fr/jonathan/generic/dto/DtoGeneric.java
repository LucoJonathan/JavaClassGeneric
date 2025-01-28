package fr.jonathan.generic.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.*;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class DtoGeneric {
    private long id;
}
