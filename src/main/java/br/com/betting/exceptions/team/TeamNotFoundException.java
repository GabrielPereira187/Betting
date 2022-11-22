package br.com.betting.exceptions.team;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(int id){
        super("Time de id " + id + " nao encontrado");
    }
}
