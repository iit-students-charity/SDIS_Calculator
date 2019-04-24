package controller;

import model.ExpressionTree;


public class ExpressionTreeController {
    private ExpressionTree expressionTree;


    public ExpressionTreeController(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }

    public void parse(String expression) {
        //String expressionRPN = RPNExpressionConverter.convert(expression);
        //expressionTree.setRoot(ExpressionParser.parse(expressionRPN));
    }
}
