package warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.model.Category;
import warehouse.model.Good;
import warehouse.model.Supplier;

import java.util.List;

public interface GoodRepository extends JpaRepository<Good, Long> {
    List<Good> findAllByCategory(Category category);

    List<Good> findAllBySupplier(Supplier supplier);
}
