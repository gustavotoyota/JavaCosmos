package com.javacosmos.springsecurity.jwtauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt-auth")
public class JwtAuthController {
  @Autowired
  private InMemoryUserDetailsManager userDetailsManager;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenService jwtTokenService;

  private record JwtRegisterDTO(
      String username,
      String password) {
  }

  @PostMapping("/register")
  public ResponseEntity<Object> register(@RequestBody JwtRegisterDTO jwtRegisterDTO) {
    if (userDetailsManager.userExists(jwtRegisterDTO.username)) {
      return ResponseEntity.badRequest().build();
    }

    String encryptedPassword = passwordEncoder.encode(jwtRegisterDTO.password);

    UserDetails newUser = User.withUsername(jwtRegisterDTO.username)
        .password(encryptedPassword)
        .roles("USER")
        .build();

    userDetailsManager.createUser(newUser);

    return ResponseEntity.ok().build();
  }

  private record JwtLoginDTO(
      String username,
      String password) {
  }

  private record JwtLoginResponseDTO(
      String token) {
  }

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody JwtLoginDTO jwtLoginDTO) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(jwtLoginDTO.username, jwtLoginDTO.password);

    authenticationManager.authenticate(usernamePassword);

    String token = jwtTokenService.generateToken(jwtLoginDTO.username);

    return ResponseEntity.ok(new JwtLoginResponseDTO(token));
  }

  @GetMapping("/test")
  public String test() {
    return "JWT Auth test successful!";
  }

  @GetMapping("/admin")
  public String admin() {
    return "JWT Auth admin test successful!";
  }
}
