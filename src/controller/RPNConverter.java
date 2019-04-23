package controller;

import model.OperatorFactory;

import java.util.Stack;

public class RPNConverter {
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";


    public static String convert(String expression) {
        String expressionRPN = "";
        Stack<String> operationStack = new Stack<>();

        for (int expIndex = 0; expIndex < expression.length() - 1; expIndex++) {
            String currentSymbol = expression.substring(expIndex, expIndex + 1);
            if (!isOperator(currentSymbol)) {
                int doubleIndex = expIndex;
                String doubleSubstring;
                while (!isOperator(expression.substring(doubleIndex, doubleIndex + 1))
                        && doubleIndex < expression.length() - 1) {
                    doubleIndex++;
                }

                doubleSubstring = expression.substring(expIndex, doubleIndex);

                expressionRPN = expressionRPN.concat(doubleSubstring + ' ');
                System.out.println(doubleSubstring);
                expIndex = doubleIndex - 1;
            } else {
                if (currentSymbol.equals(CLOSE_BRACKET)) {
                    while (!operationStack.empty() && !operationStack.peek().equals(OPEN_BRACKET)) {
                        System.out.println("CLOSE B");
                        expressionRPN = expression.concat(operationStack.pop() + ' ');
                    }

                    operationStack.pop();
                }

                if (!operationStack.empty()
                        && (precedenceOf(currentSymbol) == precedenceOf(operationStack.peek()))) {
                    expressionRPN = expressionRPN.concat(operationStack.pop() + ' ');
                }
                /*
                    operationStack.push(currentSymbol);
                }

                if (precedenceOf(currentSymbol) > precedenceOf(operationStack.peek())) {
                    operationStack.push(currentSymbol);
                }*/

                operationStack.push(currentSymbol);
                System.out.println(operationStack.peek());
            }
        }

        while (!operationStack.empty()) {
            expressionRPN = expressionRPN.concat(operationStack.pop() + ' ');
        }

        System.out.println("SOURCE " + expression);
        System.out.println("RPN " + expressionRPN);
        return expressionRPN;
    }

    private static int precedenceOf(String operator) {
        switch (operator) {
            case OperatorFactory.PLUS: {
                return 2;
            }
            case OperatorFactory.MINUS: {
                return 2;
            }
            case OperatorFactory.DIVIDE: {
                return 3;
            }
            case OperatorFactory.MULTIPLICATE: {
                return 3;
            }
            case OperatorFactory.MOD: {
                return 4;
            }
        }

        return 0;
    }

    private static boolean isOperator(String operator) {
        return operator.equals(OperatorFactory.PLUS)
                || operator.equals(OperatorFactory.MINUS)
                || operator.equals(OperatorFactory.DIVIDE)
                || operator.equals(OperatorFactory.MULTIPLICATE)
                || operator.equals(OperatorFactory.MOD)
                || operator.equals(OperatorFactory.SQRT)
                || operator.equals(OPEN_BRACKET)
                || operator.equals(CLOSE_BRACKET);
    }
}
