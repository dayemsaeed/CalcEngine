package com.lumen;

public class MathEquation {

    private double value1;
    private double value2;
    private char opCode;
    private double result;

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

    public MathEquation() {};

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double value1, double value2) {
        this(opCode);
        this.value1 = value1;
        this.value2 = value2;
    }

    public void execute(double value1, double value2) {

        this.value1 = value1;
        this.value2 = value2;
        execute();

    }

    public void execute(int value1, int value2) {

        this.value1 = value1;
        this.value2 = value2;
        execute();
        result = (int) result;

    }

    public void execute() {

        switch (opCode) {

            case 'a':
                result = value1 + value2;
                break;

            case 's':
                result = value1 - value2;
                break;

            case 'm':
                result = value1 * value2;
                break;

            case 'd':
                if (value2 != 0) {
                    result = value1 / value2;
                }
                else {
                    result = 0;
                    System.out.println("Cannot divide by 0");
                }
                break;

            default:
                result = '\0';
                break;


        }

    }

}
