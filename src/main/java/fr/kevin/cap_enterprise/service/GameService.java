package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.entity.Game;
import fr.kevin.cap_enterprise.repository.GameRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOFindByIdInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService implements DAOFindByIdInterface<Game> {

    private GameRepository gameRepository;

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
