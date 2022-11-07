package br.com.betting.service;


import br.com.betting.entity.Championship;
import br.com.betting.entity.Team;
import br.com.betting.exceptions.EmptyListTeamException;
import br.com.betting.exceptions.TeamNameEmptyException;
import br.com.betting.exceptions.TeamNotFoundException;
import br.com.betting.repositories.ChampionshipRepository;
import br.com.betting.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    public Team getTeamById(int id){
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    public Team newTeam(Team team) throws TeamNameEmptyException {
        if(team.getTeam_name() == null || team.getTeam_name().equalsIgnoreCase(""))
            throw new TeamNameEmptyException();
        return teamRepository.save(team);
    }

    public void deleteTeam(int id){
        teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
        teamRepository.deleteById(id);
    }


    public Team replaceTeam(Team team, int id) {
        return teamRepository.findById(id)
                .map(team1 -> {
                    team1.setTeam_name(team.getTeam_name());
                    return teamRepository.save(team1);
                }).orElseGet(() ->{
                    team.setTeam_id(id);
                    return teamRepository.save(team);
                });
    }

    public List<Team> getAllTeams() throws EmptyListTeamException {
        if (teamRepository.findAll().isEmpty())
            throw new EmptyListTeamException();
        return teamRepository.findAll();
    }
}
