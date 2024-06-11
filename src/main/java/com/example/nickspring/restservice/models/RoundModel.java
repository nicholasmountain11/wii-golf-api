package com.example.nickspring.restservice.models;

import com.example.nickspring.restservice.entities.Hole;

import java.util.HashSet;
import java.util.Set;

public class RoundModel {

    private Long round_id;
    private Set<Hole> holes;
    private Long player_id;

    public RoundModel(Long round_id, Long player_id) {
        this.round_id = round_id;
        this.holes = new HashSet<>();
        this.player_id = player_id;
    }

    public RoundModel(Long round_id, Set<Hole> holes, Long player_id) {
        this.round_id = round_id;
        this.holes = holes;
        this.player_id = player_id;
    }

    public Long getRound_id() { return this.round_id; }

    public Set<Hole> getHoles() { return this.holes; }
}
