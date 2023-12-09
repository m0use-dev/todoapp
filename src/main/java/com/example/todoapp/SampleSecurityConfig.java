package com.example.todoapp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableMethodSecurity
public class SampleSecurityConfig {
    @Autowired
    private DataSource dataSource;

//    検証用　エンコードをオフ
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http.csrf(
                csrf -> csrf
                        .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));
        http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));
        http.csrf().disable();
        http.authorizeHttpRequests(authorize -> {
            authorize.anyRequest().permitAll();
        });
        http.formLogin(form -> {
            form.defaultSuccessUrl("/post")
                    .loginPage("/user/login");
        });
        http.logout()
                .logoutUrl("/user/logout") // ログアウトのURLを変更
                .logoutSuccessUrl("/") // ログアウト成功後のリダイレクト先
                .permitAll();

        return http.build();
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        return new JdbcUserDetailsManager(this.dataSource);
    }

}

