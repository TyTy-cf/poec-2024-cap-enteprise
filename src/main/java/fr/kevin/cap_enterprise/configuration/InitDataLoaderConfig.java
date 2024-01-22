package fr.kevin.cap_enterprise.configuration;

import fr.kevin.cap_enterprise.entity.BusinessModel;
import fr.kevin.cap_enterprise.entity.Gamer;
import fr.kevin.cap_enterprise.entity.Moderator;
import fr.kevin.cap_enterprise.repository.BusinessModelRepository;
import fr.kevin.cap_enterprise.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class InitDataLoaderConfig implements CommandLineRunner {

    private UserRepository userRepository;

    private BusinessModelRepository businessModelRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        createUser();
        createBusinessModels();
    }

    private void createUser() {
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
        userRepository.saveAndFlush(gamer);
    }

    private void createBusinessModels() {
        List<String> businessModels = List.of("Free-to-Play", "Pay-to-Play", "Pay-to-win");
        businessModels.forEach((string) -> {
            BusinessModel businessModel = new BusinessModel();
            businessModel.setId((long) businessModels.indexOf(string) + 1);
            businessModel.setName(string);
            businessModelRepository.save(businessModel);
        });
        businessModelRepository.flush();
    }
}
