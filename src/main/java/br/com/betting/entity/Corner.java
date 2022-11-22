package br.com.betting.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

@Embeddable
@Data
@NoArgsConstructor
public class Corner {
    @Min(value = 0)
    private int first_half_corners_home_team;
    @Min(value = 0)
    private int second_half_corners_away_team;
    @Min(value = 0)
    private int second_half_corners_home_team;
    @Min(value = 0)
    private int first_half_corners_away_team;
    @Min(value = 0)
    private int total_first_half_corners;
    @Min(value = 0)
    private int total_second_half_corners;
    @Min(value = 0)
    private int total_game_corners;
}
