
package fr.kevin.cap_enterprise.repository.interfaces;

import fr.kevin.cap_enterprise.entity.Classification;

import java.util.List;
import java.util.Optional;

public interface EntityNomenclatureRepository<T> {

    Optional<T> findByName(String name);

    Optional<T> findBySlug(String slug);

    List<T> findAllByOrderByNameAsc();

}
