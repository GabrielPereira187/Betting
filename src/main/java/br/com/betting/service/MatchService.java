package br.com.betting.service;


import br.com.betting.entity.Match;
import br.com.betting.repositories.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    public Match addMatch(Match match){
        match.getCorner().setTotal_first_half_corners(match.getCorner().getFirst_half_corners_home_team() + match.getCorner().getFirst_half_corners_away_team());
        match.getCorner().setTotal_second_half_corners(match.getCorner().getSecond_half_corners_away_team() + match.getCorner().getSecond_half_corners_home_team());
        match.getCorner().setTotal_game_corners(match.getCorner().getTotal_first_half_corners() + match.getCorner().getTotal_second_half_corners());
        match.getCard().setTotal_first_half_cards(match.getCard().getFirst_half_cards_home_team() + match.getCard().getFirst_half_cards_away_team());
        match.getCard().setTotal_second_half_cards(match.getCard().getSecond_half_cards_away_team() + match.getCard().getSecond_half_cards_home_team());
        match.getCard().setTotal_game_cards(match.getCard().getTotal_second_half_cards() + match.getCard().getTotal_first_half_cards());
        match.getGoal().setTotal_first_half_game_goals(match.getGoal().getFirst_half_goals_away_team() + match.getGoal().getFirst_half_goals_home_team());
        match.getGoal().setTotal_second_half_game_goals(match.getGoal().getSecond_half_goals_away_team() + match.getGoal().getSecond_half_goals_home_team());
        match.getGoal().setTotal_game_goals(match.getGoal().getTotal_first_half_game_goals() + match.getGoal().getTotal_second_half_game_goals());
        return matchRepository.save(match);
    }
    public Optional<Match> getMatch(int id) {
        return matchRepository.findById(id);
    }
    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public String deleteMatch(int id) {
        matchRepository.deleteById(id);
        return "Deletado com sucesso";
    }
}
