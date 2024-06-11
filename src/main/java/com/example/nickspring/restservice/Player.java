package com.example.nickspring.restservice;

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
    private int rating;

    @OneToMany(mappedBy = "player")
    private Set<Round> rounds = new HashSet<>();

    public Player() {}

    public Player(String name) {
        this.name = name;
        this.rating = 0;
    }

    public Player(String name, int rating) {
        this.name = name;
        this.rating = rating;
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
        if (!(o instanceof Player))
            return false;
        Player player = (Player) o;
        return Objects.equals(this.player_id, player.player_id) && Objects.equals(this.name, player.name)
                && Objects.equals(this.rating, player.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.player_id, this.name, this.rating);
    }

    @Override
    public String toString() {
        return "Player{" + "player_id=" + this.player_id + ", name='" + this.name + '\'' + ", rating='" + this.rating + '\'' + '}';
    }

}
