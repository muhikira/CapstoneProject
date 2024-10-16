package org.muhikira.authservice.service;

import lombok.RequiredArgsConstructor;
import org.muhikira.authservice.dto.UserDto;
import org.muhikira.authservice.entity.User;
import org.muhikira.authservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public void registerUser(UserDto userDto) {

    String encodedPassword = passwordEncoder.encode(userDto.getPassword());

    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(encodedPassword);

    userRepository.save(user);
  }
}
