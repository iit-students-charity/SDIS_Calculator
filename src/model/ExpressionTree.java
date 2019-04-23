package model;


public class ExpressionTree {
    private ExpressionTreeNode root;


    public ExpressionTree() {
        root = new ExpressionTreeNode();
    }

    public void setRoot(ExpressionTreeNode root) {
        this.root = root;
    }
}
