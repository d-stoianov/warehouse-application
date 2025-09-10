package warehouse;

import warehouse.model.Good;
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
    CommandLineRunner initDatabase(GoodRepository repository) {

        return args -> {
            log.info("Preloading {}", repository.save(new Good()));
            log.info("Preloading {}", repository.save(new Good("Backpack")));
            log.info("Preloading {}", repository.save(new Good("Expensive pencil", 35.5)));
            log.info("Preloading {}", repository.save(new Good("Super expensive notebook", 100.0, 40)));
        };
    }
}
