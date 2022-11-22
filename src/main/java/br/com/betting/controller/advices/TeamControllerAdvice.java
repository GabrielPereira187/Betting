package br.com.betting.controller.advices;


import br.com.betting.exceptions.team.EmptyListTeamException;
import br.com.betting.exceptions.team.TeamNameEmptyException;
import br.com.betting.exceptions.team.TeamNameNotUnique;
import br.com.betting.exceptions.team.TeamNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TeamControllerAdvice {
    @ResponseBody
    @ExceptionHandler(TeamNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String teamNotFoundHandler(TeamNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TeamNameEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String teamEmptyNameHandler(TeamNameEmptyException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(EmptyListTeamException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String teamEmptyListHandler(EmptyListTeamException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TeamNameNotUnique.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String teamNameNotUniqueHandler(TeamNameNotUnique ex){
        return ex.getMessage();
    }


}
