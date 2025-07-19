package user.service.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import user.service.model.User;
import user.service.repository.UserRepository;
import user.service.service.implementations.UserServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void shouldReturnAllUsers() {
        // Given
        List<User> mockUsers = List.of(
                new User("1", "Alice", "alice@email.com", "password"),
                new User("1", "Bob", "bob@email.com", "password")
        );
        Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

        // When
        List<User> result = userService.findAll();

        // Then
        assertEquals(2, result.size());
        assertEquals("Alice", result.getFirst().getName());
        Mockito.verify(userRepository).findAll();
    }

    @Test
    void shouldSaveUser() {
        // Given
        User user = new User(null, "Charlie", "charlie@email.com", "password");
        User savedUser = new User("123", "Charlie", "charlie@email.com", "password");

        Mockito.when(userRepository.save(user)).thenReturn(savedUser);

        // When
        User result = userService.save(user);

        // Then
        assertNotNull(result.getId());
        assertEquals("Charlie", result.getName());
        Mockito.verify(userRepository).save(user);
    }
}

