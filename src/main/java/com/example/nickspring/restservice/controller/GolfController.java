package com.example.nickspring.restservice.controller;

import com.example.nickspring.restservice.entity.Hole;
import com.example.nickspring.restservice.entity.Player;
import com.example.nickspring.restservice.entity.Round;
import com.example.nickspring.restservice.repository.DataRepository;
import com.example.nickspring.restservice.repository.HoleRepository;
import com.example.nickspring.restservice.repository.PlayerRepository;
import com.example.nickspring.restservice.repository.RoundRepository;
import com.example.nickspring.restservice.service.GolfService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GolfController {
    private final GolfService golfService;

    GolfController(PlayerRepository playerRepository, RoundRepository roundRepository, HoleRepository holeRepository) {
        this.golfService = new GolfService(new DataRepository(roundRepository, playerRepository, holeRepository));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/player")
    List<Player> allPlayers() { return golfService.getAllPlayers(); }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/player")
    Player newPlayer(@RequestBody Player player) { return golfService.newPlayer(player); }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/rounds")
    List<Round> all() { return golfService.getAllRounds(); }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/rounds")
    Round newRound(@RequestBody Round newRound) { return golfService.newRound(newRound); }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/hole")
    List<Hole> getHoles() { return golfService.getAllHoles(); }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/hole")
    Hole newHole(@RequestBody Hole newHole) {return golfService.newHole(newHole); }

}
