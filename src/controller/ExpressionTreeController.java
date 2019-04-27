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
            System.out.println("Cannot parse expression due to next errors: " + ex.getCause().getMessage());
            return;
        }

        expressionTree = new ExpressionTree(expressionRPN);
        System.out.println(expressionTree.toInfix());
    }

    public double valueOf(Token token) throws Exception {
        if (token instanceof Operator) {
            return ((Operator) token).result();
        }

        if (token instanceof Operand) {
            return ((Operand) token).value();
        }

        throw new Exception("Token is not an operator or operand");
    }

    public String sourceOf(Token token) {
        return token.source();
    }
}
