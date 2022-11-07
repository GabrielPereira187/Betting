package br.com.betting.exceptions;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(int id){
        super("Time de id " + id + " nao encontrado");
    }
}
