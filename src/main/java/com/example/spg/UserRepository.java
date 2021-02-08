package com.example.spg;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.spg.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  User findByName(String name);
  boolean existsByName(String name);
}
