package com.example.lengthapplication.exceptions;

public class ConversionException extends RuntimeException {
    double invalidValue;
    String invalidUnit;
    public ConversionException(String message){
        super(message);

    }
    public ConversionException(String message, double invalidValue, String invalidUnit){
        super(message);
        this.invalidValue = invalidValue;
        this.invalidUnit = invalidUnit;
    }

    public double getInvalidValue() {
        return invalidValue;
    }
    public String getInvalidUnit(){
        return invalidUnit;
    }
}