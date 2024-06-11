package com.example.nickspring.restservice.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PlayerModel {

    private Long player_id;
    private String name;
    private int rating;
    private Set<RoundModel> rounds;

    public PlayerModel(Long player_id, String name) {
        this.player_id = player_id;
        this.name = name;
        this.rating = 0;
        this.rounds = new HashSet<>();
    }

    public PlayerModel(Long player_id, String name, Set<RoundModel> rounds) {
        this.player_id = player_id;
        this.name = name;
        this.rating = 0;
        this.rounds = rounds;
    }

    public Long getId() { return this.player_id; }

    public void setId(Long id) {
        this.player_id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getRating() { return this.rating; }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) { this.rating = rating; }

    public void addToRating(int increase) {
        this.rating = this.rating + increase;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof PlayerModel))
            return false;
        PlayerModel player = (PlayerModel) o;
        return Objects.equals(this.player_id, player.player_id) && Objects.equals(this.name, player.name)
                && Objects.equals(this.rating, player.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.player_id, this.name, this.rating);
    }



}
