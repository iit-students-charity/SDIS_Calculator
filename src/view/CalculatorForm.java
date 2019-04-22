package view;

import javafx.scene.layout.GridPane;

public class CalculatorForm {
    private ExpressionRowPanel expressionRowPanel;
    private OperButtonPanel operButtonPanel;

    private GridPane gridPane;


    public CalculatorForm() {
        expressionRowPanel = new ExpressionRowPanel();
        operButtonPanel = new OperButtonPanel(expressionRowPanel);

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
        gridPane.add(expressionRowPanel.getExpRowScrollPane(), 0, 0);
        gridPane.add(operButtonPanel.getGridPane(), 0, 1);
    }
}
