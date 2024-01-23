package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.entity.Publisher;
import fr.kevin.cap_enterprise.repository.PublisherRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService implements
        DAOEntityInterface<Publisher>
{

    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
