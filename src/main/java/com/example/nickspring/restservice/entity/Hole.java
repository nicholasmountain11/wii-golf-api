package com.example.nickspring.restservice.entity;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "hole")
public class Hole {

    private @Id
    @GeneratedValue
    @Column(name = "hole_id")
    Long hole_id;
    private int par;
    private int shots;

    private int hole_number;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round round;

    public Hole() {}

    public Hole(int par, int shots, int hole_number) {
        this.par = par;
        this.shots = shots;
        this.hole_number = hole_number;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public void setHole_number(int hole_number) {
        this.hole_number = hole_number;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Long getId() { return this.hole_id; }

    public void setId(Long id) {
        this.hole_id = id;
    }

    public int getPar() { return this.par; }

    public int getShots() { return this.shots; }


    public int getHole_number() { return this.hole_number; }


}
