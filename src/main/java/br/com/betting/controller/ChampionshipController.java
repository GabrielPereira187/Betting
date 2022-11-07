package br.com.betting.controller;

import br.com.betting.entity.Championship;
import br.com.betting.entity.Team;
import br.com.betting.exceptions.ChampionshipNameEmptyException;
import br.com.betting.exceptions.ChampionshipSeasonEmptyException;
import br.com.betting.exceptions.EmptyListChampionshipException;
import br.com.betting.exceptions.EmptyListTeamException;
import br.com.betting.service.ChampionshipService;
import br.com.betting.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/championship")
@RequiredArgsConstructor
@RestController
public class ChampionshipController {

    private final ChampionshipService championshipService;

    private final TeamService teamService;


    @GetMapping("/{id}")
    public Championship getChampionshipById(@PathVariable int id){
        return championshipService.getChampionshipById(id);
    }

    @PostMapping("/newChamp")
    public Championship addChamp(@RequestBody Championship championship, Team team) throws ChampionshipNameEmptyException, ChampionshipSeasonEmptyException {
        return championshipService.newChamp(championship);
    }

    @PutMapping("/{championship_id}/champTeam/{team_id}")
    Championship assignTeamToChampionship(@PathVariable int championship_id,@PathVariable int team_id) throws ChampionshipNameEmptyException, ChampionshipSeasonEmptyException {
        Championship c = championshipService.getChampionshipById(championship_id);
        Team t = teamService.getTeamById(team_id);
        c.addTeam(t);
        return championshipService.newChamp(c);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChamp(@PathVariable int id){
        championshipService.deleteChamp(id);
    }

    @PutMapping("/update/{id}")
    public Championship replaceChampionship(@RequestBody Championship championship, @PathVariable int id){
        return championshipService.replaceChampionship(championship,id);
    }

    @GetMapping("/championships")
    public List<Championship> getAllChampionships() throws EmptyListChampionshipException {
        return championshipService.getAllChampionships();
    }

    @DeleteMapping("/deleteChampionshipTeam/{team_id}/{championship_id}")
    public void deleteTeamC(@PathVariable Integer team_id, @PathVariable Integer championship_id) throws ChampionshipSeasonEmptyException, ChampionshipNameEmptyException {
        Championship c = championshipService.getChampionshipById(championship_id);
        Team t = teamService.getTeamById(team_id);
        c.removeTeam(t);
        championshipService.newChamp(c);
    }




}
