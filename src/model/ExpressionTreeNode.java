package model;


public class ExpressionTreeNode {
    private ExpressionTreeNode operand1;
    private ExpressionTreeNode operand2;
    private Operator operator;
    private Operand result;


    public ExpressionTreeNode(Operator operator) {
        this.operator = operator;
    }

    public ExpressionTreeNode(Operand result) {
        operand1 = null;
        operand2 = null;
        operator = null;
        this.result = result;
    }

    public ExpressionTreeNode() {
        operator = null;
        operand1 = null;
        operand2 = null;
        result = null;
    }

    public Operator getOperator() {
        return operator;
    }

    public Operand getResult() {
        return new Operand(operator.result());
    }

    public void setOperand1(ExpressionTreeNode operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(ExpressionTreeNode operand2) {
        this.operand2 = operand2;
    }

    public ExpressionTreeNode getOperand1() {
        return operand1;
    }

    public ExpressionTreeNode getOperand2() {
        return operand2;
    }
}
