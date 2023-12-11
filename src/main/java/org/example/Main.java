package org.example;

public class Main {
    static Data data = new Data();
    static Interpolat interpolat = new Interpolat(data);

    public static void main(String[] args) throws PressureException{
        System.out.println("Hello world!");
        for (int i =0; i<5; i++){
            //solver.impulse(i);
        }
        //System.out.println(data.getParamsI()[0][0]);
        System.out.println("Оптимальное альфа = " + interpolat.interpolatorAlpha());
        System.out.println("Удельный импульс = " + interpolat.interpolatorI());
    }
}