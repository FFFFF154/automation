package org.example;

public class MaxValue {
    private Data data;


    public MaxValue(Data data){
        this.data = data;
    }
    //TODO разобраться с хранилищем
    public double[] maxI(){
        Solver solver = new Solver(data);
        double max;
        double[] value = new double[5];
        for (int i=0; i<5; i++){
            solver.impulse(i);
            max = data.getParamsI()[i][0];
            for (int j=0; j<4; j++){
                if (data.getParamsI()[i][j] > max){
                    max = data.getParamsI()[i][j];
                }
            }
            value[i] = max;
        }
        return value;
    }
}
