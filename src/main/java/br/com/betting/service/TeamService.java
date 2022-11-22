package br.com.betting.service;


import br.com.betting.entity.Team;
import br.com.betting.exceptions.team.TeamNameNotUnique;
import br.com.betting.exceptions.team.TeamNotFoundException;
import br.com.betting.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    public Team getTeamById(int id){
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    public Team newTeam(Team team) {
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

    public Page<Team> getAllTeams(Pageable pageable)  {
        return teamRepository.findAll(pageable);
    }

    public boolean findByTeamName(String name) throws TeamNameNotUnique {
        boolean exists = teamRepository.findByTeam_name(name);
        if(exists)
            throw new TeamNameNotUnique(name);
        return false;
    }
}
