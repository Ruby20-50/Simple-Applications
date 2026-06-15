package com.taschenrechner_u9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view ;
    public CalculatorController(CalculatorModel model, CalculatorView view){
        this.model = model;
        this.view = view;

        onAddButtonClick();
        onMinusButtonClick();
        onDivisionButtonClick();
        onMultiplicationButtonClick();
        onClearButtonClick();
//        onExponentButtonClick();
    }
    private void onAddButtonClick(){
        view.getAddButton().setOnAction(event -> {
            try{
                double number1 = Double.parseDouble(view.getNumberField1().getText());
                double number2 = Double.parseDouble(view.getNumberField2().getText());
                double rslt = model.add(number1 , number2);
                view.getResultLabel().setText(String.valueOf(rslt));

            } catch (NumberFormatException e){
                view.getResultLabel().setText("please enter a valid Number");

            }
        });
    }
    private void onMinusButtonClick(){
        view.getMinusButton().setOnAction(event ->{
            try{
                double number1 = Double.parseDouble(view.getNumberField1().getText());
                double number2 = Double.parseDouble(view.getNumberField2().getText());
                double rslt = model.substract(number1,number2);
                view.getResultLabel().setText(String.valueOf(rslt));
            }catch(NumberFormatException e){
                view.getResultLabel().setText("please enter a valid Number");
            }
        });
    }
    private void onDivisionButtonClick(){
        view.getDivisionButton().setOnAction(event ->{
            try{
                double number1 = Double.parseDouble(view.getNumberField1().getText());
                double number2 = Double.parseDouble(view.getNumberField2().getText());
                double rslt = model.division(number1,number2);
                view.getResultLabel().setText(String.valueOf(rslt));
            }catch(ArithmeticException e){
                view.getResultLabel().setText("Division through zero is not allowed!");
            }
            catch(NumberFormatException e){
                view.getResultLabel().setText("please enter a valid Number");
            }
        });
    }
    private void onMultiplicationButtonClick(){
        view.getMultiplicationButton().setOnAction(event ->{
            try{
                double number1 = Double.parseDouble(view.getNumberField1().getText());
                double number2 = Double.parseDouble(view.getNumberField2().getText());
                double rslt = model.multiplication(number1,number2);
                view.getResultLabel().setText(String.valueOf(rslt));
            }catch(NumberFormatException e){
                view.getResultLabel().setText("please enter a valid Number");
            }
        });
    }
    private void onClearButtonClick(){
        view.getClear().setOnAction(event ->{
                view.getNumberField1().setText("");
                view.getNumberField2().setText("");
        });
    }
//    private void onExponentButtonClick(){
//        view.getExponentButton().setOnAction(event ->{
//            try{
//                int number1 = Integer.parseInt(view.getNumberField1().getText());
//                int number2 = Integer.parseInt(view.getNumberField2().getText());
//                int rslt = model.exponent(number1,number2);
//                view.getResultLabel().setText(String.valueOf(rslt));
//            }catch(NumberFormatException e){
//                view.getResultLabel().setText("please enter a valid Number");
//            }
//        });
//    }


}