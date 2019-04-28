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

        expressionTreeView.setOnMouseClicked(e -> {

        });

        expressionTreeView.getRoot().setExpanded(true);
        result.setText(expressionTreeController.result().source());
        expressionRowPanel.getExpressionRowTextField().setText(
                expressionTreeController.getExpressionTree().toInfix().toString()
        );
    }

    private void recursiveInitialize(ExpressionTreeNode expressionTreeNode, TreeItem<ExpressionTreeNode> treeItem) {
        treeItem.expandedProperty().addListener(e -> {
            ExpressionTreeNode replacing = new ExpressionTreeNode(new Operand(treeItem.getValue().value().value()));

            if (treeItem.isExpanded()) {
                treeItem.getValue().setState(ExpressionTreeNode.State.OPERATOR);
            } else {
                treeItem.getValue().setState(ExpressionTreeNode.State.VALUE);
                expressionTreeController.replace(expressionTreeController.getRoot(), treeItem.getValue(), replacing);
            }
        });

        treeItem.setExpanded(true);

        if (expressionTreeNode.getLeftOperand() != null) {
            TreeItem<ExpressionTreeNode> left = new TreeItem<>(expressionTreeNode.getLeftOperand());

            treeItem.getChildren().add(left);
            recursiveInitialize(expressionTreeNode.getLeftOperand(), left);
        }

        if (expressionTreeNode.getRightOperand() != null) {
            TreeItem<ExpressionTreeNode> right = new TreeItem<>(expressionTreeNode.getRightOperand());

            treeItem.getChildren().add(right);
            recursiveInitialize(expressionTreeNode.getRightOperand(), right);
        }
    }
}
