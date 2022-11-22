package br.com.betting.exceptions.championship;

public class ChampionshipNotFoundException extends RuntimeException {
    public ChampionshipNotFoundException(int id){
        super("Competicao de id " + id + " nao encontrado");
    }
}
