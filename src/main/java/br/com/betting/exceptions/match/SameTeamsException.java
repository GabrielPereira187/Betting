package br.com.betting.exceptions.match;

public class SameTeamsException extends Exception{
    public SameTeamsException(){
        super("O time visitante e mandante nao pode ser o mesmo");
    }
}
