package com.example.gui2;

public class CurrencyController1 {

    private CurrencyModel model;
    private CurrencyConverterView view;
    public CurrencyController1(CurrencyModel model, CurrencyConverterView view){
        this.model = model;
        this.view = view;

        initializeView();
        setupEventListeners();
    }
    private void initializeView(){
        view.getSourceCurrency().getItems().addAll(model.getAvailableCurrencies());
        view.getTargetCurrency().getItems().addAll(model.getAvailableCurrencies());
        view.getSourceCurrency().setValue("EUR");
        view.getTargetCurrency().setValue("USD");

    }
    private void setupEventListeners(){
        view.getSwap().setOnAction(e->handleSwap());

        view.getAmountField().textProperty().addListener((observable,oldValue,newValue)->{
           if(!newValue.trim().isEmpty())
               handleConvert();
           else{
               view.getResultLabel().setText("");
           }
        });

        view.getSourceCurrency().valueProperty().addListener((observable,oldValue,newValue)->{
               handleConvert();
        });
        view.getTargetCurrency().valueProperty().addListener((observalbe,oldValue,newValue)->{
           handleConvert();
        });
    }
    public void handleConvert(){
        try{
            String amountText = view.getAmountField().getText();
            String sourceCurrency = view.getSourceCurrency().getValue().toString();
            String targetCurrency = view.getTargetCurrency().getValue().toString();
            if(sourceCurrency == null || targetCurrency == null){
                view.getResultLabel().setText("Please choose currency!");
                return;
            }

            double amount = Double.parseDouble(amountText);

            if(amount < 0 ){
                view.getResultLabel().setText("amount must be positive!");
                return;
            }
            double result = model.convert(amount,sourceCurrency,targetCurrency);
            view.getResultLabel().setText(String.format("%.2f %s",result, targetCurrency));
        }catch(NumberFormatException e){
            view.getResultLabel().setText("Invalid Input! please enter only numbers");
        }catch(IllegalArgumentException e){
            view.getResultLabel().setText("Fehler: " + e.getMessage());
        }
    }

    private void handleSwap(){
        String value1 = view.getTargetCurrency().getValue().toString();
        String value2 = view.getSourceCurrency().getValue().toString();
        view.getSourceCurrency().setValue(value1);
        view.getTargetCurrency().setValue(value2);
    }
}
