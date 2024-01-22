package fr.kevin.cap_enterprise.repository.interfaces;

import java.util.Optional;

public interface EntitySlugRepository<T> {

    Optional<T> findBySlug(String slug);

}
