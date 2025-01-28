package fr.jonathan.generic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Entity generic.
 */
@MappedSuperclass // Avec l'ajout de MappedSuperClass, on indique que EntityGeneric est la super classes pour les entity futur
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class EntityGeneric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private int version;
}
