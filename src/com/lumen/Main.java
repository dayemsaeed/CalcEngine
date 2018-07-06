package com.lumen;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        double value1, value2, result;
//        char opCode;
//
//        Scanner value1Input = new Scanner(System.in);
//        System.out.print("Enter value 1: ");
//        value1 = value1Input.nextDouble();
//
//        Scanner value2Input = new Scanner(System.in);
//        System.out.print("Enter value 2: ");
//        value2 = value2Input.nextDouble();
//
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter op code: ");
//        opCode = input.next().charAt(0);
//
//        if (opCode == 'a') {
//            result = value1 + value2;
//        }
//        else if (opCode == 's') {
//            result = value1 - value2;
//        }
//        else if (opCode == 'm') {
//            result = value1 * value2;
//        }
//        else if (opCode == 'd') {
//            if (value2 != 0) {
//                result = value1 / value2;
//            }
//            else {
//                result = 0;
//                System.out.println("Cannot divide by 0");
//            }
//        }
//        else {
//            result = '\0';
//        }
//
//        if (result != '\0') {
//            System.out.println("Answer: " + result);
//        }
//        else {
//            System.out.println("Error");
//        }

        // Array implementation of CalcEngine

//        double leftvals[] = { 100.0d, 25.0d, 225.0d, 11.0d };
//        double rightvals[] = { 50.0d, 92.0d, 17.0d, 3.0d };
//        char opCodes[] = { 'd', 'a', 's', 'm' };
//        double results[] = new double [opCodes.length];

        // Test code
//        MathEquation testEquation = new MathEquation();
//        testEquation.execute();
//        System.out.println("Result = " + testEquation.getResult());

        String statements[] = {
                "add 1.0", // Error: incorrect number of values
                "add xx 25.0", // Error: non-numeric data
                "addX 0.0 0.0", // Error: invalid command
                "divide 100.0 50.0", // 100.0 / 50.0 = 2.0
                "add 25.0 92.0", // 25.0 + 92.0 = 117.0
                "subtract 225.0 17.0", // 225.0 - 17.0 = 108.0
                "multiply 11.0 3.0" // 11.0 x 3.0 = 33.0
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement: statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("Original Exception: " + e.getCause().getMessage());
                }
            }
        }

    }

    static void useMathEquation() {

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0, 50.0);
        equations[1] = new MathEquation('a', 25.0, 92.0);
        equations[2] = new MathEquation('s', 225.0, 17.0);
        equations[3] = new MathEquation('m', 11.0, 3.0);


        // for (int i = 0; i < opCodes.length; i++) {

        // Using 'if'
//            if (opCodes[i] == 'a') {
//                results[i] = leftvals[i] + rightvals[i];
//            }
//            else if (opCodes[i] == 's') {
//                results[i] = leftvals[i] - rightvals[i];
//            }
//            else if (opCodes[i] == 'm') {
//                results[i] = leftvals[i] * rightvals[i];
//            }
//            else if (opCodes[i] == 'd') {
//                if (rightvals[i] != 0) {
//                    results[i] = leftvals[i] / rightvals[i];
//                }
//                else {
//                    results[i] = 0;
//                    System.out.println("Cannot divide by 0");
//                }
//            }
//            else {
//                results[i] = '\0';
//            }

        // Using 'switch'

//            switch (opCodes[i]) {
//
//                    case 'a':
//                        results[i] = leftvals[i] + rightvals[i];
//                        break;
//
//                    case 's':
//                        results[i] = leftvals[i] - rightvals[i];
//                        break;
//
//                    case 'm':
//                        results[i] = leftvals[i] * rightvals[i];
//                        break;
//
//                    case 'd':
//                        if (rightvals[i] != 0) {
//                            results[i] = leftvals[i] / rightvals[i];
//                        }
//                        else {
//                            results[i] = 0;
//                            System.out.println("Cannot divide by 0");
//                        }
//                        break;
//
//                    default:
//                        results[i] = '\0';
//                        break;
//
//
//            }

        // }

//        for (double theResult : results) {
//            if (theResult != '\0') {
//                System.out.println("Answer: " + theResult);
//            }
//            else {
//                System.out.println("Error");
//            }
//        }

        // Classes implementation
        for (MathEquation equation : equations) {

            equation.execute();
            if (equation.getResult() != '\0') {
                System.out.println("Answer: " + equation.getResult());
            }
            else {
                System.out.println("Error");
            }

        }

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;

        MathEquation mathOverload = new MathEquation('d');
        mathOverload.execute(leftDouble, rightDouble);
        System.out.println("Result = " + mathOverload.getResult());

        int leftInt = 9, rightInt = 4;
        mathOverload.execute(leftInt, rightInt);
        System.out.println("Result = " + mathOverload.getResult());

        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

    }

    static void useCalculatorBase() {

        CalculateBase[] calculators = {
                new Divider(100, 50),
                new Adder(25, 92),
                new Subtracter(225, 17),
                new Multiplier(11, 3)
        };

        for (CalculateBase calculator : calculators) {
            calculator.calculate();
            System.out.println("Result = " + calculator.getResult());
        }

    }

//    private static MathEquation create(double value1, double value2, char opCode) {
//
//        MathEquation equation = new MathEquation();
//        equation.setValue1(value1);
//        equation.setValue2(value2);
//        equation.setOpCode(opCode);
//
//        return equation;
//
//    }

}
