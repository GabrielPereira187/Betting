package br.com.betting.repositories;

import br.com.betting.entity.Championship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship,Integer> {




}
