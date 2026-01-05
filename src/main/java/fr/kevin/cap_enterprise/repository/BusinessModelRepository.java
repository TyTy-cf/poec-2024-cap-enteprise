package fr.kevin.cap_enterprise.repository;

import fr.kevin.cap_enterprise.entity.BusinessModel;
import fr.kevin.cap_enterprise.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessModelRepository extends
        JpaRepository<BusinessModel, Long>,
        EntityNomenclatureRepository<BusinessModel> {

}