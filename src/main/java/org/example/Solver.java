package org.example;

import java.util.Scanner;

public class Solver {

    Data data = new Data();
    private static final double P = 4000000.0;

    private static final double PA = 0.06 * 1000000;

    private static final Scanner SCANNER = new Scanner(System.in);

    private Double pk;

    public double inputPressure() throws PressureException { // Ввод давления
        if (pk == null){ // Единичный ввод
            pk = Double.parseDouble(SCANNER.nextLine());
            if (pk < 20 || (pk > 24)) { // Проверка на корректность ввода
                throw new PressureException("Введите давления из диапазона 20...24");
            }
        }
        return pk * 1000000;
    }

    public double[] impulse() throws PressureException{
        double[] imp = new double[31];
        for (int i=0; i<31; i++){
            imp[i] = Math.sqrt((2.0*data.getK()[i])/(data.getK()[i] - 1) * data.getR()[i] * data.getTempеrature()[i] * (1 - Math.pow(PA/inputPressure(), (data.getK()[i]-1)/data.getK()[i])));
            System.out.print(imp[i] + " ");
        }
        return imp;
    }




}
