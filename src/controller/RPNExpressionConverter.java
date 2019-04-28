package controller;

import model.*;
import java.util.*;

public class RPNExpressionConverter {
    public static final String DOT = ".";
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

                // if factorial found
                if (expression.substring(expIndex, expIndex + OperatorFactory.FACTORIAL.length())
                        .equals(OperatorFactory.FACTORIAL)) {

                    expressionRPN.addToken(OperatorFactory.getOperator(expression
                            .substring(expIndex, expIndex + OperatorFactory.FACTORIAL.length()))); // why so hard? just OF.FACTORIAL mb?

                    continue;
                }

                // if open bracket found
                if (expression.substring(expIndex, expIndex + Bracket.OPEN.length())
                        .equals(Bracket.OPEN)) {

                    operatorStack.push(Bracket.OPEN);
                    expIndex += Bracket.OPEN.length() - 1;
                    continue;
                }

                // if minus or plus found
                if (currentOperationSymbol.equals(OperatorFactory.MINUS)
                        || currentOperationSymbol.equals(OperatorFactory.PLUS)) {

                    if (expIndex == 0 || expression.substring(expIndex - 1, expIndex).equals(Bracket.OPEN)) {
                        operatorStack.push(expression.substring(expIndex, expIndex + 1));
                    } else {
                        do {
                            if (operatorStack.peek().equals(EXPRESSION_BORDER)
                                    || operatorStack.peek().equals(Bracket.OPEN)) {

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
                if (expression.substring(expIndex, expIndex + Bracket.CLOSE.length())
                        .equals(Bracket.CLOSE)) {

                    do {
                        if (operatorStack.peek().equals(EXPRESSION_BORDER)) {
                            throw new Exception("Bracket at begin is not closed");
                        } else if (operatorStack.peek().equals(Bracket.OPEN)) {
                            operatorStack.pop();

                            if (operatorStack.peek().equals(OperatorFactory.LG) || operatorStack.peek().equals(OperatorFactory.LN) ||
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
                        } else if (operatorStack.peek().equals(Bracket.OPEN)) {
                            throw new Exception("Open bracket in the end of the expression");
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

                // if lg() found
                if (expression.substring(expIndex, expIndex + OperatorFactory.LG.length())
                        .equals(OperatorFactory.LG)) {

                    operatorStack.push(OperatorFactory.LG);
                    expIndex += OperatorFactory.LG.length() - 1;
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

        //System.out.println("RPN " + expressionRPN);
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
