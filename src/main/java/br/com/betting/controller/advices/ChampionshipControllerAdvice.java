package br.com.betting.controller.advices;


import br.com.betting.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ChampionshipControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ChampionshipNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String championshipNotFoundHandler(ChampionshipNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ChampionshipNameEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String championshipEmptyNameHandler(ChampionshipNameEmptyException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ChampionshipSeasonEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String championshipEmptySeasonHandler(ChampionshipSeasonEmptyException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(EmptyListChampionshipException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String championshipEmptyListHandler(EmptyListChampionshipException ex){
        return ex.getMessage();
    }
}
