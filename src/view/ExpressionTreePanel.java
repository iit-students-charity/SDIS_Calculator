package view;

import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.ExpressionTreeNode;


public class ExpressionTreePanel {
    private static final int PANEL_WIDTH = 200;

    private TreeView<ExpressionTreeNode> expressionTreeView;

    private GridPane gridPane;


    public ExpressionTreePanel() {
        expressionTreeView = new TreeView<>();

        gridPane = new GridPane();

        configureGridPane();
    }

    public TreeView<ExpressionTreeNode> getExpressionTree() {
        return expressionTreeView;
    }

    /*
     *      Configs
     */

    private void configureGridPane() {
        TextField result = new TextField();

        result.setEditable(false);
        result.setFont(new Font("Segoe UI", 18));
        result.setPrefHeight(50);
        result.setPrefWidth(PANEL_WIDTH);
        expressionTreeView.setEditable(false);

        gridPane.add(result, 0, 0);

    }
}
