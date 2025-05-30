package com.carlos.calculadora;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
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

    private ArrayList<String> userTyped = new ArrayList<>();
    private final ArrayList<String> userTypedSave = new ArrayList<>();// ✅ variáveis da classe aqui dentro
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
        AppCompatButton button_clear = findViewById(R.id.btn_clear);

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTyped.clear();
                userTypedSave.clear();
                operation = "";
                editText_calculate.setText("");

            }
        });
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTyped.add("1");
                String current_number = String.join("", userTyped);
                editText_calculate.setText(current_number);
            }
        });

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "plus"; // ❌ você estava criando outra variável com `String operation = ...`
                editText_calculate.setText("");
                userTyped = userTypedSave;
                userTyped.clear();
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_number_one = String.join("",userTyped);
                String current_number_two = String.join("",userTypedSave);

                editText_calculate.setText(current_number_two);

                Log.d("userTyped", "Sei la: " + current_number_one);
                Log.d("userTypedSave", "sei la ao quadrado: " + current_number_two);
            }
        });
    }
}
