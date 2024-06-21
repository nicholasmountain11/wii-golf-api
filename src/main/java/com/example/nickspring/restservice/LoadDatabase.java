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

            Hole hole1 = new Hole(4, 3, 1);
            Hole hole2 = new Hole(3, 1, 2);
            Hole hole3 = new Hole(5, 3, 3);
            Hole hole4 = new Hole(3, 2, 4);
            Hole hole5 = new Hole(5, 3, 5);
            Hole hole6 = new Hole(4, 3, 6);
            Hole hole7 = new Hole(4, 3, 7);
            Hole hole8 = new Hole(3, 3, 8);
            Hole hole9 = new Hole(5, 2, 9);

            Hole hole10 = new Hole(4, 3, 1);
            Hole hole11 = new Hole(3, 3, 2);
            Hole hole12 = new Hole(5, 5, 3);
            Hole hole13 = new Hole(3, 2, 4);
            Hole hole14 = new Hole(5, 4, 5);
            Hole hole15 = new Hole(4, 3, 6);
            Hole hole16 = new Hole(4, 3, 7);
            Hole hole17 = new Hole(3, 2, 8);
            Hole hole18 = new Hole(5, 4, 9);

            Round round1 = new Round();
            Round round2 = new Round();

            Player nick = new Player("Nick Mountain", 1677);
            Player lebron = new Player("Lebron James", 1841);

            round1.addHole(hole1);
            round1.addHole(hole2);
            round1.addHole(hole3);
            round1.addHole(hole4);
            round1.addHole(hole5);
            round1.addHole(hole6);
            round1.addHole(hole7);
            round1.addHole(hole8);
            round1.addHole(hole9);
            round2.addHole(hole10);
            round2.addHole(hole11);
            round2.addHole(hole12);
            round2.addHole(hole13);
            round2.addHole(hole14);
            round2.addHole(hole15);
            round2.addHole(hole16);
            round2.addHole(hole17);
            round2.addHole(hole18);

            nick.addRound(round1);
            lebron.addRound(round2);

            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));

            log.info("Preloading " + playerRepository.save(nick));
            log.info("Preloading " + playerRepository.save(lebron));

        };
    }
}
