package com.taschenrechner_u9;

public class CalculatorModel {

    public double add(double number1, double number2) {
        return number1 + number2;
    }
    public double substract(double number1, double number2){
        return number1 - number2;
    }
    public double division(double number1, double number2){
        if(number2 == 0)
            throw new ArithmeticException("Divion through 0 is unallowed");
        return number1 /number2;
    }
    public double multiplication(double number1, double number2){
        return number1 * number2;
    }
//    public int exponent(int number1, int number2){
//        return number1.Math.getExponent(number1);
//    }
}
