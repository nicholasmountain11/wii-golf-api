package com.example.nickspring.restservice;

import java.util.List;

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
}
