package warehouse.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import warehouse.dto.GoodDto;
import warehouse.model.Good;
import warehouse.model.Category;
import warehouse.model.Supplier;
import warehouse.repository.GoodRepository;
import warehouse.repository.CategoryRepository;
import warehouse.repository.SupplierRepository;

import java.util.List;

@Tag(name = "Goods", description = "Endpoints for managing goods in the warehouse")
@RestController
@RequestMapping("/goods")
public class GoodController {
    private final GoodRepository goodRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    public GoodController(GoodRepository goodRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {
        this.goodRepository = goodRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @GetMapping
    public List<Good> all() {
        return goodRepository.findAll();
    }

    @PostMapping
    public Good newGood(@RequestBody GoodDto goodDto) {
        Good good = new Good();
        good.setName(goodDto.getName());
        good.setPrice(goodDto.getPrice());
        good.setQuantity(goodDto.getQuantity());

        if (goodDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(goodDto.getCategoryId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

            good.setCategory(category);
        }

        if (goodDto.getSupplierId() != null) {
            Supplier supplier = supplierRepository.findById(goodDto.getSupplierId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));

            good.setSupplier(supplier);
        }

        return goodRepository.save(good);
    }

    @GetMapping("/{id}")
    public Good one(@PathVariable Long id) {
        return goodRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Good not found"));
    }

    @PutMapping("/{id}")
    public Good replaceGood(@PathVariable Long id, @RequestBody GoodDto goodDto) {
        return goodRepository.findById(id).map(good -> {
            good.setName(goodDto.getName());
            good.setPrice(goodDto.getPrice());
            good.setQuantity(goodDto.getQuantity());

            if (goodDto.getCategoryId() != null) {
                Category category = categoryRepository.findById(goodDto.getCategoryId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
                good.setCategory(category);
            } else {
                good.setCategory(null);
            }

            if (goodDto.getSupplierId() != null) {
                Supplier supplier = supplierRepository.findById(goodDto.getSupplierId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
                good.setSupplier(supplier);
            } else {
                good.setSupplier(null);
            }

            return goodRepository.save(good);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Good not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        goodRepository.deleteById(id);
    }
}
