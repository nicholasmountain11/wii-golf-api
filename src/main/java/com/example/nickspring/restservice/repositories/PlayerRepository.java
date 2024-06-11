package com.example.nickspring.restservice.repositories;

import com.example.nickspring.restservice.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
