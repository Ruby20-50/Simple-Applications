package com.example.gui2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CurrencyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(CurrencyApplication.class.getResource("currencyConvert-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Currency converter");
        stage.setScene(scene);
        stage.show();
        // alternative code when I use pure java approach
      /* CurrencyModel model = new CurrencyModel();
       CurrencyConverterView view = new CurrencyConverterView();
       CurrencyController1 controller1 = new CurrencyController1(model, view);

       stage.setTitle("Currency Converter");
       stage.setScene(view.createScene());
        stage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }
}