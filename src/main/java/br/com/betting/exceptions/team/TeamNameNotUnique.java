package br.com.betting.exceptions.team;

public class TeamNameNotUnique extends Exception{
    public TeamNameNotUnique(String name){
        super("Time de nome " + name + " nao pode ser repetido");
    }
}
