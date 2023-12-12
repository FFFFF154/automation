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
//    private double[] alpha1 = {0.6, 0.61, 0.62, 0.63, 0.64, 0.65, 0.66, 0.67, 0.68, 0.69,
//            0.7, 0.71, 0.72, 0.73, 0.74, 0.75, 0.76, 0.77, 0.78, 0.79,
//            0.8, 0.81, 0.82, 0.83, 0.84, 0.85, 0.86, 0.87, 0.88, 0.89,
//            0.9};
//    private double[] tempеrature = {3455, 3495.2, 3532.4, 3567.1, 3599, 3629, 3656.6, 3681.8, 3704.8, 3725.7,
//                                    3744.6, 3761.7, 3777, 3790.8, 3803, 3813.9, 3823.5, 3831.9, 3839, 3845.7,
//                                    3851.2, 3855.9, 3859.9, 3863.1, 3865.8, 3867.9, 3869.4, 3870.5, 3871.1, 3871.4,
//                                    3871.2};
//    private double[] k = {1.222, 1.22, 1.219, 1.217, 1.215, 1.214, 1.213, 1.211, 1.21, 1.209,
//                        1.208, 1.207, 1.207, 1.206, 1.205, 1.204, 1.204, 1.203, 1.202, 1.202,
//                        1.202, 1.201, 1.201, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2,
//                        1.198};
//
//    private double[] r = {391.5, 387.9, 384.5, 381.2, 378.1, 375, 372.1, 369, 366.7, 364.1,
//                        361.7, 359.4, 357.1, 355, 352.9, 350.9, 349, 347.1, 345, 343.7,
//                        342, 340.4, 338.9, 337.4, 335.9, 334.5, 333.2, 331.9, 330.6, 329.4,
//                        328.1};

//    private double[] betta = {185.7, 185.7, 185.6, 185.3, 185.1, 185, 184.8, 184.5, 184.3,
//                            184, 183.7, 183.5, 183.2, 182.9, 182.6, 182.2, 181.9, 181.6, 181.3,
//                            180.9, 180.7, 180.3, 180, 179.7, 179.4, 179, 178.7, 178.4, 178.1, 177.8};

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
