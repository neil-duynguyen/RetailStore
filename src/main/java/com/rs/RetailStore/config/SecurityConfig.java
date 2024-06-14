package com.rs.RetailStore.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("duynguyen")
                .password("{bcrypt}$2a$10$i.QE4uRA0h9PD.Zgk.sW7.RssO7dCA8TuCyIQJaB8XjmekuhQ3.rK")
                .roles("User")
                .build();
        UserDetails admin = User.builder()
                .username("user")
                .password("{bcrypt}$2a$10$ZWPpEibHMrmTSxuGqPJHJuITQ/3TL9R.juHaR2egTBg3dM4TWAYPW")
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
