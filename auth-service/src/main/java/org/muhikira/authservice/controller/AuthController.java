package org.muhikira.authservice.controller;

import lombok.RequiredArgsConstructor;
import org.muhikira.authservice.dto.UserDto;
import org.muhikira.authservice.model.AuthRequest;
import org.muhikira.authservice.model.AuthResponse;
import org.muhikira.authservice.service.UserService;
import org.muhikira.authservice.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final UserService userService;
  private final JwtUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
    );
    final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    final String jwt = jwtUtil.generateToken(userDetails.getUsername());
    return ResponseEntity.ok(new AuthResponse(jwt));
  }

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
    userService.registerUser(userDto);
    return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
  }

}
