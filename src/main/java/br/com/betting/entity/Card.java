package br.com.betting.entity;


import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Card {
    private int first_half_cards_home_team;
    private int second_half_cards_away_team;
    private int second_half_cards_home_team;
    private int first_half_cards_away_team;
    private int total_first_half_cards;
    private int total_second_half_cards;
    private int total_game_cards;
}
