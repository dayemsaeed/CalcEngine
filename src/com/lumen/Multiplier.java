package com.lumen;

public class Multiplier extends CalculateBase {

    public Multiplier() {};
    public Multiplier(double value1, double value2) {
        super(value1, value2);
    }

    @Override
    public void calculate() {
        double value = getValue1() * getValue2();
        setResult(value);
    }
}
