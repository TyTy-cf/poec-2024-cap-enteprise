package fr.kevin.cap_enterprise.repository;

import fr.kevin.cap_enterprise.entity.Game;
import fr.kevin.cap_enterprise.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends
        JpaRepository<Game, Long>,
        EntityNomenclatureRepository<Game>
{

}