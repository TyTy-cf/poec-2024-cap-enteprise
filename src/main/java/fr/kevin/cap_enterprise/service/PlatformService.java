package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.entity.Platform;
import fr.kevin.cap_enterprise.repository.PlatformRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatformService implements
        DAOEntityInterface<Platform>
{

    private PlatformRepository platformRepository;

    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Override
    public Platform findById(Long id) {
        return platformRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
