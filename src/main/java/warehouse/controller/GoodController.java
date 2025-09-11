package warehouse.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import warehouse.dto.GoodDto;
import warehouse.model.Good;
import warehouse.model.Category;
import warehouse.repository.GoodRepository;
import warehouse.repository.CategoryRepository;

import java.util.List;

@Tag(name = "Goods", description = "Endpoints for managing goods in the warehouse")
@RestController
@RequestMapping("/goods")
public class GoodController {
    private final GoodRepository goodRepository;
    private final CategoryRepository categoryRepository;

    public GoodController(GoodRepository goodRepository, CategoryRepository categoryRepository) {
        this.goodRepository = goodRepository;
        this.categoryRepository = categoryRepository;
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
                    .orElseThrow(() -> new RuntimeException("Category not found"));

            good.setCategory(category);
        }

        return goodRepository.save(good);
    }

    @GetMapping("/{id}")
    public Good one(@PathVariable Long id) {
        return goodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Good not found"));
    }

    @PutMapping("/{id}")
    public Good replaceGood(@PathVariable Long id, @RequestBody GoodDto goodDto) {
        return goodRepository.findById(id).map(good -> {
            if (goodDto.getName() != null) good.setName(goodDto.getName());
            if (goodDto.getPrice() != 0) good.setPrice(goodDto.getPrice());
            if (goodDto.getQuantity() != 0) good.setQuantity(goodDto.getQuantity());

            if (goodDto.getCategoryId() != null) {
                Category category = categoryRepository.findById(goodDto.getCategoryId())
                        .orElseThrow(() -> new RuntimeException("Category not found"));
                good.setCategory(category);
            }

            return goodRepository.save(good);
        }).orElseThrow(() -> new RuntimeException("Good not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        goodRepository.deleteById(id);
    }
}
