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
        //System.out.println(data.getParamsI()[0][0]);
        double[] value = new double[5];
        for (int i=0; i<5; i++){
            solver.impulse(i);
            //System.out.println(data.getParamsI()[0][0]);
            max = data.getParamsI()[i][0];
            for (int j=0; j<4; j++){
                //System.out.print(data.getParamsI()[i][j] + " ");
                if (data.getParamsI()[i][j] > max){
                    max = data.getParamsI()[i][j];
                }
            }
            value[i] = max;
        }
        return value;
    }
}
