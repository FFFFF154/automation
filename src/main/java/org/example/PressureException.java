package org.example;

public class PressureException extends Exception{ // Исключение для неправильного ввода давления

    public PressureException(String message){
        super(message);
    }
}
