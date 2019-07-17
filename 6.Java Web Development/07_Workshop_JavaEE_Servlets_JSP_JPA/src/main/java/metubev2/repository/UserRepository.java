package metubev2.repository;

import metubev2.domain.entities.User;

public interface UserRepository extends GenericRepository<User, String> {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
