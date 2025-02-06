package com.accepted.controller;

import java.util.List;

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

import com.accepted.entities.MatchOdds;
import com.accepted.repositories.MatchOddsRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apiodds")
public class MatchOddsController {

    @Autowired
    private MatchOddsRepository matchOddsRepository;

    @PostMapping
    public ResponseEntity<MatchOdds> createMatchOdds(@Valid @RequestBody MatchOdds matchOdds) {
        return new ResponseEntity<>(matchOddsRepository.save(matchOdds), HttpStatus.CREATED);
    }

    @GetMapping("/matchesodds")
    public List<MatchOdds> getAllMatchOdds() {
        return matchOddsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchOdds> getMatchOddsById(@PathVariable Long id) {
        return matchOddsRepository.findById(id)
                .map(matchOdds -> new ResponseEntity<>(matchOdds, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public MatchOdds updateMatchOdds(@PathVariable Long id, @RequestBody MatchOdds matchOdds) {
        matchOdds.setId(id);
        return matchOddsRepository.save(matchOdds);
    }

    @DeleteMapping("/{id}")
    public void deleteMatchOdds(@PathVariable Long id) {
        matchOddsRepository.deleteById(id);
    }
}
