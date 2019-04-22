package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.CalculatorForm;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new CalculatorForm().getGridPane());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
