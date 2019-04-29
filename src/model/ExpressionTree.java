package model;


import javafx.scene.control.TreeItem;

import java.util.*;


public class ExpressionTree {
    private ExpressionTreeNode root;


    public ExpressionTree() {
        root = null;
    }

    public ExpressionTree(Expression expression) {
        root = construct(expression);
    }

    public ExpressionTreeNode getRoot() {
        return root;
    }

    public void setRoot(ExpressionTreeNode root) {
        this.root = root;
    }

    public Expression toInfix() {
        Expression infix = new Expression();
        traverseInfix(root, infix);

        List<Token> toRemove = new ArrayList<>();

        for (int tokenIterator = 0; tokenIterator < infix.tokens().size(); tokenIterator++) {
            if (infix.tokens().get(tokenIterator) instanceof Operand) {
                if (infix.tokens().get(tokenIterator + 1) instanceof Bracket) {
                    toRemove.add(infix.tokens().get(tokenIterator + 1));
                    toRemove.add(infix.tokens().get(tokenIterator - 1));
                }
            }
        }

        toRemove.add(infix.tokens().get(0));
        toRemove.add(infix.tokens().get(infix.tokens().size() - 1));

        infix.tokens().removeAll(toRemove);

        return infix;
    }

    /*
     *      Util
     */

    private void traverseInfix(ExpressionTreeNode root, Expression expression) {
        expression.addToken(new Bracket(Bracket.OPEN));

        if (root.getState().equals(ExpressionTreeNode.State.VALUE)) {
            expression.addToken(root.getValue());
        }

        if (root.getState().equals(ExpressionTreeNode.State.OPERATOR)) {
            if (root.getRightOperand() != null) {
                traverseInfix(root.getRightOperand(), expression);
            }

            expression.addToken((Token) root.getOperator());

            if (root.getLeftOperand() != null) {
                traverseInfix(root.getLeftOperand(), expression);
            }
        }

        expression.addToken(new Bracket(Bracket.CLOSE));
    }

    private ExpressionTreeNode construct(Expression rpn) {
        Deque<ExpressionTreeNode> tokenDeque = new ArrayDeque<>();
        ExpressionTreeNode anyRoot, leftOperand, rightOperand;

        for (Token token : rpn.tokens()) {
            if (token instanceof Operand) {
                anyRoot = new ExpressionTreeNode((Operand) token);
                tokenDeque.push(anyRoot);
            }

            if (token instanceof Operator) {
                anyRoot = new ExpressionTreeNode((Operator) token);

                leftOperand = tokenDeque.pop();

                if (token instanceof BinaryOperator) {
                    rightOperand = tokenDeque.pop();
                } else {
                    rightOperand = null;
                }

                anyRoot.setLeftOperand(leftOperand);
                anyRoot.setRightOperand(rightOperand);

                tokenDeque.push(anyRoot);
            }
        }

        anyRoot = tokenDeque.pop();

        return anyRoot;
    }
}
