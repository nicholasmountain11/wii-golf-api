package com.example.nickspring.restservice.model;

import com.example.nickspring.restservice.entity.Round;

public class TopRoundReturnModel {

    private Round round;
    private String playerName;

    public TopRoundReturnModel(Round round, String playerName) {
        this.round = round;
        this.playerName = playerName;
    }

    public Round getRound() {
        return round;
    }

    public String getPlayerName() {
        return playerName;
    }
}
