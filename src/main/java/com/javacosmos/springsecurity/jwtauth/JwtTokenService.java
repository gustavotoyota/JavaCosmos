package com.javacosmos.springsecurity.jwtauth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;

@Service
public class JwtTokenService {
  @Value("${jwt.secret:secret}")
  private String secret;

  public String generateToken(String username) {
    Algorithm algorithm = Algorithm.HMAC256(secret);

    return com.auth0.jwt.JWT.create()
        .withIssuer("JavaCosmos")
        .withSubject(username)
        .withExpiresAt(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
        .sign(algorithm);
  }

  public String validateToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secret);

    return com.auth0.jwt.JWT.require(algorithm)
        .withIssuer("JavaCosmos")
        .build()
        .verify(token)
        .getSubject();
  }
}
