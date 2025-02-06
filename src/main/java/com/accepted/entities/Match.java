package com.accepted.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="match")
public class Match {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message= "Description cannot be empty.")
    private String description;

    @NotNull(message= "Match date cannot be empty")
    @Column(name= "match_date")
    private LocalDate matchDate;

    @Column(name="match_time")
    private LocalTime matchTime;

    @NotNull(message= "team a cannot be null")
    @Column(name= "team_a", nullable=false)
    private String teamA;

    @NotBlank(message= "Team b cannot be empty")
    @Column(name= "team_b")
    private String teamB;

    @NotNull(message= "Sport type cannot be Null")
    @Enumerated(EnumType.STRING)
    private Sport sport;

    public enum Sport {
        Football(1),
        Basketball(2);

        private final int value;

        Sport(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Sport fromValue(int value) {
            for (Sport sport : values()) {
                if (sport.value == value) {
                    return sport;
                }
            }
            throw new IllegalArgumentException("Invalid sport value: " + value);
        }
    }

    @OneToMany(mappedBy="match", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonManagedReference
    private List<MatchOdds> matchOdds;

    public Match() {}

    public Match(String description, LocalDate matchDate, LocalTime matchTime, String teamA, String teamB, Sport sport){
        this.description = description;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }


    public List<MatchOdds> getMatchOdds() {
        return matchOdds;
    }

    public void setMatchOdds(List<MatchOdds> matchOdds) {
        this.matchOdds = matchOdds;
    }
    
}
