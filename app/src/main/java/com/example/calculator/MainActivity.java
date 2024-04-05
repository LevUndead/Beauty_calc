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
        assignId(buttonCos, R.id.button_cos);
        assignId(buttonSin, R.id.button_sin);
        assignId(buttonTan, R.id.button_tan);
        assignId(buttonPower, R.id.button_power);
        assignId(buttonC, R.id.button_c);
        assignId(buttonBracketOpen, R.id.button_open);
        assignId(buttonBracketClose, R.id.button_close);
        assignId(buttonDivide, R.id.button_divide);
        assignId(button7, R.id.button_7);
        assignId(button8, R.id.button_8);
        assignId(button9, R.id.button_9);
        assignId(buttonMultiply, R.id.button_multiply);
        assignId(button4, R.id.button_4);
        assignId(button5, R.id.button_5);
        assignId(button6, R.id.button_6);
        assignId(buttonMinus, R.id.button_minus);
        assignId(button1, R.id.button_1);
        assignId(button2, R.id.button_2);
        assignId(button3, R.id.button_3);
        assignId(buttonPlus, R.id.button_plus);
        assignId(buttonAC, R.id.button_AC);
        assignId(buttonZero, R.id.button_zero);
        assignId(buttonDot, R.id.button_dot);
        assignId(buttonEqual, R.id.button_equal);

    }
    void assignId (MaterialButton button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View View){

    }
}