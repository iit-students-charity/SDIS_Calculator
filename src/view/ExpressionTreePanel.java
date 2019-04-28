package view;

import controller.ExpressionTreeController;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.*;


public class ExpressionTreePanel {
    private static final int PANEL_WIDTH = 170;

    private ExpressionTreeController expressionTreeController;

    private TreeView<ExpressionTreeNode> expressionTreeView;
    private ExpressionRowPanel expressionRowPanel;
    private TextField result;

    private GridPane gridPane;


    public ExpressionTreePanel(ExpressionRowPanel expressionRowPanel,
                               ExpressionTreeController expressionTreeController) {
        this.expressionTreeController = expressionTreeController;

        expressionTreeView = new TreeView<>();
        this.expressionRowPanel = expressionRowPanel;

        gridPane = new GridPane();

        configureGridPane();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    /*
     *      Configs
     */

    private void configureGridPane() {
        result = new TextField();

        result.setEditable(false);
        result.setFocusTraversable(false);
        result.setFont(new Font("Segoe UI", 18));
        result.setPrefHeight(50);
        result.setPrefWidth(PANEL_WIDTH);

        expressionTreeView.setEditable(false);
        expressionTreeView.setFocusTraversable(false);
        expressionTreeView.setPrefHeight(315);
        expressionTreeView.setPrefWidth(PANEL_WIDTH);

        gridPane.add(result, 0, 0);
        gridPane.add(expressionTreeView, 0, 1);
    }

    public void construct() {
        expressionTreeView.setRoot(new TreeItem<>(expressionTreeController.getRoot()));

        recursiveInitialize(expressionTreeController.getRoot(), expressionTreeView.getRoot());

        result.setText(expressionTreeController.result().source());
    }

    private void recursiveInitialize(ExpressionTreeNode expressionTreeNode, TreeItem<ExpressionTreeNode> treeItem) {
        treeItem.expandedProperty().addListener(e -> {
            ExpressionTreeNode replacing;

            if (treeItem.isExpanded()) {
                treeItem.getValue().setState(ExpressionTreeNode.State.OPERATOR);

                if (treeItem.getValue().getOperator() != null) {
                    replacing = new ExpressionTreeNode((Operator) OperatorFactory.getOperator((
                            (Token) treeItem.getValue().getOperator()).source()
                    ));
                } else {
                    replacing = treeItem.getValue();
                }
            } else {
                treeItem.getValue().setState(ExpressionTreeNode.State.VALUE);
                replacing = new ExpressionTreeNode(new Operand(treeItem.getValue().getValue().value()));
            }

            expressionTreeController.replace(expressionTreeController.getRoot(), treeItem.getValue(), replacing);
            expressionRowPanel.getExpressionRowTextField().setText(
                    expressionTreeController.infix().toString()
            );
        });

        treeItem.setExpanded(true);

        // не баг, а фича
        if (expressionTreeNode.getRightOperand() != null) {
            TreeItem<ExpressionTreeNode> right = new TreeItem<>(expressionTreeNode.getRightOperand());

            treeItem.getChildren().add(right);
            recursiveInitialize(expressionTreeNode.getRightOperand(), right);
        }

        if (expressionTreeNode.getLeftOperand() != null) {
            TreeItem<ExpressionTreeNode> left = new TreeItem<>(expressionTreeNode.getLeftOperand());

            treeItem.getChildren().add(left);
            recursiveInitialize(expressionTreeNode.getLeftOperand(), left);
        }
    }
}
