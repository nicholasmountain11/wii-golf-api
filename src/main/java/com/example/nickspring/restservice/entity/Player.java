package com.example.nickspring.restservice.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name ="player")
public class Player {
    private @Id
    @GeneratedValue
    @Column(name = "player_id")
    Long player_id;
    private String name;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Round> rounds = new HashSet<>();

    public Player() {}

    public Player(String name) {
        this.name = name;
    }

    public Set<Round> getRounds() {
        return rounds;
    }

    public void setRounds(Set<Round> rounds) {
        this.rounds = rounds;
    }

    public Long getId() { return this.player_id; }

    public void setId(Long id) {
        this.player_id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRound(Round round) {
        this.rounds.add(round);
        round.setPlayer(this);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Player))
            return false;
        Player player = (Player) o;
        return Objects.equals(this.player_id, player.player_id) && Objects.equals(this.name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.player_id, this.name);
    }

    @Override
    public String toString() {
        return "Player{" + "player_id=" + this.player_id + ", name='" + this.name + '\'' + '}';
    }

}
