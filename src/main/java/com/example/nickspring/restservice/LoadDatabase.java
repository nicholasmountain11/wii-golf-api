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

        };
    }
}
