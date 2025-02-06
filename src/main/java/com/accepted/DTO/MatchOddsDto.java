package com.accepted.DTO;

public class MatchOddsDto {

    private String specifier;
    private double odd;

    // Default constructor
    public MatchOddsDto() {
    }

    // Constructor with parameters
    public MatchOddsDto(String specifier, double odd) {
        this.specifier = specifier;
        this.odd = odd;
    }

    // Getters and setters
    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public double getOdd() {
        return odd;
    }

    public void setOdd(double odd) {
        this.odd = odd;
    }
}