
package fr.kevin.cap_enterprise.repository.interfaces;

import java.util.Optional;

public interface EntityNomenclatureRepository<T> {

    Optional<T> findByName(String name);

    Optional<T> findBySlug(String slug);

}
