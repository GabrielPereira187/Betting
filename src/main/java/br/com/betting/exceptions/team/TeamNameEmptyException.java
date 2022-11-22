package br.com.betting.exceptions.team;

public class TeamNameEmptyException extends Exception {
    public TeamNameEmptyException(){
        super("O nome da equipe nao pode ser vazio");
    }
}
