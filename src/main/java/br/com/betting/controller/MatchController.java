package br.com.betting.controller;


import br.com.betting.entity.Match;
import br.com.betting.exceptions.match.MatchNotFoundException;
import br.com.betting.exceptions.match.SameTeamsException;
import br.com.betting.service.MatchService;
import br.com.betting.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/match")
public class MatchController {
    private final MatchService matchService;

    private final TeamService teamService;

    @PostMapping("/addMatch")
    public Match addMatch(@RequestBody @Valid Match match) throws SameTeamsException {
        return matchService.addMatch(match);
    }

    @GetMapping("/getMatch/{id}")
    public Match getMatch(@PathVariable int id) throws MatchNotFoundException {
        return matchService.getMatch(id);
    }

    @GetMapping("/matches")
    public List<Match> getMatches(){
        return matchService.getMatches();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable int id){
        return matchService.deleteMatch(id);
    }

    @PutMapping("/update/{id}")
    public Match updateMatch(@PathVariable int id,@RequestBody @Valid Match match){
        return matchService.replaceMatch(match,id);
    }

    @GetMapping("/get_away_team_data")
    public List<Match> get_away_team_data(@RequestParam int id,@RequestParam int num_matches ){
        return matchService.getMatchesAwayTeam(id,num_matches);
    }

    @GetMapping("/get_home_team_data")
    public List<Match> get_home_team_data(@RequestParam int id,@RequestParam int num_matches){
        return matchService.getMatchesHomeTeam(id,num_matches);
    }
}
