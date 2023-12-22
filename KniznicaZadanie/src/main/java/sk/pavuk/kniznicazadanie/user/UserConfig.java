package sk.pavuk.kniznicazadanie.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User admin = new User(
                    "admin@gmail.com",
                    "admin",
                    "Admin"
            );

            User user1 = new User(
                    "user1@gmail.com",
                    "user1",
                    "User"
            );

            repository.saveAll(
                    List.of(admin, user1)
            );
        };
    }
}
