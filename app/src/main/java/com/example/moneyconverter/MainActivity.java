package com.example.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
//import android.util.Log;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonSubmit = findViewById(R.id.submitButton);
        final EditText myNumber = findViewById(R.id.amountEditText);
        final TextView textValue = findViewById(R.id.testViewDollar);

        buttonSubmit.setOnClickListener(v ->{
            String number = String.valueOf(myNumber.getText());
            double convertedNumber = Double.parseDouble(number) * 1.07;
            @SuppressLint("DefaultLocale") String result = String.format("%.2f", convertedNumber);
            textValue.setText(result + "$");
            Log.i("mainActivity", String.valueOf(textValue));
            }
        );
    }
}