package controller;

import model.*;


public class ExpressionTreeController {
    private ExpressionTree expressionTree;
    private Expression expressionRPN;


    public ExpressionTreeController(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }

    public void createTree(String expression) {
        try {
            expressionRPN = RPNExpressionConverter.convert(expression);
        } catch (Exception ex) {
            System.out.println("Cannot parse expression due to next errors: " + ex.getMessage());
            return;
        }

        expressionTree = new ExpressionTree(expressionRPN);
    }

    public void replace(ExpressionTreeNode node, ExpressionTreeNode what, ExpressionTreeNode with) {
        if (node.equals(what)) {
            node = with;
        } else {
            if (node.getLeftOperand() != null) {
                replace(node.getLeftOperand(), what, with);
            }

            if (node.getRightOperand() != null) {
                replace(node.getRightOperand(), what, with);
            }
        }
    }

    public ExpressionTreeNode getRoot() {
        return expressionTree.getRoot();
    }

    public Operand result() {
        return expressionTree.getRoot().getValue();
    }

    public Expression infix() {
        return expressionTree.toInfix();
    }
}
