package br.com.betting.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
public class Corner {
    private int first_half_corners_home_team;
    private int second_half_corners_away_team;
    private int second_half_corners_home_team;
    private int first_half_corners_away_team;
    private int total_first_half_corners;
    private int total_second_half_corners;
    private int total_game_corners;



}
