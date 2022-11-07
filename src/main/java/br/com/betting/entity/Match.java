package br.com.betting.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(MatchId.class)
@Data
@NoArgsConstructor
public class Match implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long match_id;
    @Id
    private int home_team_id;
    private String home_team_name;
    @Id
    private int away_team_id;
    private String away_team_name;
    @Id
    private int championship_id;
    @Id
    private Date match_date;
    private int first_half_corners_home_team;
    private int second_half_corners_away_team;
    private int second_half_corners_home_team;
    private int first_half_corners_away_team;
    private int first_half_cards_home_team;
    private int second_half_cards_away_team;
    private int second_half_cards_home_team;
    private int first_half_cards_away_team;
    private int total_game_corners;
    private int total_game_cards;
    private int total_game_goals;
    private int total_first_half_corners;
    private int total_second_half_corners;
    private int total_first_half_cards;
    private int total_second_half_cards;
    private int first_half_goals_home_team;
    private int second_half_goals_away_team;
    private int second_half_goals_home_team;
    private int first_half_goals_away_team;

    public Match(long match_id, int home_team_id, String home_team_name, int away_team_id, String away_team_name, int championship_id, Date match_date, int first_half_corners_home_team, int second_half_corners_away_team, int second_half_corners_home_team, int first_half_corners_away_team, int first_half_cards_home_team, int second_half_cards_away_team, int second_half_cards_home_team, int first_half_cards_away_team, int total_game_corners, int total_game_cards, int total_game_goals, int total_first_half_corners, int total_second_half_corners, int total_first_half_cards, int total_second_half_cards, int first_half_goals_home_team, int second_half_goals_away_team, int second_half_goals_home_team, int first_half_goals_away_team) {
        this.match_id = match_id;
        this.home_team_id = home_team_id;
        this.home_team_name = home_team_name;
        this.away_team_id = away_team_id;
        this.away_team_name = away_team_name;
        this.championship_id = championship_id;
        this.match_date = match_date;
        this.first_half_corners_home_team = first_half_corners_home_team;
        this.second_half_corners_away_team = second_half_corners_away_team;
        this.second_half_corners_home_team = second_half_corners_home_team;
        this.first_half_corners_away_team = first_half_corners_away_team;
        this.first_half_cards_home_team = first_half_cards_home_team;
        this.second_half_cards_away_team = second_half_cards_away_team;
        this.second_half_cards_home_team = second_half_cards_home_team;
        this.first_half_cards_away_team = first_half_cards_away_team;
        this.total_game_corners = first_half_corners_away_team + first_half_corners_home_team + second_half_corners_away_team + second_half_corners_home_team;
        this.total_game_cards = first_half_cards_away_team + first_half_cards_home_team + second_half_cards_away_team + second_half_cards_home_team;
        this.total_game_goals = first_half_goals_away_team + first_half_goals_home_team + second_half_goals_away_team + second_half_goals_home_team;
        this.total_first_half_corners = first_half_corners_away_team + first_half_corners_home_team;
        this.total_second_half_corners = second_half_corners_away_team + second_half_corners_home_team;
        this.total_first_half_cards = first_half_cards_away_team + first_half_cards_home_team;
        this.total_second_half_cards = second_half_cards_away_team + second_half_cards_home_team;
        this.first_half_goals_home_team = first_half_goals_home_team;
        this.second_half_goals_away_team = second_half_goals_away_team;
        this.second_half_goals_home_team = second_half_goals_home_team;
        this.first_half_goals_away_team = first_half_goals_away_team;
    }
}
