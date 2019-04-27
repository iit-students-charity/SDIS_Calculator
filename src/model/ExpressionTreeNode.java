package model;


public class ExpressionTreeNode {
    private ExpressionTreeNode leftOperand;
    private ExpressionTreeNode rightOperand;
    private Operator operator;
    private Operand value;


    public ExpressionTreeNode(Operator operator) {
        this.operator = operator;
    }

    public ExpressionTreeNode(Operand value) {
        leftOperand = null;
        rightOperand = null;
        operator = null;
        this.value = value;
    }

    public ExpressionTreeNode() {
        operator = null;
        leftOperand = null;
        rightOperand = null;
        value = null;
    }

    public Operator getOperator() {
        return operator;
    }

    public Operand getValue() {
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
}
