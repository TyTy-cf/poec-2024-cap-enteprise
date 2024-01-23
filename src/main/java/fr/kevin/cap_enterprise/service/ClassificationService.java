package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.entity.Classification;
import fr.kevin.cap_enterprise.repository.ClassificationRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassificationService implements
        DAOEntityInterface<Classification>
{

    private ClassificationRepository classificationRepository;

    @Override
    public List<Classification> findAll() {
        return classificationRepository.findAll();
    }

    @Override
    public Classification findById(Long id) {
        return classificationRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
