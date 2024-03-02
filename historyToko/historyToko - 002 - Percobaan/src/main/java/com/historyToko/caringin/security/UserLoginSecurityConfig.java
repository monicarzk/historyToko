package com.historyToko.caringin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

// @Configuration anotasi untuk mendefinisikan bahwa kelas tersebut berisi
// pengaturan, konfigurasi, dan definisi bean
@Configuration
public class UserLoginSecurityConfig {


    // Metode untuk membuat dan mengkonfigurasi UserDetailsManager.
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

                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("OWNER")
                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("OWNER")
                        .requestMatchers(HttpMethod.POST, "/api/users").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/users").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
