package com.lumen;

public class CalculateHelper {

    private static final char ADD_SYMBOL = '+';
    private static final char MINUS_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';

    MathCommand command;
    double value1, value2, result;

    public void process(String statement) throws InvalidStatementException {

        // add 1.0 2.0
        String parts[] = statement.split(" ");

        if (parts.length != 3) {
            throw new InvalidStatementException("Incorrect number of fields", statement);
        }

        String commandString = parts[0]; // add

        try {
            value1 = Double.parseDouble(parts[1]); // 1.0
            value2 = Double.parseDouble(parts[2]); // 2.0
        } catch (NumberFormatException e) {
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }

        value1 = Double.parseDouble(parts[1]); // 1.0
        value2 = Double.parseDouble(parts[2]); // 2.0

        setCommandFromString(commandString);
        if (command == null) {
            throw new InvalidStatementException("Invalid command", statement);
        }

        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator = new Adder(value1, value2);
                break;
            case Subtract:
                calculator = new Subtracter(value1, value2);
                break;
            case Multiply:
                calculator = new Multiplier(value1, value2);
                break;
            case Divide:
                calculator = new Divider(value1, value2);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();

    }

    private void setCommandFromString(String commandString) {

        if (commandString.equalsIgnoreCase(MathCommand.Add.toString())) {
            command = MathCommand.Add;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Subtract.toString())) {
            command = MathCommand.Subtract;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString())) {
            command = MathCommand.Multiply;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString())) {
            command = MathCommand.Divide;
        }

    }

    @Override
    public String toString() {
        char symbol = ' ';
        switch (command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = MINUS_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(value1);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(value2);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();

    }
}
