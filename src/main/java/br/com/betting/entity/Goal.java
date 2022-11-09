package br.com.betting.entity;


import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Goal {
    private int first_half_goals_home_team;
    private int second_half_goals_away_team;
    private int second_half_goals_home_team;
    private int first_half_goals_away_team;
    private int total_first_half_game_goals;
    private int total_second_half_game_goals;
    private int total_game_goals;
}
