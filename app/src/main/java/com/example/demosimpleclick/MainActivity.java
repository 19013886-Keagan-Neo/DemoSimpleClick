package com.example.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    // Step 1: Declare the field variables
    TextView tvDisplay;
    Button btnDisplay;
    EditText etInput;
    ToggleButton tbtn;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 2: Link the field variable to UI components in layout
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnDisplay = findViewById(R.id.buttonDisplay);
        etInput = findViewById(R.id.editTextInput);
        tbtn = findViewById(R.id.toggleButtonEnabled);
        rgGender = findViewById(R.id.radioGroupGender);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                String stringResponse = etInput.getText().toString();
                if (stringResponse.isEmpty()){
                    tvDisplay.setText("Nothing has been entered");
                    Toast.makeText(MainActivity.this, "Please input something", Toast.LENGTH_SHORT).show();
                } else {
                    tvDisplay.setText(stringResponse);
                }
                int checkRadioId = rgGender.getCheckedRadioButtonId();
                if(checkRadioId == R.id.radioButtonGenderMale){
                    // Write code when male is selected
                    tvDisplay.setText("He says " + stringResponse);
                } else {
                    // Write code when female is selected
                    tvDisplay.setText("She says " + stringResponse);
                }
            }
        });

        tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add your code for the action
                if (tbtn.isChecked() == true){
                    etInput.setEnabled(true);
                    etInput.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    etInput.setEnabled(false);
                    etInput.setBackgroundColor(Color.GRAY);
                }
            }
        });

    }

}