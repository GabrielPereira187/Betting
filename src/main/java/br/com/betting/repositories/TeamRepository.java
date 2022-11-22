package br.com.betting.repositories;

import br.com.betting.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends PagingAndSortingRepository<Team,Integer> {

    @Query(nativeQuery = true, value = "SELECT CASE WHEN COUNT(*) = 1 THEN 'TRUE' ELSE 'FALSE' END from TEAM where TEAM_NAME = ?1")
    boolean findByTeam_name(String name);


}
