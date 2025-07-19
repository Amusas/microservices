package user.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import user.service.model.User;

public interface UserRepository extends MongoRepository<User,String> {
}

