package com.cpan228.clothes_warehouse.config;

import com.cpan228.clothes_warehouse.repository.UserRepository;
import com.cpan228.clothes_warehouse.model.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                return user;
            }
            throw new UsernameNotFoundException(username);
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//  IMPORTANT: Spring Security automatically adds the "ROLE_" prefix to role names when checking authorities
        http
                .authorizeHttpRequests()
                .requestMatchers(toH2Console()).permitAll()
//                .requestMatchers("/", "/login", "/register").permitAll()
//                .requestMatchers("/itemlist","/itemlist/switchPage").hasRole("USER")
//                .requestMatchers("/add", "/itemlist", "/add/deleteAllItems", "/dc", "/itemlist/switchPage","/dc/centres").hasRole("ADMIN")
//                .requestMatchers("/add", "/itemlist","/itemlist/switchPage","/itemlist/search-item").hasRole("WAREHOUSE")
                .anyRequest().permitAll()

                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/itemlist", true)
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .csrf()
                    .ignoringRequestMatchers(toH2Console())
                .and()
                .headers()
                .frameOptions();

        return http.build();
    }
}
