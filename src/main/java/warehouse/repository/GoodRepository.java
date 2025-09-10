package warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.model.Good;

public interface GoodRepository extends JpaRepository<Good, Long> {
}
