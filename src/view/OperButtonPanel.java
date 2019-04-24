package view;

import controller.RPNExpressionConverter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import model.OperatorFactory;


public class OperButtonPanel {
    public static final String OPEN_BRACKET = "(";
    public static final String CLOSE_BRACKET = ")";
    public static final String CLEAR = "C";
    public static final String BACKSPACE = "←";
    public static final String DOT = ".";
    public static final String EQUAL = "=";
    public static final String REVERSE = "1/x";
    public static final String LOG = "log";
    public static final String LN = "ln";
    public static final String N_FACTORIAL = "n!";

    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String FOUR = "4";
    public static final String FIVE = "5";
    public static final String SIX = "6";
    public static final String SEVEN = "7";
    public static final String EIGHT = "8";
    public static final String NINE = "9";
    public static final String ZERO = "0";

    private static final String BUTTON_STYLE =
            "-fx-pref-width: 42; " +
            "-fx-pref-height: 42; " +
            "-fx-font-size: 15";


    private TextField expRowTextField;

    private GridPane gridPane;


    public OperButtonPanel(ExpressionRowPanel expressionRowPanel) {
        expRowTextField = expressionRowPanel.getExpressionRowTextField();
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
        Button reverse = new Button(REVERSE);
        Button sqrt = new Button(OperatorFactory.SQRT);
        Button plus = new Button(OperatorFactory.PLUS);
        Button minus = new Button(OperatorFactory.MINUS);
        Button divide = new Button(OperatorFactory.DIVIDE);
        Button multiplicate = new Button(OperatorFactory.MULTIPLICATE);
        Button mod = new Button(OperatorFactory.MOD);

        reverse.setOnAction(reverseEventHandler);
        sqrt.setOnAction(sqrtEventHandler);
        plus.setOnAction(plusEventHandler);
        minus.setOnAction(minusEventHandler);
        divide.setOnAction(divideEventHandler);
        multiplicate.setOnAction(multiplicateEventHandler);
        mod.setOnAction(modEventHandler);

        Button openBracket = new Button(OPEN_BRACKET);
        Button closeBracket = new Button(CLOSE_BRACKET);
        Button clear = new Button(CLEAR);
        Button backspace = new Button(BACKSPACE);
        Button dot = new Button(DOT);
        Button equal = new Button(EQUAL);

        openBracket.setOnAction(openBracketEventHandler);
        closeBracket.setOnAction(closeBracketEventHandler);
        clear.setOnAction(clearEventHandler);
        backspace.setOnAction(backspaceEventHandler);
        dot.setOnAction(dotEventHandler);
        equal.setOnAction(equalEventHandler);

        Button one = new Button(ONE);
        Button two = new Button(TWO);
        Button three = new Button(THREE);
        Button four = new Button(FOUR);
        Button five = new Button(FIVE);
        Button six = new Button(SIX);
        Button seven = new Button(SEVEN);
        Button eight = new Button(EIGHT);
        Button nine = new Button(NINE);
        Button zero = new Button(ZERO);

        one.setOnAction(oneEventHandler);
        two.setOnAction(twoBracketEventHandler);
        three.setOnAction(threeEventHandler);
        four.setOnAction(fourEventHandler);
        five.setOnAction(fiveEventHandler);
        six.setOnAction(sixEventHandler);
        seven.setOnAction(sevenEventHandler);
        eight.setOnAction(eightEventHandler);
        nine.setOnAction(nineEventHandler);
        zero.setOnAction(zeroEventHandler);

        reverse.setStyle(BUTTON_STYLE);
        sqrt.setStyle(BUTTON_STYLE);
        plus.setStyle(BUTTON_STYLE);
        minus.setStyle(BUTTON_STYLE);
        divide.setStyle(BUTTON_STYLE);
        multiplicate.setStyle(BUTTON_STYLE);
        mod.setStyle(BUTTON_STYLE);
        openBracket.setStyle(BUTTON_STYLE);
        closeBracket.setStyle(BUTTON_STYLE);
        clear.setStyle(BUTTON_STYLE);
        backspace.setStyle(BUTTON_STYLE);
        dot.setStyle(BUTTON_STYLE);
        equal.setStyle(BUTTON_STYLE);
        one.setStyle(BUTTON_STYLE);
        two.setStyle(BUTTON_STYLE);
        three.setStyle(BUTTON_STYLE);
        four.setStyle(BUTTON_STYLE);
        five.setStyle(BUTTON_STYLE);
        six.setStyle(BUTTON_STYLE);
        seven.setStyle(BUTTON_STYLE);
        eight.setStyle(BUTTON_STYLE);
        nine.setStyle(BUTTON_STYLE);
        zero.setStyle(BUTTON_STYLE);

        gridPane.add(backspace, 0,0);
        gridPane.add(clear, 1,0);
        gridPane.add(openBracket, 2,0);
        gridPane.add(closeBracket, 3,0);
        gridPane.add(mod, 4,0);
        gridPane.add(reverse, 3,1);
        gridPane.add(one, 0,1);
        gridPane.add(two, 1,1);
        gridPane.add(three, 2,1);
        gridPane.add(plus, 4,1);
        gridPane.add(sqrt, 3,2);
        gridPane.add(four, 0,2);
        gridPane.add(five, 1,2);
        gridPane.add(six, 2,2);
        gridPane.add(minus, 4,2);
        gridPane.add(seven, 0,3);
        gridPane.add(eight, 1,3);
        gridPane.add(nine, 2,3);
        gridPane.add(divide, 4,3);
        gridPane.add(dot, 0,4);
        gridPane.add(zero, 1,4);
        gridPane.add(equal, 2,4);
        gridPane.add(multiplicate, 4,4);
    }

    /*
     *      Event handlers
     */

    private EventHandler<ActionEvent> oneEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + ONE);
    };

    private EventHandler<ActionEvent> twoBracketEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + TWO);
    };

    private EventHandler<ActionEvent> threeEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + THREE);
    };

    private EventHandler<ActionEvent> fourEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + FOUR);
    };

    private EventHandler<ActionEvent> fiveEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + FIVE);
    };

    private EventHandler<ActionEvent> sixEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + SIX);
    };

    private EventHandler<ActionEvent> sevenEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + SEVEN);
    };

    private EventHandler<ActionEvent> eightEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + EIGHT);
    };

    private EventHandler<ActionEvent> nineEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + NINE);
    };

    private EventHandler<ActionEvent> zeroEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + ZERO);
    };

    private EventHandler<ActionEvent> openBracketEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + OPEN_BRACKET);
    };

    private EventHandler<ActionEvent> closeBracketEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + CLOSE_BRACKET);
    };

    private EventHandler<ActionEvent> clearEventHandler = e -> {
        expRowTextField.setText("");
    };

    private EventHandler<ActionEvent> backspaceEventHandler = e -> {
        try {
            expRowTextField.setText(expRowTextField.getText().substring(0, expRowTextField.getText().length() - 1));
        } catch (StringIndexOutOfBoundsException ex) {
            return;
        }
    };

    private EventHandler<ActionEvent> dotEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + DOT);
    };

    private EventHandler<ActionEvent> equalEventHandler = e -> {
        try {
            RPNExpressionConverter.convert(expRowTextField.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    };

    private EventHandler<ActionEvent> reverseEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + REVERSE.substring(0, 2));
    };

    private EventHandler<ActionEvent> sqrtEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + OperatorFactory.SQRT);
    };

    private EventHandler<ActionEvent> plusEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + OperatorFactory.PLUS);
    };

    private EventHandler<ActionEvent> minusEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + OperatorFactory.MINUS);
    };

    private EventHandler<ActionEvent> divideEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + OperatorFactory.DIVIDE);
    };

    private EventHandler<ActionEvent> multiplicateEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + OperatorFactory.MULTIPLICATE);
    };

    private EventHandler<ActionEvent> modEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + OperatorFactory.MOD);
    };
}
