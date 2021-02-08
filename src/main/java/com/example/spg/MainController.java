package com.example.spg;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(path="/api/users")
public class MainController {
  @Autowired
  private UserRepository userRepository;

  @PostMapping
  public @ResponseBody User createUser(@RequestBody User user) {
    User n = new User();
    n.setName(user.getName());
    n.setEmail(user.getEmail());
    if(!userRepository.existsByName(user.getName()))
      userRepository.save(n);
    return userRepository.findByName(user.getName());
  }

  @GetMapping
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public @ResponseBody Optional<User> getUser(@PathVariable String id) {
    return userRepository.findById(Integer.parseInt(id));
  }
}
