package org.example;

public class Main {
    static Data data = new Data();
    static Solver solver = new Solver(data);
    static Interpolat interpolat = new Interpolat(data);
    public static void main(String[] args) throws PressureException{
        System.out.println("Hello world!");
        System.out.println("Оптимальное альфа = " + interpolat.interpolatorAlpha());
        System.out.println("Удельный импульс = " + interpolat.interpolatorI());
        System.out.println();
        System.out.println("Номинальный расход = " + solver.optConsumption(interpolat.interpolatorI()));
        System.out.println("Диаметр критического сечения = " + solver.diamKp(solver.optConsumption(interpolat.interpolatorI()), interpolat.interpolatorAlpha()));
        System.out.println("Диаметр выходного сечения = " + solver.diamA(solver.optConsumption(interpolat.interpolatorI()), interpolat.interpolatorI()));
    }
}