package org.example;

public class Main {
    public static void main(String[] args) throws PressureException{
        System.out.println("Hello world!");
        Solver solver = new Solver();
        double[] imp = solver.impulse();
        double max = imp[0];
        int count =0;
        for (int i =0; i<31; i++){
            if (imp[i] > max){
                max = imp[i];
                count = i;
            }
        }
        System.out.print("\nОптимальное альфа: " );
        System.out.println(0.69 + (double) (count+ 1)/100);
        System.out.println("УДельный импульс: " + max);
    }
}