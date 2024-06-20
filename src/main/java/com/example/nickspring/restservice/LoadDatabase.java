package com.example.nickspring.restservice;


import com.example.nickspring.restservice.entity.Employee;
import com.example.nickspring.restservice.entity.Hole;
import com.example.nickspring.restservice.entity.Player;
import com.example.nickspring.restservice.entity.Round;
import com.example.nickspring.restservice.repository.EmployeeRepository;
import com.example.nickspring.restservice.repository.HoleRepository;
import com.example.nickspring.restservice.repository.PlayerRepository;
import com.example.nickspring.restservice.repository.RoundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

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

            Hole hole1 = new Hole(3, 3, 1);
            Hole hole2 = new Hole(4, 5, 2);
            Hole hole3 = new Hole(3, 2, 1);

            Round round1 = new Round();
            Round round2 = new Round();

            Player nick = new Player("Nick Mountain");
            Player lebron = new Player("Lebron James");

            round1.addHole(hole1);
            round1.addHole(hole2);
            round2.addHole(hole3);

            nick.addRound(round1);
            lebron.addRound(round2);

            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));

            log.info("Preloading " + playerRepository.save(nick));
            log.info("Preloading " + playerRepository.save(lebron));

        };
    }
}
