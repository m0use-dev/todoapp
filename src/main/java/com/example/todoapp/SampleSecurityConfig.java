package com.example.todoapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SampleSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll());
        http.csrf(
                csrf -> csrf
                        .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));
        http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));
        http.csrf().disable();
        http.authorizeHttpRequests(authorize -> {
            authorize.anyRequest().permitAll();
        });
        http.formLogin(form -> {
            form.defaultSuccessUrl("/secret")
                    .loginPage("/login");
        });
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        String username = "user";
        String password = "pass";

        UserDetails user = User.withUsername(username)
                .password(
                        PasswordEncoderFactories
                                .createDelegatingPasswordEncoder()
                                .encode(password))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}