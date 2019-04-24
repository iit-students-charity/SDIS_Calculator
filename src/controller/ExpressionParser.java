package controller;

import model.ExpressionTreeNode;
import model.Operand;
import model.OperatorFactory;

import java.util.Stack;

public class ExpressionParser {
    public static ExpressionTreeNode parse(String expressionRPN) {
        Stack<ExpressionTreeNode> operStack = new Stack<>();
        ExpressionTreeNode root, operand1, operand2;

        for (int expStringIndex = 0; expStringIndex < expressionRPN.length() - 1; expStringIndex++) {
            if (!isOperator(expressionRPN.substring(expStringIndex, expStringIndex + 1))) {
                int doubleIndex = expStringIndex;
                String doubleSubstring;

                while (!isOperator(expressionRPN.substring(doubleIndex, doubleIndex + 1))
                        && doubleIndex < expressionRPN.length() - 1) {
                    doubleIndex++;
                }

                doubleSubstring = expressionRPN.substring(expStringIndex, doubleIndex);
                root = new ExpressionTreeNode(new Operand(
                        Double.parseDouble(doubleSubstring)
                ));

                operStack.push(root);
            } else {
                /*root = new ExpressionTreeNode(OperatorFactory.getOperator(
                        expressionRPN.substring(expStringIndex, expStringIndex + 1))
                );*/

                operand1 = operStack.pop();
                operand2 = operStack.pop();

                //root.setLeftOperand(operand1);
                //root.setRightOperand(operand2);

                //operStack.push(root);
                //System.out.println(root);
            }
        }

        root = operStack.peek();
        operStack.pop();

        return root;
    }

    private static boolean isOperator(String operator) {
        return operator.equals(OperatorFactory.PLUS)
                || operator.equals(OperatorFactory.MINUS)
                || operator.equals(OperatorFactory.DIVIDE)
                || operator.equals(OperatorFactory.MULTIPLICATE)
                || operator.equals(OperatorFactory.MOD)
                || operator.equals(OperatorFactory.SQRT);
    }
}
