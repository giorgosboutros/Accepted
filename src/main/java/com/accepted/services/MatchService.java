package com.accepted.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accepted.DTO.MatchDto;
import com.accepted.DTO.MatchOddsDto;
import com.accepted.entities.Match;
import com.accepted.entities.MatchOdds;
import com.accepted.repositories.MatchOddsRepository;
import com.accepted.repositories.MatchRepository;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchOddsRepository matchOddsRepository;

    public Match createMatch(MatchDto matchDto) {
        try {
            Match match = new Match();
            match.setDescription(matchDto.getDescription());
            match.setMatchDate(matchDto.getMatchDate());
            match.setMatchTime(matchDto.getMatchTime());
            match.setTeamA(matchDto.getTeamA());
            match.setTeamB(matchDto.getTeamB());
            match.setSport(Match.Sport.valueOf(matchDto.getSport()));

            match = matchRepository.save(match);

            List<MatchOdds> savedMatchOdds = new ArrayList<>();


            if (matchDto.getMatchOdds() != null) {
                for (MatchOddsDto oddsDto : matchDto.getMatchOdds()) {
                    MatchOdds matchOdds = new MatchOdds();
                    matchOdds.setSpecifier(oddsDto.getSpecifier());
                    matchOdds.setOdd(oddsDto.getOdd());
                    matchOdds.setMatch(match);
                    matchOddsRepository.save(matchOdds);
                    savedMatchOdds.add(matchOdds);
                }
            }
            return match;

        } catch (Exception e) {
            throw new RuntimeException("Error creating match and odds", e);
        }
    }
}
    
