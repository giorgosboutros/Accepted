package com.accepted.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accepted.entities.Match;
@Repository
public interface MatchRepository extends JpaRepository<Match, Long>{
    
    
}