package model;

public class UnaryOperator implements Operator {
    private String stringSource;
    private Operand operand;


    public UnaryOperator(String stringSource) {
        this.stringSource = stringSource;
    }

    @Override
    public double result() throws Exception {
        switch (stringSource) {
            case OperatorFactory.REVERSE: {
                return 1 / operand.doubleSource();
            }
            case OperatorFactory.SQRT: {
                return Math.sqrt(operand.doubleSource());
            }
        }

        throw new Exception("Not an unary operator");
    }

    @Override
    public String stringSource() {
        return stringSource;
    }

    public void setOperand(Operand operand) {
        this.operand = operand;
    }
}
