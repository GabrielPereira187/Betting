package br.com.betting.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int match_id;
    private int home_team_id;
    private int away_team_id;
    private int championship_id;
    private Date match_date;
    @Embedded
    private Corner corner;
    @Embedded
    private Card card;
    @Embedded
    private Goal goal;
}
