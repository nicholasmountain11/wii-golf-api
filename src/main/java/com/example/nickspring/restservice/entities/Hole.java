package com.example.nickspring.restservice.entities;

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

    public Hole(int par, int shots, int hole_number, Round round) {
        this.par = par;
        this.shots = shots;
        this.hole_number = hole_number;
        this.round = round;
    }

    public Long getId() { return this.hole_id; }

    public void setId(Long id) {
        this.hole_id = id;
    }

    public int getPar() { return this.par; }

    public int getShots() { return this.shots; }

    public Round getRound() { return this.round; }

    public int getHole_number() { return this.hole_number; }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Hole))
            return false;
        Hole hole = (Hole) o;
        return Objects.equals(this.hole_id, hole.hole_id) && Objects.equals(this.par, hole.par)
                && Objects.equals(this.shots, hole.shots) && Objects.equals(this.hole_number, hole.hole_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hole_id, this.par, this.shots, this.hole_number);
    }

}
