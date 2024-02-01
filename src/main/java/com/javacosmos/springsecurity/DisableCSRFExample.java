package com.javacosmos.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

/*
 * Why disable CSRF?
 * 
 * CSRF prevents post requests without a CSRF token.
 * It is meant to protect against browser-based attacks.
 * Disable it if your requests aren't supposed to come from browsers.
 * 
 * Tip: Never disable CSRF while leaving sessionManagement enabled.
 */

@Controller
public class DisableCSRFExample {
  @Bean
  public SecurityFilterChain disableCSRF(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
  }
}
