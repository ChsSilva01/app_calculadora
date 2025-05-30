package com.carlos.calculadora;

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
    private ArrayList<String> current_result_one = new ArrayList<>();
    private ArrayList<String> current_result_two = new ArrayList<>();
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
                current_result_one.clear();
                current_result_two.clear();
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
                int current_number_one = Integer.parseInt(String.join("", userTyped));
                int current_number_two = Integer.parseInt(String.join("", userTypedSave));

                int result = current_number_two + current_number_one;

                editText_calculate.setText(result);
            }
        });
    }
}
