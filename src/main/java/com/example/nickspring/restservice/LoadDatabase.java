package com.example.nickspring.restservice;


import com.example.nickspring.restservice.entity.Hole;
import com.example.nickspring.restservice.entity.Player;
import com.example.nickspring.restservice.entity.Round;
import com.example.nickspring.restservice.repository.HoleRepository;
import com.example.nickspring.restservice.repository.PlayerRepository;
import com.example.nickspring.restservice.repository.RoundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PlayerRepository playerRepository, RoundRepository roundRepository, HoleRepository holeRepository) {

        return args -> {
            holeRepository.deleteAll();
            roundRepository.deleteAll();
            playerRepository.deleteAll();


//            log.info("All entries deleted");
//
//            Hole hole1 = new Hole(4, 3, 1);
//            Hole hole2 = new Hole(3, 1, 2);
//            Hole hole3 = new Hole(5, 3, 3);
//            Hole hole4 = new Hole(3, 2, 4);
//            Hole hole5 = new Hole(5, 3, 5);
//            Hole hole6 = new Hole(4, 3, 6);
//            Hole hole7 = new Hole(4, 3, 7);
//            Hole hole8 = new Hole(3, 3, 8);
//            Hole hole9 = new Hole(5, 2, 9);
//
//            Round round1 = new Round();
//
//            Player nick = new Player("Nick Mountain");
//
//            round1.addHole(hole1);
//            round1.addHole(hole2);
//            round1.addHole(hole3);
//            round1.addHole(hole4);
//            round1.addHole(hole5);
//            round1.addHole(hole6);
//            round1.addHole(hole7);
//            round1.addHole(hole8);
//            round1.addHole(hole9);
//
//            nick.addRound(round1);
//
//            log.info("Preloading " + playerRepository.save(nick));

        };
    }
}
