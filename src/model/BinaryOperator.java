package model;


public class BinaryOperator extends Token implements Operator {
    private Operand leftOperand;
    private Operand rightOperand;


    public BinaryOperator(String source) {
        this.source = source;
    }

    public BinaryOperator(String source, Operand leftOperand, Operand rightOperand) {
        this(source);
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public double result() {
        switch (source) {
            case OperatorFactory.PLUS: {
                return leftOperand.value() + rightOperand.value();
            }
            case OperatorFactory.MINUS: {
                return leftOperand.value() - rightOperand.value();
            }
            case OperatorFactory.DIVIDE: {
                return leftOperand.value() / rightOperand.value();
            }
            case OperatorFactory.MULTIPLICATE: {
                return leftOperand.value() * rightOperand.value();
            }
            case OperatorFactory.MOD: {
                return leftOperand.value() % rightOperand.value();
            }
        }

        return 0;
    }

    public void setLeftOperand(Operand operand) {
        leftOperand = operand;
    }

    public void setRightOperand(Operand operand) {
        rightOperand = operand;
    }
}
