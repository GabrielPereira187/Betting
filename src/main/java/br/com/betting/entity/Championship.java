package br.com.betting.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Championship implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int championship_id;

    private String championship_name;

    private String championship_season;
    @ManyToMany()
    @JoinTable( name = "team_championship",
            joinColumns = @JoinColumn(name = "championship_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    List<Team> championshipTeams = new ArrayList<>();

    public void addTeam(Team team){
        championshipTeams.add(team);
    }

}
