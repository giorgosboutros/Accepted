package com.accepted.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accepted.entities.MatchOdds;
@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long>{
    List<MatchOdds> findByMatchId(Long matchId);
}
