package com.example.nickspring.restservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, PlayerRepository playerRepository, RoundRepository roundRepository, HoleRepository holeRepository) {

        return args -> {
            repository.deleteAll();
            holeRepository.deleteAll();
            roundRepository.deleteAll();
            playerRepository.deleteAll();


            log.info("All entries deleted");

            Player nick = new Player("Nick Mountain");
            Round round1 = new Round(nick);
            Hole hole1 = new Hole(3, 3, 1, round1);

            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
            log.info("Preloading " + playerRepository.save(nick));
            log.info("Preloading " + roundRepository.save(round1));
            log.info("Preloading " + holeRepository.save(hole1));
        };
    }
}
