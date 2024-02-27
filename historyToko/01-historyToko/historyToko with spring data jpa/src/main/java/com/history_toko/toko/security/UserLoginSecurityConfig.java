package com.history_toko.toko.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserLoginSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}root")
                .roles("admin")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}root")
                .roles("user")
                .build();

        UserDetails owner = User.builder()
                .username("owner")
                .password("{noop}root")
                .roles("owner")
                .build();

        return new InMemoryUserDetailsManager(admin, user, owner);

    }
}
