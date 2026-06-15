package com.example.lengthapplication;

import com.example.lengthapplication.exceptions.ConversionException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;



public class LengthController implements Initializable {
    @FXML
    private TextField inputTxt;
    @FXML
    private ComboBox<String> sUnit;
    @FXML
    private ComboBox<String> tUnit;
    @FXML
    private Button swp;
    @FXML
    private Label result;
    private LengthModel model;
    private LengthConverter converter;
    @FXML
    public void initialize(URL url, ResourceBundle resourcebndl){
        model = new LengthModel();
        sUnit.getItems().addAll(model.getAvailableUnites());
        tUnit.getItems().addAll(model.getAvailableUnites());

        sUnit.setValue("Meter");
        tUnit.setValue("Feet");

    }
    @FXML
    public void onConvertAction(){
       handleValueChange();

    }

    @FXML
    protected void onSwpClick() {
        String tepmValue = sUnit.getValue();
        sUnit.setValue(tUnit.getValue());
        tUnit.setValue(tepmValue);
        onConvertAction();
    }
    private void handleValueChange(){
        try {
            if(inputTxt.getText().isEmpty() || sUnit == null || tUnit == null)
                result.setText("Invalid input!");
            Double value = Double.parseDouble(inputTxt.getText());
            String srcUnit = sUnit.getValue();
            String tgtUnit = tUnit.getValue();
            double converted = model.convert(value, srcUnit, tgtUnit);
            result.setText(String.format("%.2f %s", converted, tgtUnit));
        }catch(NumberFormatException e){
            result.setText("Invalid Input!");
        }catch (ConversionException e){
            result.setText(e.getMessage());
        }
    }
    private void updateResult(double value){
        result.setText(formatResult(value));
    }
    private String formatResult(double value){

        if(value == Math.floor(value))
            return String.valueOf((long) value);

        return String.format("%.6f", value);
    }
}