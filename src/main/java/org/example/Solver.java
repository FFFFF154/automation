package org.example;

public class Solver implements Runnable{
    private Data data;
    static InputValue inputValue = new InputValue();

    public Solver(Data data) {
        this.data = data;
    }


    private static final double P = 4_000_000.0;

    private static final double PA = 0.06;

    public double[] betta(int i) { // Подсчет бетты
        double[] value = new double[4];
        for (int j = 0; j < 4; j++) {
            value[j] = Math.sqrt(data.getParamsR()[i][j] * data.getParamsTemperature()[i][j]) / (Math.sqrt(data.getParamsK()[i][j]) * Math.pow(2 / (data.getParamsK()[i][j] + 1), (data.getParamsK()[i][j] + 1) / (2 * (data.getParamsK()[i][j] - 1))));
        }
        data.setParamsBetta(value, i);
        return value;
    }

    public double[] q(int i) { // Подсчет Fкр/Fa
        double[] value = new double[4];
        for (int j = 0; j < 4; j++) {
            value[j] = (Math.sqrt(Math.pow(PA / data.getPk()[i], (2 / data.getParamsK()[i][j])) - Math.pow(PA / data.getPk()[i], ((data.getParamsK()[i][j] + 1) / data.getParamsK()[i][j])))) /
                    (Math.pow((2 / data.getParamsK()[i][j]) + 1, 1 / (data.getParamsK()[i][j] - 1)) * Math.sqrt((data.getParamsK()[i][j] - 1) / (data.getParamsK()[i][j] + 1)));
        }
        return value;
    }

    public double[] w(int i) { // подсчет скорости
        double[] value = new double[4];
        for (int j = 0; j < 4; j++) {
            value[j] = Math.sqrt((2.0 * data.getParamsK()[i][j]) / (data.getParamsK()[i][j] - 1) * data.getParamsR()[i][j] * data.getParamsTemperature()[i][j] * (1 - Math.pow(PA / data.getPk()[i], (data.getParamsK()[i][j] - 1) / data.getParamsK()[i][j])));
        }
        return value;
    }

    public double[] impulse(int k) { // Расчет удельного пустотного импульса
        double[] imp = new double[4];
        for (int i = 0; i < 4; i++) {
            betta(i);
            imp[i] = w(k)[i] + ((PA / data.getPk()[k]) * betta(k)[i]) * q(k)[i];
        }
        data.setParamsI(imp, k);
        return imp;
    }

    public double optConsumption(double I) {
        return P / I;
    }

    public double diamKp(double m, double alpha) throws PressureException {
        int count1 = 0;
        int count2 = 0;
        for (int k = 0; k < 5; k++) {
            if ((int) inputValue.inputPressure() == data.getPk()[k]) {
                count1 = k;
            }
        }
        for (int k = 0; k < 5; k++) {
            if ((Math.round(alpha * 10) -0.01) / 10.0 == data.getAlpha()[k]) {
                count2 = k;
            }
        }
        double value = m * data.getParamsBetta()[count1][count2] / (inputValue.inputPressure() * 1_000_000);
        return Math.sqrt(4 * value / Math.PI);
    }

    public double diamA(double m, double alpha) throws PressureException{
        int count1 = 0;
        int count2 = 0;
        for (int k = 0; k < 5; k++) {
            if ((int) inputValue.inputPressure() == data.getPk()[k]) {
                count1 = k;
            }
        }
        for (int k = 0; k < 5; k++) {
            if ((Math.round(alpha * 10)-0.01 )/ 10.0 == data.getAlpha()[k]) {
                count2 = k;
            }
        }
        double value = (P - (m * w(count1)[count2])) / (PA * 1_000_000);

        return Math.sqrt(4 * value / Math.PI);
    }

    public void run(){
        for (int i=0; i<5; i++){
            impulse(i);
        }
    }
}
