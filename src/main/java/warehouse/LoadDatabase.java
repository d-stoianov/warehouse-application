package warehouse;

import warehouse.model.Category;
import warehouse.model.Good;
import warehouse.model.Supplier;
import warehouse.model.common.Address;
import warehouse.model.common.ContactInfo;
import warehouse.repository.CategoryRepository;
import warehouse.repository.GoodRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import warehouse.repository.SupplierRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // Initiate DB with mocks
    @Bean
    CommandLineRunner initDatabase(GoodRepository goodRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {

        return args -> {
            // suppliers
            ContactInfo dimaContactInfo = new ContactInfo("Dima Stoianov", "+1111111111", "dimasupplier@gmail.com");
            Address dimaAddress = new Address("2011AA", "Odesa", "Street Of Someone", 777, null);
            Supplier dimaSupplier = new Supplier(dimaContactInfo, dimaAddress);
            supplierRepository.save(dimaSupplier);

            // categories
            Category schoolGoodsCat = new Category("School Goods");
            categoryRepository.save(schoolGoodsCat);

            // goods
            log.info("Preloading {}", goodRepository.save(new Good("Good with no category")));
            log.info("Preloading {}", goodRepository.save(new Good("Backpack").setCategory(schoolGoodsCat)));
            log.info("Preloading {}", goodRepository.save(new Good("Expensive pencil", 35.5).setCategory(schoolGoodsCat)));
            log.info("Preloading {}", goodRepository.save(new Good("Super expensive notebook", 150.35, 10).setCategory(schoolGoodsCat).setSupplier(dimaSupplier)));
        };
    }
}
