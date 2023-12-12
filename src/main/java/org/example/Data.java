package org.example;

import java.util.HashMap;
import java.util.Map;

public class Data { // хранилище данных

    private double[] pk = {20.0, 21.0, 22.0, 23.0, 24.0};

    private double[] alpha = {0.6, 0.7, 0.8, 0.9, 1.0};

    private double[][] paramsTemperature = {{3455.5, 3744.6, 3851.2, 3871.2}, {3458.4, 3750, 3858, 3879}, {3461, 3755, 3865, 3886}, {3463, 3761, 3872, 3893}, {3466, 3766, 3878, 3900}};
    private double[][] paramsR = {{391.5, 361.7, 342, 328.1}, {391.4, 361.5, 341.8, 327.9}, {391.3, 361.3, 341.6, 327.6}, {391.2, 361.1, 341.3, 327.4}, {391.1, 361, 341.1, 327.2}};
    private double[][] paramsK = {{1.222, 1.208, 1.202, 1.198}, {1.222, 1.208, 1.201, 1.198}, {1.222, 1.208, 1.201, 1.198}, {1.222, 1.208, 1.201, 1.197}, {1.222, 1.207, 1.2, 1.197}};

    private double[][] paramsBetta = new double[5][4];
    private double[][] paramsI = new double[5][4];

    public void setParamsBetta(double[] betta, int i){
        paramsBetta[i] = betta;
    }
    public void setParamsI(double[] iud, int i){
        paramsI[i] = iud;
    }
    public double[][] getParamsI(){
        return paramsI;
    }
    public double[] getAlpha(){
        return alpha;
    }
    public double[][] getParamsR(){
        return paramsR;
    }
    public double[][] getParamsTemperature(){
        return paramsTemperature;
    }
    public double[][] getParamsK(){
        return paramsK;
    }
    public double[] getPk(){
        return pk;
    }
    public double[][] getParamsBetta(){
        return paramsBetta;
    }

}
