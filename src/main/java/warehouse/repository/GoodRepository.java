package warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.model.Category;
import warehouse.model.Good;

import java.util.List;

public interface GoodRepository extends JpaRepository<Good, Long> {
    List<Good> findAllByCategory(Category category);
}
