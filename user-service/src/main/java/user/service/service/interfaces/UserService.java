package user.service.service.interfaces;

import user.service.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

}
