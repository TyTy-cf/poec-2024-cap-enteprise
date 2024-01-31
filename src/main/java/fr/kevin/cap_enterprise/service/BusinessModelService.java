package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.entity.BusinessModel;
import fr.kevin.cap_enterprise.repository.BusinessModelRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusinessModelService implements
        DAOEntityInterface<BusinessModel>
{

    private BusinessModelRepository businessModelRepository;

    @Override
    public List<BusinessModel> findAll() {
        return businessModelRepository.findAll();
    }

    @Override
    public List<BusinessModel> findAllSorted() {
        return businessModelRepository.findAllByOrderByNameAsc();
    }

    @Override
    public BusinessModel findById(Long id) {
        return businessModelRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
