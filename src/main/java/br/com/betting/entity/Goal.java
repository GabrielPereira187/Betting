package br.com.betting.entity;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

@Embeddable
@Data
public class Goal {
    @Min(value = 0)
    private Integer first_half_goals_home_team;
    @Min(value = 0)
    private Integer second_half_goals_away_team;
    @Min(value = 0)
    private Integer second_half_goals_home_team;
    @Min(value = 0)
    private Integer first_half_goals_away_team;
    @Min(value = 0)
    private Integer total_first_half_game_goals;
    @Min(value = 0)
    private Integer total_second_half_game_goals;
    @Min(value = 0)
    private Integer total_game_goals;
}
