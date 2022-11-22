package br.com.betting.controller;


import br.com.betting.entity.Team;
import br.com.betting.exceptions.team.TeamNameNotUnique;
import br.com.betting.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public Page<Team> getAllTeams(Pageable pageable) {
        return teamService.getAllTeams(pageable);
    }

    @PostMapping("/newTeam")
    public Team addTeam(@RequestBody @Valid Team team) throws TeamNameNotUnique {
        findByTeamName(team.getTeam_name());
        return teamService.newTeam(team);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChamp(@PathVariable int id){
        teamService.deleteTeam(id);
    }

    @PutMapping("/update/{id}")
    public Team replaceTeam(@RequestBody @Valid Team team, @PathVariable int id){
        return teamService.replaceTeam(team,id);
    }

    @GetMapping(value = "/findByTeamName")
    public boolean findByTeamName(@RequestParam String name) throws TeamNameNotUnique {
        return teamService.findByTeamName(name);
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
