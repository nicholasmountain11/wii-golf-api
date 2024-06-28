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
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GolfController {
    private final GolfService golfService;

    GolfController(PlayerRepository playerRepository, RoundRepository roundRepository, HoleRepository holeRepository) {
        this.golfService = new GolfService(new DataRepository(roundRepository, playerRepository, holeRepository));
    }

    @GetMapping("/player")
    List<Player> allPlayers() { return golfService.getAllPlayers(); }

    @PostMapping("/player")
    Player newPlayer(@RequestBody Player player) {
        System.out.println("route called");
        return golfService.newPlayer(player);
    }

    @GetMapping("/rounds")
    List<Round> all() { return golfService.getAllRounds(); }

    @PostMapping("/rounds")
    Round newRound(@RequestBody Round newRound) {
        return golfService.newRound(newRound);
    }

    @GetMapping("/hole")
    List<Hole> getHoles() {
        return golfService.getAllHoles();
    }

    @PostMapping("/hole")
    Hole newHole(@RequestBody Hole newHole) {
        return golfService.newHole(newHole);
    }

    @GetMapping("/getHolesByRound/{roundId}")
    List<Hole> getHolesByRound(@PathVariable Long roundId) {

        return golfService.getHolesByRound(roundId);
    }

    @GetMapping("/getRoundsByPlayer/{playerId}")
    List<Round> getRoundsByPlayer(@PathVariable Long playerId) {

        return golfService.getRoundsByPlayer(playerId);
    }

    @PostMapping("/addRoundByPlayer/{playerId}")
    Round addRoundByPlayer(@PathVariable Long playerId, @RequestBody Set<Hole> newRound) {
        return golfService.addRoundByPlayer(newRound, playerId);
    }

    @GetMapping("/getLowestScoringRounds/{roundAmount}")
    List<Round> getLowestScoringRounds(@PathVariable int roundAmount) {
        return golfService.getLowestScoringRounds(roundAmount);
    }

}
