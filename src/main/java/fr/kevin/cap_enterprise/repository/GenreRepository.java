package fr.kevin.cap_enterprise.repository;

import fr.kevin.cap_enterprise.entity.Genre;
import fr.kevin.cap_enterprise.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends
        JpaRepository<Genre, Long>,
        EntityNomenclatureRepository<Genre>
{

}