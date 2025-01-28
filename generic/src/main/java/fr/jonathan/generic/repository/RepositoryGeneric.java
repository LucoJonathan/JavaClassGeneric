package fr.jonathan.generic.repository;

import fr.jonathan.generic.entity.EntityGeneric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryGeneric<E extends EntityGeneric> extends JpaRepository<E, Long> {
}
