package br.com.betting.exceptions;

public class EmptyListTeamException extends Throwable {

    public EmptyListTeamException(){
        super("Nenhum time cadastrado");
    }
}
