package fr.kevin.cap_enterprise.configuration;

import fr.kevin.cap_enterprise.mapping.UrlRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth ->
                auth
                    .requestMatchers(UrlRoute.URL_GAME + "/**").authenticated()
                    .requestMatchers(UrlRoute.URL_REVIEW + "/**").authenticated()
                    .requestMatchers("/**").permitAll()
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .permitAll()
            )
            .logout(logout ->
                 logout
                    .logoutSuccessUrl("/")
                    .permitAll()
            );

        return http.build();
    }

}
