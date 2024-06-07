package com.example.nickspring.restservice;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "round")
public class Round {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "round_id")
    Long round_id;

    @OneToMany(mappedBy = "round")
    private Set<Hole> holes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public Round(Player player) {
        this.player = player;
    }

    public Round() {}

    public Long getId() { return this.round_id; }

    public void setId(Long id) {
        this.round_id = id;
    }

    public Set<Hole> getHoles() { return this.holes; }

    public Player getPlayer() { return this.player; }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Round))
            return false;
        Round round = (Round) o;
        return Objects.equals(this.round_id, round.round_id) && Objects.equals(this.holes, round.holes)
                && Objects.equals(this.player, round.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.round_id, this.player, this.holes);
    }

    @Override
    public String toString() {
        return "Round{" + "round_id=" + this.round_id + ", holes='" + this.holes + '\'' + ", player='" + this.player + '\'' + '}';
    }

}
