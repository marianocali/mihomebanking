package com.mybank.domain;

public class SobregiroException extends Exception
{
    private double deficit;

    public SobregiroException(String msg, double deficit)
    {
       super(msg);
       this.deficit = deficit;
    }

    public double getDeficit()
    {
        return deficit;
    }
}
