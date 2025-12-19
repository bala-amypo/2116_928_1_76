package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
private final UserService service;

public UserController(UserService service) {
this.service = service;
}

@PostMapping("/register")
public User register(@RequestBody User user) {
return service.register(user);
}

@GetMapping("/{userId}")
public User getUser(@PathVariable Long userId) {
return service.findById(userId);
}
}
