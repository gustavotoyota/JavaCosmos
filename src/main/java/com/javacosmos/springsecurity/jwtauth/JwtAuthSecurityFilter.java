package com.javacosmos.springsecurity.jwtauth;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthSecurityFilter extends OncePerRequestFilter {
  private JwtTokenService jwtTokenService;
  private InMemoryUserDetailsManager userDetailsManager;

  public JwtAuthSecurityFilter(JwtTokenService jwtTokenService, InMemoryUserDetailsManager userDetailsManager) {
    this.jwtTokenService = jwtTokenService;
    this.userDetailsManager = userDetailsManager;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String authorizationHeader = request.getHeader("Authorization");

    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      String jwtToken = authorizationHeader.substring(7);

      String subject = jwtTokenService.validateToken(jwtToken);

      UserDetails userDetails = userDetailsManager.loadUserByUsername(subject);

      var authentication = new UsernamePasswordAuthenticationToken(subject, null, userDetails.getAuthorities());

      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }
}
