package user.service.service.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import user.service.model.User;
import user.service.repository.UserRepository;
import user.service.service.interfaces.UserService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        log.info("Fetching all users from database");
        List<User> users = userRepository.findAll();
        log.debug("Fetched {} users", users.size());
        return users;
    }

    @Override
    public User save(User user) {
        log.info("Saving new user with email: {}", user.getEmail());
        User saved = userRepository.save(user);
        log.debug("User saved with ID: {}", saved.getId());
        return saved;
    }
}
