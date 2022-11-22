package br.com.betting.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
public class Match implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int match_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "home_team")
    private Team home_team;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "away_team")
    private Team away_team;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "championship")
    private Championship championship;


    @NotBlank
    private String match_date;


    @Embedded
    private Corner corner;


    @Embedded
    private Card card;


    @Embedded
    private Goal goal;


}
