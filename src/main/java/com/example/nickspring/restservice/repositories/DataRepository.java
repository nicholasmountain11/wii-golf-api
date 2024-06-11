package com.example.nickspring.restservice.repositories;

import com.example.nickspring.restservice.repositories.HoleRepository;
import com.example.nickspring.restservice.repositories.PlayerRepository;
import com.example.nickspring.restservice.repositories.RoundRepository;

public class DataRepository {
    public final RoundRepository roundRepository;
    public final PlayerRepository playerRepository;
    public final HoleRepository holeRepository;

    public DataRepository(RoundRepository roundRepository, PlayerRepository playerRepository, HoleRepository holeRepository) {
        this.roundRepository = roundRepository;
        this.playerRepository = playerRepository;
        this.holeRepository = holeRepository;
    }
}
