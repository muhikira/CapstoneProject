package org.muhikira.authservice.repository;

import java.util.Optional;
import org.muhikira.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
