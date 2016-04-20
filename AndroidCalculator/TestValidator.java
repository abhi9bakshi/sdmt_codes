package com.pccoe.cl3.calculator;

public class TestValidator {
    public boolean isNumOrDecimal(CharSequence s){
        if(s.equals("1") || s.equals("2") || s.equals("3") ||
           s.equals("4") || s.equals("5") || s.equals("6") ||
           s.equals("7") || s.equals("8") || s.equals("9") ||
           s.equals("0") || s.equals("."))
            return true;
        else
            return false;
    }

    public boolean isOperator(CharSequence s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("="))
            return true;
        else
            return false;
    }

    public boolean isTrig(CharSequence s){
        if(s.equals("sin") || s.equals("cos") || s.equals("tan"))
            return true;
        else
            return false;
    }

    public boolean isMem(CharSequence s){
        if(s.equals("M+") || s.equals("M-") || s.equals("MRC"))
            return true;
        else
            return false;
    }
}
