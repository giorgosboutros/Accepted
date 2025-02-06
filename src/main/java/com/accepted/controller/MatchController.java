package com.accepted.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accepted.DTO.MatchDto;
import com.accepted.entities.Match;
import com.accepted.entities.MatchOdds;
import com.accepted.repositories.MatchOddsRepository;
import com.accepted.repositories.MatchRepository;
import com.accepted.services.MatchService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class MatchController {

    @Autowired
    private MatchOddsRepository matchOddsRepository;
    
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchService matchService;
    
    @GetMapping("/matches")
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Match> GetMatchById(@PathVariable Long id) {
        return matchRepository.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMatch(@Valid @RequestBody MatchDto matchDto) {
        try {
            Match match = matchService.createMatch(matchDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(match);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating match");
        }
    }

    @PutMapping("/update/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match match) {
        match.setId(id);
        return matchRepository.save(match);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMatch(@PathVariable Long id){
        matchRepository.deleteById(id);
    }

    @GetMapping("/{matchId}/odds")
    public List<MatchOdds> getOddsByMatchId(@PathVariable Long matchId) {
        return matchOddsRepository.findByMatchId(matchId);
    }
}
