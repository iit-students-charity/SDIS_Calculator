package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.OperatorFactory;


public class OperButtonPanel {
    public static final String OPEN_BRACKET = "(";
    public static final String CLOSE_BRACKET = ")";
    public static final String CLEAR = "C";
    public static final String BACKSPACE = "←";
    public static final String DOT = ".";
    public static final String EQUAL = "=";

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
        Button reverse = new Button(OperatorFactory.REVERSE);
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

        gridPane.add(backspace, 0,0);
        gridPane.add(clear, 1,0);
        gridPane.add(openBracket, 2,0);
        gridPane.add(closeBracket, 3,0);
        gridPane.add(new Label("WHAT"), 4,0);
        gridPane.add(one, 0,1);
        gridPane.add(two, 1,1);
        gridPane.add(three, 2,1);
        gridPane.add(new Label("WHAT"), 3,1);
        gridPane.add(new Label("WHAT"), 4,1);
        gridPane.add(four, 0,2);
        gridPane.add(five, 1,2);
        gridPane.add(six, 2,2);
        gridPane.add(new Label("WHAT"), 3,2);
        gridPane.add(new Label("WHAT"), 4,2);
        gridPane.add(seven, 0,3);
        gridPane.add(eight, 1,3);
        gridPane.add(nine, 2,3);
        gridPane.add(new Label("WHAT"), 3,3);
        gridPane.add(new Label("WHAT"), 4,3);
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
        expRowTextField.setText(expRowTextField.getText() + CLEAR);
    };

    private EventHandler<ActionEvent> backspaceEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + BACKSPACE);
    };

    private EventHandler<ActionEvent> dotEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + DOT);
    };

    private EventHandler<ActionEvent> equalEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + EQUAL);
    };

    private EventHandler<ActionEvent> reverseEventHandler = e -> {
        expRowTextField.setText(expRowTextField.getText() + OperatorFactory.REVERSE);
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
