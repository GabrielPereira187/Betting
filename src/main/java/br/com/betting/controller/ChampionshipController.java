package br.com.betting.controller;

import br.com.betting.entity.Championship;
import br.com.betting.entity.Team;
import br.com.betting.exceptions.championship.EmptyListChampionshipException;
import br.com.betting.service.ChampionshipService;
import br.com.betting.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Championship addChamp(@RequestBody @Valid Championship championship) {
        return championshipService.newChamp(championship);
    }

    @PutMapping("/{championship_id}/champTeam/{team_id}")
    Championship assignTeamToChampionship(@PathVariable int championship_id,@PathVariable int team_id)  {
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
    public Championship replaceChampionship(@RequestBody @Valid Championship championship, @PathVariable int id){
        return championshipService.replaceChampionship(championship,id);
    }

    @GetMapping(value = "/championships",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Championship> getAllChampionships() throws EmptyListChampionshipException {
        return championshipService.getAllChampionships();
    }

    @DeleteMapping("/deleteChampionshipTeam/{team_id}/{championship_id}")
    public void deleteTeamChamp(@PathVariable Integer team_id, @PathVariable Integer championship_id)  {
        Championship c = championshipService.getChampionshipById(championship_id);
        Team t = teamService.getTeamById(team_id);
        c.removeTeam(t);
        championshipService.newChamp(c);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
