package fr.jonathan.generic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Entity generic.
 */
@MappedSuperclass // Avec l'ajout de MappedSuperClass, on indique que EntityGeneric est la super classes pour les entity futur
@Getter
@Setter
public abstract class EntityGeneric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private int version;
}
