package org.example;

import java.util.Scanner;

public class Solver {
    private Data data;

    public Solver(Data data){
        this.data = data;
    }


    private static final double P = 4000000.0;

    private static final double PA = 0.06 ;

    public double[] betta(int i) { // Подсчет бетты
        double[] value = new double[4];
        for (int j = 0; j < 4; j++) {
            value[j] = Math.sqrt(data.getParamsR()[i][j] * data.getParamsTemperature()[i][j]) / (Math.sqrt(data.getParamsK()[i][j]) * Math.pow(2 / (data.getParamsK()[i][j] + 1), (data.getParamsK()[i][j] + 1) / (2 * (data.getParamsK()[i][j] - 1))));
            //System.out.println(value[j]);
        }
        data.setParamsBetta(value, i);
        return value;
    }

    public double[] q(int i) { // Подсчет Fкр/Fa
        double[] value = new double[4];
        for (int j = 0; j < 4; j++) {
            value[j] = (Math.sqrt(Math.pow(PA / data.getPk()[i], (2 / data.getParamsK()[i][j])) - Math.pow(PA / data.getPk()[i], ((data.getParamsK()[i][j] + 1) / data.getParamsK()[i][j])))) /
                        (Math.pow((2 / data.getParamsK()[i][j]) + 1, 1 / (data.getParamsK()[i][j] - 1)) * Math.sqrt((data.getParamsK()[i][j] - 1) / (data.getParamsK()[i][j] + 1)));
            //System.out.println(value[j]);
        }
        return value;
    }

    public double[] w(int i){ // подсчет скорости
        double[] value = new double[4];
        for (int j = 0; j < 4; j++) {
            value[j] = Math.sqrt((2.0 * data.getParamsK()[i][j]) / (data.getParamsK()[i][j] - 1) * data.getParamsR()[i][j] * data.getParamsTemperature()[i][j] * (1 - Math.pow(PA / data.getPk()[i], (data.getParamsK()[i][j] - 1) / data.getParamsK()[i][j])));
        }
        return value;
    }

    public double[] impulse(int k){ // Расчет удельного пустотного импульса
        double[] imp = new double[4];
        //int k = 0;
        for (int i = 0; i < 4; i++) {
            betta(i);
            imp[i] = w(k)[i] + ((PA / data.getPk()[k]) * betta(k)[i]) * q(k)[i];
            //System.out.println(imp[i]);
            //System.out.print("[" + i + "] = " + imp[i] + " ");

            //System.out.println(data.getParamsI()[k][i]);
            //k++;
        }
        data.setParamsI(imp, k);

        //System.out.println(data.getParamsI()[0][0]);
        return imp;
    }


}
