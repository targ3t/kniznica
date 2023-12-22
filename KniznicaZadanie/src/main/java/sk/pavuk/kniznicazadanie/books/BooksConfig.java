package sk.pavuk.kniznicazadanie.books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BooksConfig {

    @Bean
    CommandLineRunner commandLineRunner2(BooksRepository repository){
        return args -> {
            Books book1 = new Books(
                    "Konečne normálna vražda",
                    "Dominik Dán",
                    "Horor",
                    1
            );



            repository.saveAll(
                    List.of(book1)
            );
        };
    }
}


