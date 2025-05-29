package com.carlos.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<String> userTyped = new ArrayList<>(); // ✅ variáveis da classe aqui dentro
    private int num1 = 0;
    private int num2 = 0;
    private String operation = "";

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

        AppCompatButton button_one = findViewById(R.id.btn_one);
        AppCompatButton button_plus = findViewById(R.id.btn_plus);
        AppCompatButton button_equal = findViewById(R.id.btn_equal);
        EditText editText_calculate = findViewById(R.id.textview_calculate);

        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> userTyped = new ArrayList<>();
                userTyped.add("1");

                editText_calculate.setText(userTyped); // agora sim, funciona
            }
        });

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "+"; // ❌ você estava criando outra variável com `String operation = ...`
                editText_calculate.setText("");
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation.equals("+")) { // ✅ use .equals para comparar strings
                    num2 = Integer.parseInt(editText_calculate.getText().toString());
                    int result = num1 + num2;
                    editText_calculate.setText(String.valueOf(result));
                }
            }
        });
    }
}
