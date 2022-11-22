package br.com.betting.service;


import br.com.betting.entity.Championship;
import br.com.betting.entity.Match;
import br.com.betting.entity.Team;
import br.com.betting.exceptions.match.MatchNotFoundException;
import br.com.betting.exceptions.match.SameTeamsException;
import br.com.betting.repositories.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    private final TeamService teamService;

    private final ChampionshipService championshipService;

    public Match addMatch(Match match) throws SameTeamsException {
        if(match.getAway_team().getTeam_id() == match.getHome_team().getTeam_id())
            throw new SameTeamsException();

        Team home = teamService.getTeamById(match.getHome_team().getTeam_id());
        Team away = teamService.getTeamById(match.getAway_team().getTeam_id());
        Championship championship = championshipService.getChampionshipById(match.getChampionship().getChampionship_id());

        match.setHome_team(home);
        match.setAway_team(away);
        match.setChampionship(championship);



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
    public Match getMatch(int id) throws MatchNotFoundException {
        return matchRepository.findById(id).orElseThrow(() -> new MatchNotFoundException(id));
    }
    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public ResponseEntity<String> deleteMatch(int id) {
        matchRepository.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso o ID: " + id);
    }

    public Match replaceMatch(Match match, int id){
        return matchRepository.findById(id)
                .map(new_match -> {
                    new_match.setMatch_date(match.getMatch_date());
                    new_match.setHome_team(match.getHome_team());
                    new_match.setAway_team(match.getAway_team());
                    new_match.setChampionship(match.getChampionship());
                    new_match.getCorner().setFirst_half_corners_home_team(match.getCorner().getFirst_half_corners_home_team());
                    new_match.getCorner().setFirst_half_corners_away_team(match.getCorner().getFirst_half_corners_away_team());
                    new_match.getCorner().setSecond_half_corners_home_team(match.getCorner().getSecond_half_corners_home_team());
                    new_match.getCorner().setSecond_half_corners_away_team(match.getCorner().getSecond_half_corners_away_team());
                    new_match.getCorner().setTotal_first_half_corners(match.getCorner().getFirst_half_corners_away_team() + match.getCorner().getFirst_half_corners_home_team());
                    new_match.getCorner().setTotal_second_half_corners(match.getCorner().getSecond_half_corners_away_team() + match.getCorner().getSecond_half_corners_home_team());
                    new_match.getCorner().setTotal_game_corners(new_match.getCorner().getTotal_first_half_corners() + new_match.getCorner().getTotal_second_half_corners());
                    new_match.getCard().setFirst_half_cards_home_team(match.getCard().getFirst_half_cards_home_team());
                    new_match.getCard().setFirst_half_cards_away_team(match.getCard().getFirst_half_cards_away_team());
                    new_match.getCard().setSecond_half_cards_away_team(match.getCard().getSecond_half_cards_away_team());
                    new_match.getCard().setSecond_half_cards_home_team(match.getCard().getSecond_half_cards_home_team());
                    new_match.getCard().setTotal_first_half_cards(match.getCard().getFirst_half_cards_home_team() + match.getCard().getFirst_half_cards_away_team());
                    new_match.getCard().setTotal_second_half_cards(match.getCard().getSecond_half_cards_away_team() + match.getCard().getSecond_half_cards_home_team());
                    new_match.getCard().setTotal_game_cards(new_match.getCard().getTotal_second_half_cards() + new_match.getCard().getTotal_first_half_cards());
                    new_match.getGoal().setFirst_half_goals_away_team(match.getGoal().getFirst_half_goals_away_team());
                    new_match.getGoal().setFirst_half_goals_home_team(match.getGoal().getFirst_half_goals_home_team());
                    new_match.getGoal().setSecond_half_goals_away_team(match.getGoal().getSecond_half_goals_away_team());
                    new_match.getGoal().setSecond_half_goals_home_team(match.getGoal().getSecond_half_goals_home_team());
                    new_match.getGoal().setTotal_first_half_game_goals(match.getGoal().getFirst_half_goals_home_team() + match.getGoal().getFirst_half_goals_away_team());
                    new_match.getGoal().setTotal_second_half_game_goals(match.getGoal().getSecond_half_goals_home_team() + match.getGoal().getSecond_half_goals_away_team());
                    new_match.getGoal().setTotal_game_goals(new_match.getGoal().getTotal_first_half_game_goals() + new_match.getGoal().getTotal_second_half_game_goals());
                    return matchRepository.save(new_match);
                }).orElseGet(() ->{
                    match.setMatch_id(id);
                    match.getGoal().setTotal_first_half_game_goals(match.getGoal().getFirst_half_goals_home_team() + match.getGoal().getFirst_half_goals_away_team());
                    match.getGoal().setTotal_second_half_game_goals(match.getGoal().getSecond_half_goals_home_team() + match.getGoal().getSecond_half_goals_away_team());
                    match.getGoal().setTotal_game_goals(match.getGoal().getTotal_first_half_game_goals() + match.getGoal().getTotal_second_half_game_goals());
                    match.getCard().setTotal_first_half_cards(match.getCard().getFirst_half_cards_home_team() + match.getCard().getFirst_half_cards_away_team());
                    match.getCard().setTotal_second_half_cards(match.getCard().getSecond_half_cards_away_team() + match.getCard().getSecond_half_cards_home_team());
                    match.getCard().setTotal_game_cards(match.getCard().getTotal_second_half_cards() + match.getCard().getTotal_first_half_cards());
                    match.getCorner().setTotal_first_half_corners(match.getCorner().getFirst_half_corners_away_team() + match.getCorner().getFirst_half_corners_home_team());
                    match.getCorner().setTotal_second_half_corners(match.getCorner().getSecond_half_corners_away_team() + match.getCorner().getSecond_half_corners_home_team());
                    match.getCorner().setTotal_game_corners(match.getCorner().getTotal_first_half_corners() + match.getCorner().getTotal_second_half_corners());
                    return matchRepository.save(match);
                });
    }

    public List<Match> getMatchesAwayTeam(int id,int num_matches) {
        return matchRepository.getMatchesAwayTeam(id,num_matches);
    }

    public List<Match> getMatchesHomeTeam(int id,int num_matches) {
        return matchRepository.getMatchesHomeTeam(id,num_matches);
    }
}
