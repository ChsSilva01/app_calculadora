package com.carlos.calculadora;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> userTyped = new ArrayList<>();
    private final ArrayList<String> userTypedSave = new ArrayList<>();
    private String operation = "";
    private Integer result = 0;
    private String resultString = "";

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
        AppCompatButton button_two = findViewById(R.id.btn_two);
        AppCompatButton button_tree = findViewById(R.id.btn_tree);
        AppCompatButton button_four = findViewById(R.id.btn_four);
        AppCompatButton button_five = findViewById(R.id.btn_five);
        AppCompatButton button_six = findViewById(R.id.btn_six);
        AppCompatButton button_seven = findViewById(R.id.btn_seven);
        AppCompatButton button_eight = findViewById(R.id.btn_eight);
        AppCompatButton button_nine = findViewById(R.id.btn_nine);
        AppCompatButton button_zero = findViewById(R.id.btn_zero);

        AppCompatButton button_plus = findViewById(R.id.btn_plus);
        AppCompatButton button_subtraction = findViewById(R.id.btn_subtraction);
        AppCompatButton button_multiplication = findViewById(R.id.btn_multiplication);
        AppCompatButton button_division = findViewById(R.id.btn_division);

        AppCompatButton button_equal = findViewById(R.id.btn_equal);

        EditText editText_calculate = findViewById(R.id.editText_calculate);
        TextView editText_history = findViewById(R.id.textview_history);

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

        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTyped.add("2");
                String current_number = String.join("", userTyped);
                editText_calculate.setText(current_number);
            }
        });

        button_tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTyped.add("3");
                String current_number = String.join("", userTyped);
                editText_calculate.setText(current_number);
            }
        });

        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTyped.add("4");
                String current_number = String.join("", userTyped);
                editText_calculate.setText(current_number);
            }
        });

        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTyped.add("5");
                String current_number = String.join("", userTyped);
                editText_calculate.setText(current_number);
            }
        });

        button_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTyped.add("6");
                String current_number = String.join("", userTyped);
                editText_calculate.setText(current_number);
            }
        });

        button_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTyped.add("7");
                String current_number = String.join("", userTyped);
                editText_calculate.setText(current_number);
            }
        });

        button_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTyped.add("8");
                String current_number = String.join("", userTyped);
                editText_calculate.setText(current_number);
            }
        });

        button_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTyped.add("9");
                String current_number = String.join("", userTyped);
                editText_calculate.setText(current_number);
            }
        });

        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTyped.add("0");
                String current_number = String.join("", userTyped);
                editText_calculate.setText(current_number);
            }
        });


        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "plus"; // ❌ você estava criando outra variável com `String operation = ...`
                editText_calculate.setText("");
                userTypedSave.addAll(userTyped);
                userTyped.clear();
            }
        });

        button_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "subtraction";
                editText_calculate.setText("");
                userTypedSave.addAll(userTyped);
                userTyped.clear();
            }
        });

        button_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "multiplication";
                editText_calculate.setText("");
                userTypedSave.addAll(userTyped);
                userTyped.clear();
            }
        });

        button_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "division";
                editText_calculate.setText("");
                userTypedSave.addAll(userTyped);
                userTyped.clear();
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (operation) {
                    case "plus": {
                        String current_number_one = String.join("", userTyped);
                        String current_number_two = String.join("", userTypedSave);

                        int number_one = Integer.parseInt(current_number_one);
                        int number_two = Integer.parseInt(current_number_two);

                        result = number_one + number_two;

                        String message = Integer.toString(result);
                        editText_calculate.setText(message);

                        break;
                    }
                    case "subtraction": {
                        String current_number_one = String.join("", userTyped);
                        String current_number_two = String.join("", userTypedSave);

                        int number_one = Integer.parseInt(current_number_one);
                        int number_two = Integer.parseInt(current_number_two);

                        result = number_one - number_two;

                        String message = Integer.toString(result);
                        editText_calculate.setText(message);

                        break;
                    }
                    case "multiplication": {
                        String current_number_one = String.join("", userTyped);
                        String current_number_two = String.join("", userTypedSave);

                        int number_one = Integer.parseInt(current_number_one);
                        int number_two = Integer.parseInt(current_number_two);

                        result = number_one * number_two;

                        String message = Integer.toString(result);
                        editText_calculate.setText(message);

                        break;
                    }
                    case "division": {
                        try {
                            String current_number_one = String.join("", userTyped);
                            String current_number_two = String.join("", userTypedSave);

                            int number_one = Integer.parseInt(current_number_one);
                            int number_two = Integer.parseInt(current_number_two);

                            result = number_two / number_one;

                            String message = Integer.toString(result);
                            editText_calculate.setText(message);
                        } catch (Exception e){
                            editText_calculate.setText("Indefinido");
                        }
                        break;
                    }
                    default:
                        Toast.makeText(getApplicationContext(), "Faça a lógica de forma correta", Toast.LENGTH_SHORT).show();
                        break;
                }
                // O lançe e criar uma váriavel para saber se estou querendo somar o histórico
                // e o Histórico eu quero salvar num1 + num2 = result e mostrar na tela fazer isso de forma individual
                // vou fazer isso provavelmente com uma variável aplicada nas operações e zerando os arrays de número e verificando
                // Descobrir se tem como colocar icone no botão
                resultString = Integer.toString(result);
                editText_history.setText(resultString);

            }
        });
    }
}
