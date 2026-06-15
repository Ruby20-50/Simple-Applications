package com.example.lengthapplication;

import com.example.lengthapplication.exceptions.ConversionException;

import java.util.ArrayList;
import java.util.List;

public class LengthModel {
    private LengthConverter converter;
    public LengthModel(){
        converter = new LengthConverter();
    }
    public double convert(double value, String fromUnit, String toUnit) throws ConversionException {
        validateInput(value, fromUnit, toUnit);
        String key = fromUnit + "-" + toUnit;
        Double factor = converter.getConversionFactor(key);

        return value * factor;
    }
    public List<String> getAvailableUnites(){
        List<String> unites = new ArrayList<>();
        unites.add("Meter");
        unites.add("Yard");
        unites.add("Feet");
        unites.add("Inch");

        return unites;
    }
    private void validateInput(double value, String fromUnit, String toUnit) throws ConversionException{
        if(fromUnit.equals(toUnit))
            return;
        String key = fromUnit + "-" + toUnit;
        Double factor = converter.getConversionFactor(key);
        if(value < 0)
            throw new ConversionException("Value cannot be negative!");
        if(factor == null)
            throw new ConversionException("No Information about factor"+key);

    }

}
