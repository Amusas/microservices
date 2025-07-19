package user.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.service.model.User;
import user.service.service.interfaces.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        log.info("Received request to create user: {}", user.getEmail());
        User createdUser = userService.save(user);
        log.info("User created successfully with ID: {}", createdUser.getId());
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        log.info("Received request to list all users");
        List<User> users = userService.findAll();
        log.info("Returning {} users", users.size());
        return ResponseEntity.ok(users);
    }
}
