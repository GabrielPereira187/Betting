package br.com.betting.controller.advices;


import br.com.betting.exceptions.championship.ChampionshipNotFoundException;
import br.com.betting.exceptions.match.MatchNotFoundException;
import br.com.betting.exceptions.match.SameTeamsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MatchAdviceController {
    @ResponseBody
    @ExceptionHandler(SameTeamsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String sameTeamsExceptionHandler(SameTeamsException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(MatchNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String matchNotFoundExceptionHandler(MatchNotFoundException ex){
        return ex.getMessage();
    }
}
