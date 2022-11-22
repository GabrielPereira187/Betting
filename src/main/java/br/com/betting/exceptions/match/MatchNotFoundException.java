package br.com.betting.exceptions.match;

public class MatchNotFoundException extends Exception {
    public MatchNotFoundException(int id){
        super("Partida de id " + id +" nao encontrada");
    }
}
