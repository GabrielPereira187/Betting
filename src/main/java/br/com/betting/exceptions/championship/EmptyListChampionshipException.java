package br.com.betting.exceptions.championship;

public class EmptyListChampionshipException extends Throwable {

    public EmptyListChampionshipException(){
        super("Nenhum campeonato cadastrado");
    }
}
