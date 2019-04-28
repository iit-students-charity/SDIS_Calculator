package model;


public class ExpressionTreeNode {
    public enum State { OPERATOR, VALUE };

    private State state;
    private ExpressionTreeNode leftOperand;
    private ExpressionTreeNode rightOperand;
    private Operator operator;
    private Operand value;


    public ExpressionTreeNode(Operator operator) {
        this.operator = operator;
        state = State.OPERATOR;
    }

    public ExpressionTreeNode(Operand value) {
        leftOperand = null;
        rightOperand = null;
        operator = null;
        this.value = value;

        state = State.VALUE;
    }

    public ExpressionTreeNode() {
        operator = null;
        leftOperand = null;
        rightOperand = null;
        value = null;

        state = null;
    }

    public Operator getOperator() {
        return operator;
    }

    public Operand value() {
        if (value != null) {
            return value;
        } else {
            if (operator instanceof BinaryOperator) {
                ((BinaryOperator) operator).setLeftOperand(leftOperand.value());
                ((BinaryOperator) operator).setRightOperand(rightOperand.value());
                value = operator.result();
            }

            if (operator instanceof UnaryOperator) {
                ((UnaryOperator) operator).setOperand(leftOperand.value());
                value = operator.result();
            }
        }

        return value;
    }

    public void setLeftOperand(ExpressionTreeNode leftOperand) {
        this.leftOperand = leftOperand;

        if (operator instanceof BinaryOperator) {
            ((BinaryOperator) operator).setLeftOperand(leftOperand.value);
        } else {
            ((UnaryOperator) operator).setOperand(leftOperand.value);
        }
    }

    public void setRightOperand(ExpressionTreeNode rightOperand) {
        this.rightOperand = rightOperand;

        if (operator instanceof BinaryOperator) {
            ((BinaryOperator) operator).setRightOperand(leftOperand.value);
        }
    }

    public ExpressionTreeNode getLeftOperand() {
        return leftOperand;
    }

    public ExpressionTreeNode getRightOperand() {
        return rightOperand;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        if (operator == null) {
            return value.source();
        } else {
            switch (state) {
                case OPERATOR: {
                    return ((Token) operator).source();
                }
                case VALUE: {
                    return value().source();
                }
            }
        }

        return null;
    }
}
