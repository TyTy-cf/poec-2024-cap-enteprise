package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.DTO.GameDTO;
import fr.kevin.cap_enterprise.entity.Game;
import fr.kevin.cap_enterprise.entity.Moderator;
import fr.kevin.cap_enterprise.repository.GameRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOFindByIdInterface;
import fr.kevin.cap_enterprise.service.interfaces.DAOFindBySlugInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class GameService implements
        DAOFindByIdInterface<Game>,
        DAOFindBySlugInterface<Game>
{

    private GameRepository gameRepository;

    private UserService userService;

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Page<Game> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    @Override
    public Game findBySlug(String slug) {
        return gameRepository.findBySlug(slug)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Game create(GameDTO gameDTO, String nickname) {
        Game game = new Game();
        game.setName(gameDTO.getName());
        game.setDescription(gameDTO.getDescription());
        game.setPublishedAt(LocalDate.parse(gameDTO.getPublishedAt()));
        game.setGenre(gameDTO.getGenre());
        game.setBusinessModel(gameDTO.getBusinessModel());
        game.setPublisher(gameDTO.getPublisher());
        game.setClassification(gameDTO.getClassification());
        game.setPlatforms(gameDTO.getPlatforms());
        game.setModerator((Moderator) userService.findByNickname(nickname));
        game.setImage("https://static.vecteezy.com/system/resources/previews/005/337/799/original/icon-image-not-found-free-vector.jpg");
        return gameRepository.saveAndFlush(game);
    }
}
