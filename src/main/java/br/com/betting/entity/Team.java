package br.com.betting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;

    @NotBlank(message = "Nome do time nao pode ser vazio")
    @Column(unique = true)
    private String team_name;

    @JsonIgnore
    @ManyToMany(mappedBy = "championshipTeams")
    private List<Championship> championship = new ArrayList<>();
}
