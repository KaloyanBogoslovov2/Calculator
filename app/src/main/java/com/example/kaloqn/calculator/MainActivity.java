package com.example.kaloqn.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MainActivity extends AppCompatActivity {
    private BigDecimal leftValue;
    private BigDecimal rightValue = new BigDecimal(0);
    private int leftValueWithOperationLenght;
    private String current_operation = "non";
    private StringBuilder equation = new StringBuilder("");
    private EditText calculatorScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorScreen = (EditText)findViewById(R.id.calculator_screen);
        calculatorScreen.setInputType(InputType.TYPE_NULL);
        initNumberButtons();
        initFunctionButtons();
        initClearButton();
        initCalculateButton();
    }

    private void initNumberButtons(){
        Button zero = (Button) findViewById(R.id.zero);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToEquation("0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToEquation("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToEquation("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToEquation("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToEquation("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToEquation("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToEquation("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToEquation("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToEquation("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToEquation("9");
            }
        });


    }

    private void initFunctionButtons(){
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button divide = (Button) findViewById(R.id.divide);
        Button sqrt = (Button) findViewById(R.id.sqrt);
        Button point = (Button) findViewById(R.id.point);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add new operation
                if(equationLongerThanZeroAndNoOperationIsSet()){
                    leftValue = new BigDecimal(equation.toString());
                    current_operation = "+";
                    appendToEquation(current_operation);
                    leftValueWithOperationLenght = equation.length();
                }
                //Change operation
                else if(equationLongerThanZeroAndNoSecondValueInputted()){
                    equation.setLength(equation.length()-1);
                    current_operation = "+";
                    appendToEquation(current_operation);
                }


            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add new operation
                if(equationLongerThanZeroAndNoOperationIsSet()){
                    leftValue = new BigDecimal(equation.toString());
                    current_operation = "-";
                    appendToEquation(current_operation);
                    leftValueWithOperationLenght = equation.length();
                }
                //Change operation
                else if(equationLongerThanZeroAndNoSecondValueInputted()){
                    equation.setLength(equation.length()-1);
                    current_operation = "-";
                    appendToEquation(current_operation);
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add new operation
                if(equationLongerThanZeroAndNoOperationIsSet()){
                    leftValue = new BigDecimal(equation.toString());
                    current_operation = "*";
                    appendToEquation(current_operation);
                    leftValueWithOperationLenght = equation.length();
                }
                //Change operation
                else if(equationLongerThanZeroAndNoSecondValueInputted()){
                    equation.setLength(equation.length()-1);
                    current_operation = "*";
                    appendToEquation(current_operation);
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add new operation
                if(equationLongerThanZeroAndNoOperationIsSet()){
                    leftValue = new BigDecimal(equation.toString());
                    current_operation = "/";
                    appendToEquation(current_operation);
                    leftValueWithOperationLenght = equation.length();
                }
                //Change operation
                else if(equationLongerThanZeroAndNoSecondValueInputted()){
                    equation.setLength(equation.length()-1);
                    current_operation = "/";
                    appendToEquation(current_operation);
                }
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calculate sqrt
                if(equationLongerThanZeroAndNoOperationIsSet()){
                    BigDecimal value = new BigDecimal(equation.toString());
                    if (value.compareTo(BigDecimal.ZERO)<0.5){
                        Toast.makeText(MainActivity.this,"illegal operation", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    calculateSqrt(value);
                    prepareForNextCalculation();
                }
                //Change operation and calculate sqrt
                else if(equationLongerThanZeroAndNoSecondValueInputted()){
                    equation.setLength(equation.length()-1);
                    BigDecimal value = new BigDecimal(equation.toString());
                    if (value.compareTo(BigDecimal.ZERO)<0.5){
                        Toast.makeText(MainActivity.this,"illegal operation", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    calculateSqrt(value);
                    prepareForNextCalculation();
                }
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String secondValue = equation.substring(leftValueWithOperationLenght,equation.length());
                System.out.println(equation.length());
                boolean b = equation.length()==0;
                System.out.println(b);
                if(equation.length()==0) {
                    appendToEquation("0.");
                }else if(leftValueWithOperationLenght==equation.length()){
                    appendToEquation("0.");
                }else if(current_operation.equals("non")&&equation.indexOf(".")==-1){
                    appendToEquation(".");
                }else if(secondValue.indexOf(".")==-1&&equation.length()>leftValueWithOperationLenght){
                    appendToEquation(".");
                }

            }
        });

    }

    private void initClearButton(){

        Button clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = new StringBuilder("");
                leftValue = new BigDecimal(0);
                rightValue = new BigDecimal(0);
                current_operation="non";
                leftValueWithOperationLenght=0;
                calculatorScreen.setText(equation);
            }
        });
    }

    private void initCalculateButton(){

        Button calc = (Button) findViewById(R.id.calculate);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length()>leftValueWithOperationLenght){
                    String secondValue = equation.substring(leftValueWithOperationLenght,equation.length());
                    rightValue = new BigDecimal(secondValue);
                    calculate();
                }
            }
        });
    }

    private void appendToEquation(String element){
        equation.append(element);
        calculatorScreen.setText(equation);

    }

    private void calculate(){

        switch (current_operation) {
            case "+":
                leftValue = leftValue.add(rightValue);
                prepareForNextCalculation();
                break;
            case "-":
                leftValue = leftValue.subtract(rightValue);
                prepareForNextCalculation();
                break;
            case "*":
                leftValue = leftValue.multiply(rightValue);
                prepareForNextCalculation();
                break;
            case "/":
                if (rightValue.equals(BigDecimal.ZERO)){
                    Toast.makeText(MainActivity.this,"error! a BIG one", Toast.LENGTH_SHORT).show();
                    return;
                }
                leftValue = leftValue.divide(rightValue,5, RoundingMode.HALF_UP);
                prepareForNextCalculation();
                break;
        }
    }

    private void prepareForNextCalculation(){
        // leftValue = leftValue.setScale(5,RoundingMode.HALF_UP);
        equation = new StringBuilder(leftValue.toString());
        calculatorScreen.setText(equation);
        rightValue = new BigDecimal(0);
        current_operation="non";
        leftValueWithOperationLenght=0;
    }

    private boolean equationLongerThanZeroAndNoOperationIsSet(){
        return equation.length()>0&&current_operation.equals("non");
    }

    private boolean equationLongerThanZeroAndNoSecondValueInputted(){
        return equation.length()>0&&leftValueWithOperationLenght==equation.length();
    }

    private void calculateSqrt(BigDecimal value){
        leftValue = new BigDecimal(Math.sqrt(Double.parseDouble(equation.toString())));
        // The next line is from stackoverflow
        leftValue = leftValue.add(new BigDecimal(value.subtract(leftValue.multiply(leftValue))
                .doubleValue()/(leftValue.doubleValue()*2.0)));
        leftValue = leftValue.setScale(5, RoundingMode.HALF_UP);
    }
}
