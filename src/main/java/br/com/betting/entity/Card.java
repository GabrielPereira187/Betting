package br.com.betting.entity;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

@Embeddable
@Data
public class Card {
    @Min(value = 0)
    private int first_half_cards_home_team;
    @Min(value = 0)
    private int second_half_cards_away_team;
    @Min(value = 0)
    private int second_half_cards_home_team;
    @Min(value = 0)
    private int first_half_cards_away_team;
    @Min(value = 0)
    private int total_first_half_cards;
    @Min(value = 0)
    private int total_second_half_cards;
    @Min(value = 0)
    private int total_game_cards;
}
