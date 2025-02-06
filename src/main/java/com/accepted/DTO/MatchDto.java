package com.accepted.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MatchDto {

    private String description;
    private LocalDate matchDate;
    private LocalTime matchTime;
    private String teamA;
    private String teamB;
    private String sport;
    private List<MatchOddsDto> matchOdds;

    // Default constructor
    public MatchDto() {
    }

    // Constructor with all fields
    public MatchDto(String description, LocalDate matchDate, LocalTime matchTime, String teamA, String teamB, String sport, List<MatchOddsDto> matchOdds) {
        this.description = description;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
        this.matchOdds = matchOdds;
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalTime matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public List<MatchOddsDto> getMatchOdds() {
        return matchOdds;
    }

    public void setMatchOdds(List<MatchOddsDto> matchOdds) {
        this.matchOdds = matchOdds;
    }
}

