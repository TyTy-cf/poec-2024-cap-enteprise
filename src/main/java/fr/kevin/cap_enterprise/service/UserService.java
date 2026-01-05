package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.DTO.RegisterDTO;
import fr.kevin.cap_enterprise.entity.Gamer;
import fr.kevin.cap_enterprise.entity.Moderator;
import fr.kevin.cap_enterprise.entity.User;
import fr.kevin.cap_enterprise.repository.UserRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOFindByIdInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements
        DAOFindByIdInterface<User>,
        UserDetailsService
{

    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public User findByNickname(String nickname) {
        return userRepository.findByNickname(nickname)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByNickname(username);

        return new org.springframework.security.core.userdetails.User(
                user.getNickname(),
                user.getPassword(),
                userGrantedAuthority(user)
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(User user) {
        if (user instanceof Moderator) {
            return List.of(new SimpleGrantedAuthority("ROLE_MODERATOR"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_GAMER"));
    }

    public User findByUuid(String uuid) {
        return userRepository.findByUuid(uuid)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Gamer createGamer(RegisterDTO registerDto) {
        Gamer gamer = new Gamer();
        gamer.setEmail(registerDto.getEmail());
        gamer.setNickname(registerDto.getNickname());
        gamer.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        gamer.setBirthAt(LocalDate.parse(registerDto.getBirthedAt(), formatter));
        return userRepository.saveAndFlush(gamer);
    }
}
