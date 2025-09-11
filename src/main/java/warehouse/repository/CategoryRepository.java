package warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
