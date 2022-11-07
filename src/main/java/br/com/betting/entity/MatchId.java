package br.com.betting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@Data
public class MatchId implements Serializable {

    private long match_id;
    private int home_team_id;
    private int away_team_id;
    private int championship_id;
    private Date match_date;

}
