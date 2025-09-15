package warehouse.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import warehouse.dto.SupplierDto;
import warehouse.model.Supplier;
import warehouse.repository.SupplierRepository;

import java.util.List;

@Tag(name = "Suppliers", description = "Endpoints for managing suppliers in the warehouse")
@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierRepository repository;

    public SupplierController(SupplierRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Supplier> all() {
        return repository.findAll();
    }

    @PostMapping("")
    Supplier newSupplier(@RequestBody SupplierDto newSupplier) {
        Supplier supplier = new Supplier(newSupplier.getContactInfo(), newSupplier.getAddress());
        return repository.save(supplier);
    }

    @GetMapping("/{id}")
    public Supplier one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
    }

    @PutMapping("/{id}")
    public Supplier replaceSupplier(@PathVariable Long id, @RequestBody SupplierDto newSupplier) {
        return repository.findById(id).map(supplier -> {
            if (newSupplier.getContactInfo() != null) {
                supplier.setContactInfo(newSupplier.getContactInfo());
            }
            if (newSupplier.getAddress() != null) {
                supplier.setAddress(newSupplier.getAddress());
            }
            return repository.save(supplier);
        }).orElseGet(() -> {
            Supplier supplier = new Supplier();
            supplier.setContactInfo(newSupplier.getContactInfo());
            supplier.setAddress(newSupplier.getAddress());
            return repository.save(supplier);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
