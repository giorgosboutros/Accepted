package com.accepted.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="match_odds")
public class MatchOdds {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "match_id", referencedColumnName= "id")
    @JsonBackReference
    private Match match;

    @NotBlank(message= "specifier cannot be empty")
    private String specifier;
    @Min(value= 1, message= "value must greater than 1")
    private double odd;


    public MatchOdds() {}

    public MatchOdds(Match match, String specifier, Double odd){
        this.match = match;
        this.specifier = specifier;
        this.odd = odd;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Match getMatch(){
        return match;
    }

    public void setMatch(Match match){
        this.match = match;
    }

    public String getSpecifier(){
        return specifier;
    }

    public void setSpecifier(String specifier){
        this.specifier = specifier;
    }

    public double getOdd(){
        return odd;
    }

    public void setOdd(double odd){
        this.odd = odd;
    }
}
