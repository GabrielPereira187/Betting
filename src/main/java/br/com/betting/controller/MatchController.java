package br.com.betting.controller;


import br.com.betting.entity.Corner;
import br.com.betting.entity.Match;
import br.com.betting.repositories.MatchRepository;
import br.com.betting.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/match")
public class MatchController {
    private final MatchService matchService;

    @PostMapping("/addMatch")
    public Match addMatch(@RequestBody Match match){
        return matchService.addMatch(match);
    }

    @GetMapping("/getMatch/{id}")
    public Optional<Match> getMatch(@PathVariable int id){
        return matchService.getMatch(id);
    }

    @GetMapping("/matches")
    public List<Match> getMatches(){
        return matchService.getMatches();
    }

    @DeleteMapping("/delete/{id}")
    public String getMatches(@PathVariable int id){
        return matchService.deleteMatch(id);
    }

}
