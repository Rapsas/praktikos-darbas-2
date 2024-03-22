package com.example.praktikos_darbas_2;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView resultField;
    private EditText inputField;
    private Spinner calculationTypeField;
    private Button calculationButton;

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

        calculationTypeField = (Spinner) findViewById(R.id.calculation_type_field);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.calculation_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        calculationTypeField.setAdapter(adapter);

        resultField = findViewById(R.id.result_field);
        inputField = findViewById(R.id.input_text_field);
        calculationButton = findViewById(R.id.calculate_button);
        calculationButton.setOnClickListener(v -> calculate());
    }

    private void calculate(){
        String inputText = inputField.getText().toString();
        //Add validation here
        if (!validateInput(inputText)){
            return;
        }

        String[] myArray = getResources().getStringArray(R.array.calculation_types);
        String calculationType = calculationTypeField.getSelectedItem().toString();

        int count = 0;
        String resultText = "";

        if (calculationType.equals(myArray[0])){
            count = LengthCalculator.CalculateChars(inputText);
            resultText = getString(R.string.result_field_text_chars) + count;
        } else if (calculationType.equals(myArray[1])) {
            count = LengthCalculator.CalculateWords(inputText);
            resultText = getString(R.string.result_field_text_words) + count;
        }

        resultField.setText(resultText);
    }

    private boolean validateInput(String input){
        if(TextUtils.isEmpty(input)) {
            Toast.makeText(this, getString(R.string.empty_input_field), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}