package br.com.betting.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Championship implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int championship_id;

    @NotBlank(message = "Nome do campeonato nao pode ser vazio")
    private String championship_name;
    @NotBlank(message = "Temporada do campeonato nao pode ser vazia")
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

    public void removeTeam(Team team){
        championshipTeams.remove(team);
    }

}
