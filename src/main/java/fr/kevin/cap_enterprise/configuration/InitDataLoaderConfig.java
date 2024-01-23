package fr.kevin.cap_enterprise.configuration;

import fr.kevin.cap_enterprise.entity.*;
import fr.kevin.cap_enterprise.entity.interfaces.NomenclatureInterface;
import fr.kevin.cap_enterprise.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class InitDataLoaderConfig implements CommandLineRunner {

    private UserRepository userRepository;

    private BusinessModelRepository businessModelRepository;

    private PlatformRepository platformRepository;

    private PublisherRepository publisherRepository;

    private ClassificationRepository classificationRepository;

    private GenreRepository genreRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        createUsers();
        createBusinessModels();
        createPlatforms();
        createPublishers();
        createClassifications();
        createGenres();
        userRepository.flush();
    }

    private void createUsers() {
        Moderator modo = new Moderator();
        modo.setId(1L);
        modo.setEmail("toto@gmail.com");
        modo.setNickname("toto");
        modo.setPhoneNumber("0698325417");
        modo.setPassword(passwordEncoder.encode("toto"));
        userRepository.save(modo);

        Gamer gamer = new Gamer();
        gamer.setId(2L);
        gamer.setEmail("toto2@gmail.com");
        gamer.setNickname("toto2");
        gamer.setBirthAt(LocalDate.now());
        gamer.setPassword(passwordEncoder.encode("toto"));
        userRepository.save(gamer);
    }

    private void createBusinessModels() {
        createNomenclatures(
            businessModelRepository,
            BusinessModel.class,
            List.of("Free-to-Play", "Pay-to-Play", "Pay-to-win")
        );
    }

    private void createPlatforms() {
        createNomenclatures(
            platformRepository,
            Platform.class,
            List.of("Switch", "PC", "PS5", "PS4", "PS3", "XBOX Series X", "XBOX One")
        );
    }

    private void createPublishers() {
        createNomenclatures(
            publisherRepository,
            Publisher.class,
            List.of("Blizzard Entertainment", "Valve", "Riot Games", "Mojang", "Rockstar", "CD Projekt Red", "EA", "2k Games", "Ubisoft", "From Software", "Game Freak", "Nintendo", "Capcom")
        );
    }

    private void createClassifications() {
        createNomenclatures(
            classificationRepository,
            Classification.class,
            List.of("PEGI 3", "PEGI 7", "PEGI 12", "PEGI 16", "PEGI 18")
        );
    }

    private void createGenres() {
        createNomenclatures(
            genreRepository,
            Genre.class,
            List.of("FPS", "MOBA", "MMO", "RPG", "Voiture", "Aventure", "Hack'n'Slash", "Simulation", "Sport", "Action", "Horreur", "Plateforme", "Cartes", "Monde ouvert", "Stratégie")
        );
    }

    private void createNomenclatures(
            JpaRepository repository,
            Class<?> objectClass,
            List<String> items
    ) {
        items.forEach((name) -> {
            try {
                Long id = (long) items.indexOf(name) + 1;
                if (repository.findById(id).isEmpty()) {
                    Object item = objectClass.getDeclaredConstructor().newInstance();
                    if (item instanceof NomenclatureInterface nameEntity) {
                        nameEntity.setId(id);
                        nameEntity.setName(name);
                        repository.save(nameEntity);
                    }
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
