package com.girmiti.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // ✅ Security Rules
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for simplicity

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/register", "/css/**").permitAll() // public pages
                .anyRequest().authenticated() // protect all others
            )

            .formLogin(form -> form
                .loginPage("/login") // custom login page
                .defaultSuccessUrl("/products", true) // ✅ redirect after login
                .failureUrl("/login?error=true") // show error on failure
                .permitAll()
            )

            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            );

        return http.build();
    }

    // ✅ In-memory user (for testing)
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User
                .withUsername("root")
                .password("{noop}root") // no password encoder
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}