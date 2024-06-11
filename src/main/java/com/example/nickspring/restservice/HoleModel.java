package com.example.nickspring.restservice;

public class HoleModel {

    private Long hole_id;
    private int par;
    private int shots;
    private int holeNumber;
    private Long round_id;

    public HoleModel(Long hole_id, int par, int shots, int holeNumber, Long round_id) {
        this.hole_id = hole_id;
        this.par = par;
        this.shots = shots;
        this.holeNumber = holeNumber;
        this.round_id = round_id;
    }

    public Long getId() { return this.hole_id; }

    public int getPar() { return this.par; }

    public int getShots() { return this.shots; }

    public int getHole_number() { return this.holeNumber; }

    public Long getRound_id() { return this.round_id; }
}
