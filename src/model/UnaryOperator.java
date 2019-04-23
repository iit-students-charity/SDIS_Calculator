package model;


public class UnaryOperator implements Operator {
    private String stringSource;
    private Operand operand;


    public UnaryOperator(String stringSource) {
        this.stringSource = stringSource;
    }

    @Override
    public double result() {
        switch (stringSource) {
            case OperatorFactory.SQRT: {
                return Math.sqrt(operand.doubleSource());
            }
        }

        return 0;
    }

    @Override
    public String stringSource() {
        return stringSource;
    }

    public void setOperand(Operand operand) {
        this.operand = operand;
    }
}
