package com.history_toko.toko.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class UserLoginSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password, active from user_login where username=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, role from roles where username=?");

        return jdbcUserDetailsManager;

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
