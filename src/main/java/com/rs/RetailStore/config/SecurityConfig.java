package com.rs.RetailStore.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        UserDetails user = User.builder()
                .username("duynguyen1")
                .password("$2a$10$i.QE4uRA0h9PD.Zgk.sW7.RssO7dCA8TuCyIQJaB8XjmekuhQ3.rK") //pass1
                .roles("User")
                .build();
        UserDetails admin = User.builder()
                .username("user1")
                .password("$2a$10$ZWPpEibHMrmTSxuGqPJHJuITQ/3TL9R.juHaR2egTBg3dM4TWAYPW") //pass1
                .roles("admin")
                .build();

        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        return users;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
