package com.javacosmos.springsecurity;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
 * This class uses the newer Spring Security 5.0+ configuration style.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user1 = User.withUsername("user")
        .password(passwordEncoder().encode("password"))
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(user1);
  }

  @Bean
  @Order(1)
  SecurityFilterChain httpBasicAuthFilterChain(HttpSecurity http) throws Exception {
    return http
        .securityMatcher("/basic-auth/**")
        .authorizeHttpRequests(authorize -> authorize
            .anyRequest().authenticated())
        .httpBasic(withDefaults())
        .build();
  }

  @Bean
  @Order(2)
  SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
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

  @Bean
  @Order(3)
  SecurityFilterChain disableCSRF(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
  }
}
