package com.history_toko.toko.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserLoginSecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}root")
                .roles("ADMIN", "USER", "OWNER")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}root")
                .roles("USER", "OWNER")
                .build();

        UserDetails owner = User.builder()
                .username("owner")
                .password("{noop}root")
                .roles("OWNER")
                .build();

        return new InMemoryUserDetailsManager(admin, user, owner);

    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/histories").hasRole("OWNER")
                        .requestMatchers(HttpMethod.GET, "/api/histories/**").hasRole("OWNER")
                        .requestMatchers(HttpMethod.POST, "/api/histories").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/histories").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/histories/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
