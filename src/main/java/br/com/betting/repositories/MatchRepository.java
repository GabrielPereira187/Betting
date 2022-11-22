package br.com.betting.repositories;

import br.com.betting.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM GAME WHERE AWAY_TEAM_ID = ?1 LIMIT ?2")
    List<Match> getMatchesAwayTeam(int id,int num_matches);

    @Query(nativeQuery = true, value = "SELECT * FROM GAME WHERE HOME_TEAM_ID = ?1 LIMIT ?2")
    List<Match> getMatchesHomeTeam(int id,int num_matches);

}
