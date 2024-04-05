package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textResult, textSolution;
    MaterialButton buttonCos, buttonSin, buttonTan, buttonPower;
    MaterialButton buttonC, buttonBracketOpen, buttonBracketClose, buttonDivide;
    MaterialButton button7, button8, button9, buttonMultiply;
    MaterialButton button4, button5, button6, buttonMinus;
    MaterialButton button1, button2, button3, buttonPlus;
    MaterialButton buttonAC, buttonZero, buttonDot, buttonEqual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textResult = findViewById(R.id.result_text);
        textSolution = findViewById(R.id.solution_text);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        assignId(R.id.button_cos);
        assignId(R.id.button_sin);
        assignId(R.id.button_tan);
        assignId(R.id.button_power);
        assignId(R.id.button_c);
        assignId(R.id.button_open);
        assignId(R.id.button_close);
        assignId(R.id.button_divide);
        assignId(R.id.button_7);
        assignId(R.id.button_8);
        assignId(R.id.button_9);
        assignId(R.id.button_multiply);
        assignId(R.id.button_4);
        assignId(R.id.button_5);
        assignId(R.id.button_6);
        assignId(R.id.button_minus);
        assignId(R.id.button_1);
        assignId(R.id.button_2);
        assignId(R.id.button_3);
        assignId(R.id.button_plus);
        assignId(R.id.button_AC);
        assignId(R.id.button_zero);
        assignId(R.id.button_dot);
        assignId(R.id.button_equal);

    }
    void assignId (int id){
        MaterialButton button = findViewById(id);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View View){
        MaterialButton button = (MaterialButton) View;
        String buttonText = button.getText().toString();
        String dataCalculate = textSolution.getText().toString();
        switch (buttonText){
            case "AC":
                textSolution.setText("");
                textResult.setText("0");
                return;
            case "=":
                textSolution.setText(textResult.getText());
                return;
            case "C":
                if(dataCalculate.length() >1) {
                    dataCalculate = dataCalculate.substring(0, dataCalculate.length() - 1);
                    break;
                }
                else{
                    return;
                }
            case "sin":
            case "tan":
            case "cos":
                if (dataCalculate.isEmpty()){
                    return;
                }
                else {
                    dataCalculate = String.valueOf(Math.sin(Double.parseDouble(dataCalculate)));
                    break;
                }
            case "^":
                dataCalculate = dataCalculate + "^";
                break;
            default:
                dataCalculate = dataCalculate + buttonText;
        }
        textSolution.setText(dataCalculate);
        String finalResult = getResult(dataCalculate);
        if(!finalResult.equals("Error")){
            textResult.setText(finalResult);
        }
    }
    String getResult(String data){
        try {
            if (data.contains("^"))
            {
                String[] powerOperands = data.split("\\^");
                if (powerOperands.length == 2) {
                    double base = Double.parseDouble(powerOperands[0]);
                    double exponent = Double.parseDouble(powerOperands[1]);
                    double result = Math.pow(base, exponent);
                    return String.valueOf(result);
                }
                else {
                    return "Error";
                }
            }
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (finalResult.equals("Infinity")) {
                finalResult = "0";
            }
            return finalResult;
        }
        catch (Exception e){
            return "Error";
        }
    }
}