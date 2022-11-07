package br.com.betting.controller;


import br.com.betting.entity.Championship;
import br.com.betting.entity.Team;
import br.com.betting.exceptions.EmptyListTeamException;
import br.com.betting.exceptions.TeamNameEmptyException;
import br.com.betting.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;


    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable int id){
        return teamService.getTeamById(id);
    }

    @GetMapping("/teams")
    public List<Team> getAllTeams() throws EmptyListTeamException {
        return teamService.getAllTeams();
    }

    @PostMapping("/newTeam")
    public Team addTeam(@RequestBody Team team) throws TeamNameEmptyException {
        return teamService.newTeam(team);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChamp(@PathVariable int id){
        teamService.deleteTeam(id);
    }

    @PutMapping("/update/{id}")
    public Team replaceTeam(@RequestBody Team team, @PathVariable int id){
        return teamService.replaceTeam(team,id);
    }








}
