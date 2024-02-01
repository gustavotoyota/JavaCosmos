package com.javacosmos.springsecurity.formlogin;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class FormLoginExample {
  @Bean
  public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
    return http
        .securityMatcher("/form-login/**")
        .authorizeHttpRequests(auth -> auth
            .anyRequest().authenticated())
        .formLogin(withDefaults())
        .build();
  }
}
