package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}