package com.example.nickspring.restservice.entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "round")
public class Round {

    private @Id
    @GeneratedValue
    @Column(name = "round_id")
    Long round_id;

    @OneToMany(mappedBy = "round", cascade = CascadeType.ALL)
    private Set<Hole> holes = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;


    public Round() {}

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getId() { return this.round_id; }

    public void setId(Long id) {
        this.round_id = id;
    }

    public Set<Hole> getHoles() {
        return holes;
    }

    public void setHoles(Set<Hole> holes) {
        this.holes = holes;
    }

    public void addHole(Hole hole) {
        this.holes.add(hole);
        hole.setRound(this);
    }

}
