package br.com.betting.exceptions.championship;

public class ChampionshipNameEmptyException extends Exception {
    public ChampionshipNameEmptyException(){
        super("Nome da competicao nao pode ser vazio");
    }
}
