package com.javacosmos.springsecurity;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.javacosmos.springsecurity.jwtauth.JwtAuthSecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityFilterChainConfig {
  @Bean
  @Order(1) // Required to ensure the order of the SecurityFilterChains
  // Only the first SecurityFilterChain that matches the request will be used
  SecurityFilterChain basicAuthFilterChain(HttpSecurity http) throws Exception {
    return http
        .securityMatcher("/basic-auth/**")
        .authorizeHttpRequests(authorize -> authorize
            .anyRequest().authenticated())
        .httpBasic(withDefaults())
        .build();
  }

  @Bean
  @Order(2)
  SecurityFilterChain formAuthFilterChain(HttpSecurity http) throws Exception {
    return http
        .securityMatcher("/form-auth/**")
        .authorizeHttpRequests(auth -> auth
            .anyRequest().authenticated())
        .formLogin(login -> login
            .loginPage("/form-auth/login")
            .loginProcessingUrl("/form-auth/login")
            .defaultSuccessUrl("/form-auth/test", true)
            .permitAll())
        .logout(logout -> logout
            .logoutUrl("/form-auth/logout")
            .logoutSuccessUrl("/form-auth/login?logout")
            .permitAll())
        .build();
  }

  @Autowired
  private JwtAuthSecurityFilter jwtAuthSecurityFilter;

  @Bean
  @Order(3)
  SecurityFilterChain jwtAuthFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .securityMatcher("/jwt-auth/**")
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/jwt-auth/register", "/jwt-auth/login").permitAll()
            .requestMatchers("/jwt-auth/admin").hasRole("ADMIN")
            .anyRequest().authenticated())
        .addFilterBefore(jwtAuthSecurityFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }

  @Bean
  @Order(4)
  SecurityFilterChain disableCSRFByDefault(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
  }
}
