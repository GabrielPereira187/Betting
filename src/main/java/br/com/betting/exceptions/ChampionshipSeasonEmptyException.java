package br.com.betting.exceptions;

public class ChampionshipSeasonEmptyException extends Exception{
    public ChampionshipSeasonEmptyException(){
            super("Temporada da competicao nao pode ser vazio");
    }
}
