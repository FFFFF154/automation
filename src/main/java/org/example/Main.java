package org.example;

public class Main {
    public static void main(String[] args) throws PressureException{
        System.out.println("Hello world!");
        Solver solver = new Solver();
        solver.impulse();
    }
}