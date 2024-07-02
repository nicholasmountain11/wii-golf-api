package com.example.nickspring.restservice.service;

import com.example.nickspring.restservice.entity.Hole;
import com.example.nickspring.restservice.entity.Player;
import com.example.nickspring.restservice.entity.Round;
import com.example.nickspring.restservice.model.TopRoundReturnModel;
import com.example.nickspring.restservice.repository.DataRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GolfService {
    private final DataRepository data;

    public GolfService(DataRepository data) { this.data = data; }

    public List<Player> getAllPlayers() { return data.playerRepository.findAll(); }

    public Player newPlayer(Player player) {
        return data.playerRepository.save(player);
    }

    public List<Round> getAllRounds() { return data.roundRepository.findAll(); }

    public Round newRound(Round round) { return data.roundRepository.save(round); }

    public List<Hole> getAllHoles() { return data.holeRepository.findAll(); }

    public Hole newHole(Hole hole) { return data.holeRepository.save(hole); }

    public List<Hole> getHolesByRound(Long roundId) {
        Round round = data.roundRepository.findById(roundId).orElseThrow(() -> new RuntimeException("Round not found"));
        return data.holeRepository.findByRound(round);
    }

    public List<Round> getRoundsByPlayer(Long playerId) {
        Player player = data.playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found"));
        return data.roundRepository.findByPlayer(player);
    }

    public Round addRoundByPlayer(Set<Hole> holes, Long playerId) {
        Player player = data.playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found"));
        Round round = new Round();
        for (Hole hole : holes) {
            round.addHole(hole);
        }
        player.addRound(round);
        data.playerRepository.save(player);
        return round;
    }


    public List<TopRoundReturnModel> getLowestScoringRounds(int roundAmount) {
        List<Round> roundList = data.roundRepository.findRoundsWithLowestScores(PageRequest.of(0, roundAmount));
        List<TopRoundReturnModel> returnModels = new ArrayList<>();
        for (Round round : roundList) {
            Player player = data.roundRepository.findPlayerByRoundId(round.getId());
            returnModels.add(new TopRoundReturnModel(round, player.getName()));
        }

        return returnModels;

    }
}
