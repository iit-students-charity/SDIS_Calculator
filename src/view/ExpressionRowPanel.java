package view;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class ExpressionRowPanel {
    private TextField expressionRowTextField;

    private ScrollPane expRowScrollPane;


    public ExpressionRowPanel() {
        expressionRowTextField = new TextField();
        configureExpressionRowTextField();
        expRowScrollPane = new ScrollPane();
        configureExpRowScrollPane();
    }

    public ScrollPane getExpRowScrollPane() {
        return expRowScrollPane;
    }

    public TextField getExpressionRowTextField() {
        return expressionRowTextField;
    }

    /*
     *      Configs
     */

    private void configureExpressionRowTextField() {
        expressionRowTextField.setEditable(false);
        expressionRowTextField.setFont(new Font("Cambria Math", 20));
    }

    private void configureExpRowScrollPane() {
        expRowScrollPane.setContent(expressionRowTextField);
        expRowScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        expRowScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        expRowScrollPane.setPannable(true);
    }


}
