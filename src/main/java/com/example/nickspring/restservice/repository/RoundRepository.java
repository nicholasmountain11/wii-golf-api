package com.example.nickspring.restservice.repository;

import com.example.nickspring.restservice.entity.Player;
import com.example.nickspring.restservice.entity.Round;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Long> {
    List<Round> findByPlayer(Player player);

    @Query("SELECT r FROM Round r JOIN r.holes h GROUP BY r.round_id ORDER BY SUM(h.shots - h.par) ASC")
    List<Round> findRoundsWithLowestScores(Pageable pageable);

    @Query("SELECT r.player FROM Round r WHERE r.id = :roundId")
    Player findPlayerByRoundId(Long roundId);
}
