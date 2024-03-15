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
public class SecurityConfiguration {


    // @Bean anotasi untuk menunjukkan bahwa suatu metode menghasilkan sebuah bean yang akan dikelola oleh kontainer Spring
    // Metode untuk membuat dan mengkonfigurasi UserDetailsManager
    // seperti menambahkan pengguna baru, menghapus pengguna, dan lain-lain
    // DataSource adalah objek yang menyediakan koneksi ke basis data
    // JDBC (Java Database Connectivity)

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password, active from user_login where username=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, role from roles where username=?");

        return jdbcUserDetailsManager;

    }


    // @Bean anotasi konfigurasi untuk filter keamanan Spring Security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // ini adalah metode yang memulai konfigurasi untuk mengatur otorisasi pada permintaan HTTP
        http.authorizeHttpRequests(configurer ->
                configurer
                        // menentukan aturan otorisais ke endpoint /api/histories
                        .requestMatchers(HttpMethod.GET, "/api/histories").hasRole("OWNER")
                        .requestMatchers(HttpMethod.GET, "/api/histories/**").hasRole("OWNER")
                        .requestMatchers(HttpMethod.POST, "/api/histories").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/histories").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/histories/**").hasRole("ADMIN")

                        // menentukan aturan otorisais ke endpoint /api/users
                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("OWNER")
                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("OWNER")
                        .requestMatchers(HttpMethod.POST, "/api/users").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/users").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")

                        // menentukan aturan otorisais ke endpoint /histories/list
                        .requestMatchers(HttpMethod.GET, "/histories/list").hasRole("OWNER")
                        .requestMatchers(HttpMethod.GET, "/histories/list/**").hasRole("OWNER")
                        .requestMatchers(HttpMethod.POST, "/histories/list").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/histories/list").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/histories/list/**").hasRole("ADMIN")

                        // menentukan aturan otorisais ke endpoint /users/list
                        .requestMatchers(HttpMethod.GET, "/users/list").hasRole("OWNER")
                        .requestMatchers(HttpMethod.GET, "/users/list/**").hasRole("OWNER")
                        .requestMatchers(HttpMethod.POST, "/users/list").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/users/list").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/users/list/**").hasRole("ADMIN")
        );

        // mengaktifkan autentikasi dasar HTTP
        http.httpBasic(Customizer.withDefaults());

        // menonaktifkan perlindungan CSRF
        // CSRF adalah serangan yang memanfaatkan kepercayaan otentikasi yang ada antara pengguna dan aplikasi
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
