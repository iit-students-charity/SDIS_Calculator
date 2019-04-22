package model;

public class BinaryOperator implements Operator {
    private String stringSource;
    private Operand operand1;
    private Operand operand2;


    public BinaryOperator(String stringSource) {
        this.stringSource = stringSource;
    }

    @Override
    public double result() throws Exception {
        switch (stringSource) {
            case OperatorFactory.PLUS: {
                return operand1.doubleSource() + operand2.doubleSource();
            }
            case OperatorFactory.MINUS: {
                return operand1.doubleSource() - operand2.doubleSource();
            }
            case OperatorFactory.DIVIDE: {
                return operand1.doubleSource() / operand2.doubleSource();
            }
            case OperatorFactory.MULTIPLICATE: {
                return operand1.doubleSource() * operand2.doubleSource();
            }
            case OperatorFactory.MOD: {
                return operand1.doubleSource() % operand2.doubleSource();
            }
        }

        throw new Exception("Not a binary operator");
    }

    @Override
    public String stringSource() {
        return stringSource;
    }

    public void setOperand1(Operand operand) {
        operand1 = operand;
    }

    public void setOperand2(Operand operand) {
        operand2 = operand;
    }
}
