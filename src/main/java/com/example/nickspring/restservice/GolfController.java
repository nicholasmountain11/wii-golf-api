package com.example.nickspring.restservice;

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

    @PostMapping("/player")
    Player newPlayer(@RequestBody Player player) { return golfService.newPlayer(player); }

    @GetMapping("/rounds")
    List<Round> all() { return golfService.getAllRounds(); }

    @PostMapping("/rounds")
    Round newRound(@RequestBody Round newRound) { return golfService.newRound(newRound); }

    @GetMapping("/hole")
    List<Hole> getHoles() { return golfService.getAllHoles(); }

    @PostMapping("/hole")
    Hole newHole(@RequestBody Hole newHole) {return golfService.newHole(newHole); }

}
