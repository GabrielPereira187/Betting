package br.com.betting.repositories;

import br.com.betting.entity.Team;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for team repository")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class TeamRepositoryTest {

    private final TeamRepository teamRepository;

    @Test
    @DisplayName("Save creates team when Successful")
    void save_PersistTeam_WhenSuccessful(){
        Team teamToBeSaved = createTeam();

        Team teamSaved = this.teamRepository.save(teamToBeSaved);

        Assertions.assertThat(teamSaved).isNotNull();

        Assertions.assertThat(teamSaved.getTeam_id()).isNotNull();

        Assertions.assertThat(teamSaved.getTeam_name()).isEqualTo(teamToBeSaved.getTeam_name());
    }

    @Test
    @DisplayName("Save updates team when Successful")
    void save_UpdatesTeam_WhenSuccessful(){
        Team teamToBeSaved = createTeam();

        Team teamSaved = this.teamRepository.save(teamToBeSaved);

        teamSaved.setTeam_name("Time Teste Update");

        Team teamToUpdate = this.teamRepository.save(teamSaved);

        Assertions.assertThat(teamToUpdate).isNotNull();

        Assertions.assertThat(teamToUpdate.getTeam_id()).isNotNull();

        Assertions.assertThat(teamToUpdate.getTeam_name()).isEqualTo(teamToBeSaved.getTeam_name());
    }

    @Test
    @DisplayName("Find by team name returns true when find another equal name when Successful")
    void findByName_ReturnsTrue_WhenSuccessful(){
        Team teamToBeSaved = createTeam();

        Team teamSaved = this.teamRepository.save(teamToBeSaved);

        teamSaved.setTeam_name("Time Teste 1");

        boolean teamNameExists = this.teamRepository.findByTeam_name(teamSaved.getTeam_name());

        Assertions.assertThat(teamNameExists).isNotNull();

        Assertions.assertThat(teamNameExists).isTrue();
    }

    @Test
    @DisplayName("Find by team name returns false when dont find another equal name when Successful")
    void findByName_ReturnsFalse_WhenSuccessful(){
        Team teamToBeSaved = createTeam();

        this.teamRepository.save(teamToBeSaved);

        boolean teamNameExists = this.teamRepository.findByTeam_name("Time Teste 2");

        Assertions.assertThat(teamNameExists).isNotNull();

        Assertions.assertThat(teamNameExists).isFalse();
    }

    @Test
    @DisplayName("Delete removes team when Successful")
    void delete_RemovesTeam_WhenSuccessful(){
        Team teamToBeSaved = createTeam();

        Team teamSaved = this.teamRepository.save(teamToBeSaved);

        this.teamRepository.delete(teamSaved);

        Optional<Team> teamOptional = this.teamRepository.findById(teamSaved.getTeam_id());

        Assertions.assertThat(teamOptional).isEmpty();
    }

    @Test
    @DisplayName("Get a list with all teams in db")
    void getTeamList_WhenSuccessful(){
        Team teamToBeSaved = createTeam();

        this.teamRepository.save(teamToBeSaved);

        Iterable<Team> teamList = this.teamRepository.findAll();

        Assertions.assertThat(teamList).isNotNull();

        Assertions.assertThat(teamList).isNotEmpty();
    }

    @Test
    @DisplayName("Get a empty list without teams in db")
    void getTeamListEmpty_WhenSuccessful(){

        Iterable<Team> teamList = this.teamRepository.findAll();

        Assertions.assertThat(teamList).isNotNull();

        Assertions.assertThat(teamList).isEmpty();
    }
    private Team createTeam(){
        return Team.builder()
                .team_name("Time Teste 1")
                .build();
    }

}