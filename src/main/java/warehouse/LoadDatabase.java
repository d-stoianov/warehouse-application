package warehouse;

import warehouse.model.Category;
import warehouse.model.Good;
import warehouse.repository.CategoryRepository;
import warehouse.repository.GoodRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(GoodRepository goodRepository, CategoryRepository categoryRepository) {

        return args -> {
            Category schoolGoodsCat = categoryRepository.save(new Category("School Goods"));

            log.info("Preloading {}", goodRepository.save(new Good("Good with no category")));
            log.info("Preloading {}", goodRepository.save(new Good("Backpack", schoolGoodsCat)));
            log.info("Preloading {}", goodRepository.save(new Good("Expensive pencil", schoolGoodsCat, 35.5)));
            log.info("Preloading {}", goodRepository.save(new Good("Super expensive notebook", schoolGoodsCat, 150.35, 10)));
        };
    }
}
