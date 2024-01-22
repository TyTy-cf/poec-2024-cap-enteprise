package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.entity.Moderator;
import fr.kevin.cap_enterprise.entity.User;
import fr.kevin.cap_enterprise.repository.UserRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User>, UserDetailsService {

    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNickname(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
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
}
