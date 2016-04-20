package com.pccoe.cl3.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout calculatorGrid = (GridLayout)findViewById(R.id.calculatorGrid);
        int count = calculatorGrid.getChildCount();
        ButtonClickHandler buttonClickHandler = new ButtonClickHandler();
        for(int i=0; i<count;i++){
            View v = calculatorGrid.getChildAt(i);
            if(v instanceof Button){
                v.setOnClickListener(buttonClickHandler);
            }
        }
    }

    private class ButtonClickHandler implements View.OnClickListener{

        //Class objects
        TextView tvOutputScreen = (TextView)findViewById(R.id.tvOutputScreen);
        TestValidator testValidator = new TestValidator();

        //Variables
        double result = 0;
        double memory = 0;
        String operator = "nil";
        String prevOperator = "nil";
        boolean flagCheck = false;

        @Override
        public void onClick(View v) {

            //Clear button
            if(v.getId() == R.id.btnAllClear) {
                tvOutputScreen.setText("0");
                operator = "nil";
                prevOperator = "nil";
                result = 0;
                flagCheck = false;
            }


            //Check for operation
            if(operator!="nil"){
                tvOutputScreen.setText("");
                operator = "nil";
                flagCheck = true;
            }

            //Numerical Part
            if (testValidator.isNumOrDecimal(((Button) v).getText())) {
                //Reset the flag for next use if set
                if(flagCheck == true){
                    tvOutputScreen.setText("");
                    flagCheck = false;
                }

                //This is to prevent appending the values you enter after 0
                if(tvOutputScreen.getText().equals("0"))
                    tvOutputScreen.setText("");

                //Check if decimal button is pressed
                if(((Button) v).getText().equals(".")){
                    if(tvOutputScreen.getText().toString().contains(".")){
                        //do nothing
                    }
                    else{
                        tvOutputScreen.setText(tvOutputScreen.getText().toString() + ((Button) v).getText());
                    }
                }
                else {
                    tvOutputScreen.setText(tvOutputScreen.getText().toString() + ((Button) v).getText());
                }
            }

            //Operator Part
            else if (testValidator.isOperator(((Button) v).getText())) {

                //When the operator is called multiple times
                if(flagCheck == true){
                    prevOperator = ((Button) v).getText().toString();
                    tvOutputScreen.setText(String.valueOf(result));
                }
                //When no value is present
                else if(result == 0 || prevOperator == "nil"){
                    result = Double.parseDouble(tvOutputScreen.getText().toString());
                    operator = ((Button) v).getText().toString();
                    prevOperator = operator;
                    tvOutputScreen.setText(String.valueOf(result));
                }
                //After some value is present in result
                else{
                    operator = prevOperator;

                    if(operator.equals("+"))
                        result = result + Double.parseDouble(tvOutputScreen.getText().toString());
                    else if(operator.equals("-"))
                        result = result - Double.parseDouble(tvOutputScreen.getText().toString());
                    else if(operator.equals("*"))
                        result = result * Double.parseDouble(tvOutputScreen.getText().toString());
                    else if(operator.equals("/"))
                        result = result / Double.parseDouble(tvOutputScreen.getText().toString());

                    prevOperator = ((Button) v).getText().toString();
                    tvOutputScreen.setText(String.valueOf(result));
                }
            }
            //Trignometry Part
            else if(testValidator.isTrig(((Button) v).getText())){

                //Assign value of button to operator
                operator = ((Button)v).getText().toString();

                //Check if outputwindow is blank
                if(tvOutputScreen.getText().toString().isEmpty())
                    tvOutputScreen.setText(String.valueOf(result));

                //Reset flag if set
                if(flagCheck == true){
                    flagCheck = false;
                    prevOperator = "nil";
                }

                if(((Button) v).getText().toString().equals("sin")){
                    tvOutputScreen.setText(String.valueOf(
                            Math.sin(
                                    Math.toRadians(
                                            Double.parseDouble(tvOutputScreen.getText().toString())
                                    )
                            )
                    ));
                }else if(((Button) v).getText().toString().equals("cos")){
                    tvOutputScreen.setText(String.valueOf(
                            Math.cos(
                                    Math.toRadians(
                                            Double.parseDouble(tvOutputScreen.getText().toString())
                                    )
                            )
                    ));
                }else if(((Button) v).getText().toString().equals("tan")){
                    tvOutputScreen.setText(String.valueOf(
                            Math.tan(
                                    Math.toRadians(
                                            Double.parseDouble(tvOutputScreen.getText().toString())
                                    )
                            )
                    ));
                }
            }
            //Sqrt Part
            else if(((Button) v).getText().toString().equals("sqrt")) {

                //Assign value of button to operator
                operator = ((Button)v).getText().toString();

                //Check if outputwindow is blank
                if(tvOutputScreen.getText().toString().isEmpty())
                    tvOutputScreen.setText(String.valueOf(result));

                //Reset flag if set
                if(flagCheck == true){
                    flagCheck = false;
                    prevOperator = "nil";
                }

                tvOutputScreen.setText(String.valueOf(
                        Math.sqrt(
                                Double.parseDouble(tvOutputScreen.getText().toString())
                        )
                ));
            }
            //Mem Part
            else if(testValidator.isMem(((Button) v).getText())) {
                //Store value in temp variable for performing operation
                double temp = 0;
                if(!(tvOutputScreen.getText().toString().isEmpty())){
                    temp = Double.parseDouble(tvOutputScreen.getText().toString());
                }
                else{
                    temp = result;
                    tvOutputScreen.setText(String.valueOf(result));
                }

                //M+ operation
                if(((Button) v).getText().toString().equals("M+")){
                    memory += temp;
                }
                //M- operation
                else if (((Button) v).getText().toString().equals("M+")){
                    memory -= temp;
                }
                //MRC operation
                else if(((Button) v).getText().toString().equals("MRC")){
                    //If already recalled, clear memory
                    if((tvOutputScreen.getText().toString().equals(String.valueOf(memory)))){
                        memory = 0;
                    }
                    //Recall value to output
                    else{
                        tvOutputScreen.setText(String.valueOf(memory));
                    }
                }
            }
        }
    }
}
