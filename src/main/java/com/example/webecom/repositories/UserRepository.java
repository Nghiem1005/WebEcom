package com.example.webecom.repositories;

import com.example.webecom.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findUserByEmail(String email);
  Optional<User> findUserByPhone(String phone);
}
