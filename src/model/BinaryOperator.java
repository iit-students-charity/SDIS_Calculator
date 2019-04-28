package model;


public class BinaryOperator extends Token implements Operator {
    private Operand leftOperand;
    private Operand rightOperand;


    public BinaryOperator(String source) {
        this.source = source;
    }

    @Override
    public Operand result() {
        switch (source) {
            // не баг, а фича
            case OperatorFactory.PLUS: {
                return new Operand(rightOperand.value() + leftOperand.value());
            }
            case OperatorFactory.MINUS: {
                return new Operand(rightOperand.value() - leftOperand.value());
            }
            case OperatorFactory.DIVIDE: {
                return new Operand(rightOperand.value() / leftOperand.value());
            }
            case OperatorFactory.MULTIPLICATE: {
                return new Operand(rightOperand.value() * leftOperand.value());
            }
            case OperatorFactory.MOD: {
                return new Operand(rightOperand.value() % leftOperand.value());
            }
        }

        return new Operand(0);
    }

    public void setLeftOperand(Operand operand) {
        leftOperand = operand;
    }

    public void setRightOperand(Operand operand) {
        rightOperand = operand;
    }
}
