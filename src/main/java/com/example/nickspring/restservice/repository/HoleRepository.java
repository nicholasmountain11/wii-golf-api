package com.example.nickspring.restservice.repository;

import com.example.nickspring.restservice.entity.Hole;
import com.example.nickspring.restservice.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoleRepository extends JpaRepository<Hole, Long> {
    List<Hole> findByRound(Round round);
}
