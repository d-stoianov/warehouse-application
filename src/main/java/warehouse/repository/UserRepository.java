package warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
