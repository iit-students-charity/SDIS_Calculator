package model;


public class ExpressionTreeNode {
    private ExpressionTreeNode leftOperand;
    private ExpressionTreeNode rightOperand;
    private Operator operator;
    private Operand result;


    public ExpressionTreeNode(Operator operator) {
        this.operator = operator;
    }

    public ExpressionTreeNode(Operand result) {
        leftOperand = null;
        rightOperand = null;
        operator = null;
        this.result = result;
    }

    public ExpressionTreeNode() {
        operator = null;
        leftOperand = null;
        rightOperand = null;
        result = null;
    }

    public Operator getOperator() {
        return operator;
    }

    public Operand getResult() {
        return new Operand(operator.result());
    }

    public void setLeftOperand(ExpressionTreeNode leftOperand) {
        this.leftOperand = leftOperand;
    }

    public void setRightOperand(ExpressionTreeNode rightOperand) {
        this.rightOperand = rightOperand;
    }

    public ExpressionTreeNode getLeftOperand() {
        return leftOperand;
    }

    public ExpressionTreeNode getRightOperand() {
        return rightOperand;
    }
}
