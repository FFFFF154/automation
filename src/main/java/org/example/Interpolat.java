package org.example;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
public class Interpolat {
    private static Data data;
    static InputValue inputValue = new InputValue();
    public Interpolat(Data data){
        this.data = data;
    }
    public static double interpolatorI() throws PressureException{
        MaxValue maxValue = new MaxValue(data);
        SplineInterpolator interpolator = new SplineInterpolator();
        PolynomialSplineFunction splineFunction = interpolator.interpolate(data.getPk(), maxValue.maxI());
        return splineFunction.value(inputValue.inputPressure());
    }

    public double interpolatorAlpha() throws PressureException{
        MaxValue maxValue = new MaxValue(data);
        SplineInterpolator interpolator = new SplineInterpolator();
        PolynomialSplineFunction splineFunction = interpolator.interpolate(maxValue.maxI(), data.getAlpha());
        return splineFunction.value(interpolatorI());
    }

}
