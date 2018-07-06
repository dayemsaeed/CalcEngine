package com.lumen;

public class Subtracter extends CalculateBase {

    public Subtracter() {};
    public Subtracter(double value1, double value2) {
        super(value1, value2);
    }

    @Override
    public void calculate() {
        double value = getValue1() - getValue2();
        setResult(value);
    }
}
