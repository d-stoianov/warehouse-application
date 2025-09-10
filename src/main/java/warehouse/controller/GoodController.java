package warehouse.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import warehouse.model.Good;
import warehouse.repository.GoodRepository;

import java.util.List;

@Tag(name = "Goods", description = "Endpoints for managing goods in the warehouse")
@RestController
public class GoodController {
    private final GoodRepository repository;

    public GoodController(GoodRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/goods")
    List<Good> all() {
        return repository.findAll();
    }

    @PostMapping("/goods")
    Good newGood(@RequestBody Good newGood) {
        return repository.save(newGood);
    }

    @GetMapping("/goods/{id}")
    Good one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Good not found"));
    }

    // TODO: fix this to update each field separately and not reset not specified fields to default values like null or 0
    @PutMapping("/goods/{id}")
    Good replaceGood(@PathVariable Long id, @RequestBody Good newGood) {
        return repository.findById(id).map(good -> {
            good.setName(newGood.getName());
            good.setPrice(newGood.getPrice());
            good.setQuantity(newGood.getQuantity());

            return repository.save(good);
        }).orElseGet(() -> { // create new one if not found
            return repository.save(newGood);
        });
    }

    @DeleteMapping("/goods/{id}")
    void deleteOne(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
