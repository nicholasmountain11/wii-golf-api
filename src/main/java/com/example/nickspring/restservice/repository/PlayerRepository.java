package com.example.nickspring.restservice.repository;

import com.example.nickspring.restservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
