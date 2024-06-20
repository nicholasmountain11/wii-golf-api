package com.example.nickspring.restservice.repository;

import com.example.nickspring.restservice.entity.Player;
import com.example.nickspring.restservice.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Long> {
    List<Round> findByPlayer(Player player);
}
