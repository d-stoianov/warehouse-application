package warehouse.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import warehouse.dto.CategoryDto;
import warehouse.model.Category;
import warehouse.repository.CategoryRepository;
import warehouse.repository.GoodRepository;

import java.util.List;

@Tag(name = "Categories", description = "Endpoints for managing categories in the warehouse")
@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final GoodRepository goodRepository;

    public CategoryController(CategoryRepository categoryRepository, GoodRepository goodRepository) {
        this.categoryRepository = categoryRepository;
        this.goodRepository = goodRepository;
    }

    @GetMapping("/categories")
    List<Category> all() {
        return categoryRepository.findAll();
    }

    @PostMapping("/categories")
    Category newCategory(@RequestBody CategoryDto newCategory) {
        Category category = new Category(newCategory.getName());
        return categoryRepository.save(category);
    }

    @GetMapping("/categories/{id}")
    Category one(@PathVariable Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @PutMapping("/categories/{id}")
    Category replaceCategory(@PathVariable Long id, @RequestBody CategoryDto newCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(newCategory.getName());

            return categoryRepository.save(category);
        }).orElseGet(() -> { // create new one if not found
            Category category = new Category(newCategory.getName());
            return categoryRepository.save(category);
        });
    }

    @DeleteMapping("/categories/{id}")
    void deleteOne(@PathVariable Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // unlink category from goods
        goodRepository.findAllByCategory(category).forEach(good -> {
            good.setCategory(null);
            goodRepository.save(good);
        });

        // delete the category
        categoryRepository.delete(category);
    }
}
