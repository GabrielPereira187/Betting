package br.com.betting.exceptions.team;

public class EmptyListTeamException extends Throwable {

    public EmptyListTeamException(){
        super("Nenhum time cadastrado");
    }
}
