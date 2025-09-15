package warehouse.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import warehouse.dto.SupplierDto;
import warehouse.model.Supplier;
import warehouse.repository.GoodRepository;
import warehouse.repository.SupplierRepository;

import java.util.List;

@Tag(name = "Suppliers", description = "Endpoints for managing suppliers in the warehouse")
@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierRepository supplierRepository;
    private final GoodRepository goodRepository;

    public SupplierController(SupplierRepository supplierRepository, GoodRepository goodRepository) {
        this.supplierRepository = supplierRepository;
        this.goodRepository = goodRepository;
    }

    @GetMapping("")
    List<Supplier> all() {
        return supplierRepository.findAll();
    }

    @PostMapping("")
    Supplier newSupplier(@RequestBody SupplierDto newSupplier) {
        Supplier supplier = new Supplier(newSupplier.getContactInfo(), newSupplier.getAddress());
        return supplierRepository.save(supplier);
    }

    @GetMapping("/{id}")
    public Supplier one(@PathVariable Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
    }

    @PutMapping("/{id}")
    public Supplier replaceSupplier(@PathVariable Long id, @RequestBody SupplierDto newSupplier) {
        return supplierRepository.findById(id).map(supplier -> {
            supplier.setContactInfo(newSupplier.getContactInfo());
            supplier.setAddress(newSupplier.getAddress());

            return supplierRepository.save(supplier);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));

        // unlink supplier from goods
        goodRepository.findAllBySupplier(supplier).forEach(good -> {
            good.setSupplier(null);
            goodRepository.save(good);
        });

        // delete the category
        supplierRepository.delete(supplier);
    }
}
