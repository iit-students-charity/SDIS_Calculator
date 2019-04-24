package controller;

import model.*;

import java.util.*;

public class RPNExpressionConverter {
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final String DOT = ".";
    private static final String EXPRESSION_BORDER = "$";


    public static Expression convert(String expression) throws Exception {
        Expression expressionRPN = new Expression();
        Deque<String> operatorStack = new ArrayDeque<>();
        operatorStack.push(EXPRESSION_BORDER);
        expression = expression.concat(EXPRESSION_BORDER);
        String currentOperand = "";
        String currentOperationSymbol;

        for (int expIndex = 0; expIndex < expression.length(); expIndex++) {
            if (isOperand(expression.substring(expIndex, expIndex + 1))) {
                currentOperand = currentOperand.concat(expression.substring(expIndex, expIndex + 1));
            } else {
                if (!currentOperand.equals("")) {
                    expressionRPN.addToken(new Operand(currentOperand));
                    currentOperand = "";
                }

                currentOperationSymbol = expression.substring(expIndex, expIndex + 1);
                System.out.println(currentOperationSymbol);

                // if factorial found
                if (expression.substring(expIndex, expIndex + OperatorFactory.FACTORIAL.length())
                        .equals(OperatorFactory.FACTORIAL)) {

                    expressionRPN.addToken(OperatorFactory.getOperator(expression
                            .substring(expIndex, expIndex + OperatorFactory.FACTORIAL.length())));

                    continue;
                }

                // if open bracket found
                if (expression.substring(expIndex, expIndex + OPEN_BRACKET.length())
                        .equals(OPEN_BRACKET)) {

                    operatorStack.push(OPEN_BRACKET);
                    expIndex += OPEN_BRACKET.length() - 1;
                    continue;
                }

                // if minus or plus found
                if (currentOperationSymbol.equals(OperatorFactory.MINUS)
                        || currentOperationSymbol.equals(OperatorFactory.PLUS)) {

                    if (expIndex == 0 || expression.substring(expIndex - 1, expIndex).equals(OPEN_BRACKET)) {
                        operatorStack.push(expression.substring(expIndex, expIndex + 1));
                    } else {
                        do {
                            if (operatorStack.peek().equals(EXPRESSION_BORDER)
                                    || operatorStack.peek().equals(OPEN_BRACKET)) {

                                operatorStack.push(currentOperationSymbol);

                                break;
                            } else {
                                if (!operatorStack.isEmpty()) {
                                    expressionRPN.addToken(OperatorFactory.getOperator(operatorStack.pop()));
                                }
                            }

                        } while (true);
                    }

                    continue;
                }

                // if divide, multiplicate or mod found
                if (currentOperationSymbol
                        .equals(OperatorFactory.DIVIDE)
                        || currentOperationSymbol
                        .equals(OperatorFactory.MULTIPLICATE)
                        || currentOperationSymbol
                        .equals(OperatorFactory.MOD)) {

                    do {
                        if (operatorStack.peek().equals(OperatorFactory.MULTIPLICATE) ||
                                operatorStack.peek().equals(OperatorFactory.DIVIDE) ||
                                operatorStack.peek().equals(OperatorFactory.SQRT) ||
                                operatorStack.peek().equals(OperatorFactory.MOD)) {

                            if (!operatorStack.isEmpty()) {
                                expressionRPN.addToken(OperatorFactory.getOperator(operatorStack.pop()));
                            }
                        } else {
                            operatorStack.push(currentOperationSymbol);
                            break;
                        }

                    } while (true);

                    continue;
                }

                // if close bracket found
                if (expression.substring(expIndex, expIndex + CLOSE_BRACKET.length())
                        .equals(CLOSE_BRACKET)) {

                    do {
                        if (operatorStack.peek().equals(EXPRESSION_BORDER)) {
                            throw new Exception("Error: bracket at begin is not closed");
                        } else if (operatorStack.peek().equals(OPEN_BRACKET)) {
                            operatorStack.pop();
                            if (operatorStack.peek().equals(OperatorFactory.LOG) || operatorStack.peek().equals(OperatorFactory.LN) ||
                                    operatorStack.peek().equals("+/-")) {

                                if (!operatorStack.isEmpty()) {
                                    expressionRPN.addToken(OperatorFactory.getOperator(operatorStack.pop()));
                                }
                            }

                            break;
                        }

                        if (!operatorStack.isEmpty()) {
                            expressionRPN.addToken(OperatorFactory.getOperator(operatorStack.pop()));
                        }

                    } while (true);

                    continue;
                }

                // if expression border found
                if (expression.substring(expIndex, expIndex + EXPRESSION_BORDER.length())
                        .equals(EXPRESSION_BORDER)) {

                    do {
                        if (operatorStack.peek().equals(EXPRESSION_BORDER)) {
                            break;
                        } else if (operatorStack.peek().equals(OPEN_BRACKET)) {
                            throw new Exception("Error: open bracket in the end of the expression");
                        }

                        if (!operatorStack.isEmpty()) {
                            expressionRPN.addToken(OperatorFactory.getOperator(operatorStack.pop()));
                        }
                    } while (true);

                    continue;
                }

                // if ln() found
                if (expression.substring(expIndex, expIndex + OperatorFactory.LN.length())
                        .equals(OperatorFactory.LN)) {

                    operatorStack.push(OperatorFactory.LN);
                    expIndex += OperatorFactory.LN.length() - 1;
                    continue;
                }

                // if log() found
                if (expression.substring(expIndex, expIndex + OperatorFactory.LOG.length())
                        .equals(OperatorFactory.LOG)) {

                    operatorStack.push(OperatorFactory.LOG);
                    expIndex += OperatorFactory.LOG.length() - 1;
                    continue;
                }

                // if sqrt() found
                if (expression.substring(expIndex, expIndex + OperatorFactory.SQRT.length())
                        .equals(OperatorFactory.SQRT)) {

                    operatorStack.push(OperatorFactory.SQRT);
                    expIndex += OperatorFactory.SQRT.length() - 1;
                    continue;
                }
            }
        }

        System.out.println("RPN " + expressionRPN);
        return expressionRPN;
    }

    private static boolean isOperand(String operand) {
        for(char symbol : operand.toCharArray()) {
            if(!Character.isDigit(symbol) && (symbol != DOT.charAt(0))) {
                return false;
            }
        }

        return true;
    }
}
