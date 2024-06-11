package com.example.nickspring.restservice;

import javax.xml.crypto.Data;

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
