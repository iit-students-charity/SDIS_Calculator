package view;

import javafx.scene.control.TreeView;
import model.ExpressionTree;
import model.ExpressionTreeNode;


public class ExpressionTreePanel {
    private ExpressionTree expressionTree;

    private TreeView<ExpressionTreeNode> expressionTreeView;


    public ExpressionTreePanel() {
        expressionTreeView = new TreeView<>();
        configureTree();
    }

    public TreeView<ExpressionTreeNode> getExpressionTree() {
        return expressionTreeView;
    }

    /*
     *      Configs
     */

    private void configureTree() {
        expressionTreeView.setEditable(false);
        expressionTreeView.setPrefWidth(200);
    }

    private void setExpressionTree(ExpressionTree expressionTree) {
        this.expressionTree = expressionTree;
    }
}
