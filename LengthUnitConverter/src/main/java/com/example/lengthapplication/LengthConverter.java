package com.example.lengthapplication;

import com.example.lengthapplication.exceptions.ConversionException;

import java.util.HashMap;
import java.util.Map;

public class LengthConverter {
    private Map<String, Double> conversionFactors;
    public LengthConverter(){
       conversionFactors = new HashMap<>();
       initializeFactors();
    }
    private void initializeFactors(){
        conversionFactors.put("Meter-Feet", 3.28084);
        conversionFactors.put("Meter-Yard", 1.09361);
        conversionFactors.put("Meter-Inch", 39.37014);
        conversionFactors.put("Yard-Meter",  0.9144);
        conversionFactors.put("Yard-Inch", 36.0);
        conversionFactors.put("Yard-Feet", 3.0);
        conversionFactors.put("Inch-Feet", 0.08333333);
        conversionFactors.put("Inch-Yard", 0.02778);
        conversionFactors.put("Inch-Meter", 0.0254);
        conversionFactors.put("Feet-Meter", 0.3048);
        conversionFactors.put("Feet-Yard",0.3333333 );
        conversionFactors.put("Feet-Inch", 12.0);

    }
    public double getConversionFactor(String key){
        if(!conversionFactors.containsKey(key))
            throw new ConversionException("Invalid unit combination: "+ key);
        return conversionFactors.get(key);
    }
    public double meterToFeet(double value){
        return value * conversionFactors.get("Meter-Feet");
    }
    public double meterToYard(double value){
        return value * conversionFactors.get("Meter-Yard");
    }
    public double meterToInch(double value){
        return value * conversionFactors.get("Meter-Inch");
    }
    public double feetToInch(double value){
        return value * conversionFactors.get("Feet-Inch");
    }
    public double feetToYard(double value){
        return value * conversionFactors.get("Feet-Yard");
    }
    public double feetToMeter(double value){
        return value * conversionFactors.get("Feet-Meter");
    }
    public double yardToInch(double value){
        return value * conversionFactors.get("Yard-Inch");
    }
    public double yardToFeet(double value){
        return value * conversionFactors.get("Yard-Feet");
    }
    public double yardToMeter(double value){
        return value * conversionFactors.get("Yard-Meter");
    }
    public double inchToFeet(double value){
        return value * conversionFactors.get("Inch-Feet");
    }
    public double inchToYard(double value){
        return value * conversionFactors.get("Inch-Yard");
    }
    public double inchToMeter(double value){
        return value * conversionFactors.get("Inch-Meter");
    }
}
