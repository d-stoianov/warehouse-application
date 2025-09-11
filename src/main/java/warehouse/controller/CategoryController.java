package warehouse.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import warehouse.model.Category;
import warehouse.repository.CategoryRepository;

import java.util.List;

@Tag(name = "Categories", description = "Endpoints for managing categories in the warehouse")
@RestController
public class CategoryController {
    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categories")
    List<Category> all() {
        return repository.findAll();
    }

    @PostMapping("/categories")
    Category newCategory(@RequestBody Category newCategory) {
        return repository.save(newCategory);
    }

    @GetMapping("/categories/{id}")
    Category one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @PutMapping("/categories/{id}")
    Category replaceCategory(@PathVariable Long id, @RequestBody Category newCategory) {
        return repository.findById(id).map(category -> {
            category.setName(newCategory.getName());

            return repository.save(category);
        }).orElseGet(() -> { // create new one if not found
            return repository.save(newCategory);
        });
    }

    // TODO: remove category on goods that was linked to that category
    @DeleteMapping("/categories/{id}")
    void deleteOne(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
