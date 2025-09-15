package warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
