package com.taschenrechner_u9;

import javafx.application.Application;

import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
      CalculatorModel model = new CalculatorModel();
      CalculatorView view = new CalculatorView();
      CalculatorController controller = new CalculatorController(model, view);

        stage.setTitle("My Calculator");
        stage.setScene(view.createScene());
        stage.show();

    }


    public static void main(String[] args) {
//        CalculatorModel mod = new CalculatorModel();
//        System.out.println(mod.exponent(2,3));
        launch();


    }
}