package br.com.betting.controller.advices;


import br.com.betting.exceptions.EmptyListTeamException;
import br.com.betting.exceptions.TeamNameEmptyException;
import br.com.betting.exceptions.TeamNotFoundException;
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
}
