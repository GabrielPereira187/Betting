package br.com.betting.exceptions;

public class EmptyListChampionshipException extends Throwable {

    public EmptyListChampionshipException(){
        super("Nenhum campeonato cadastrado");
    }
}
