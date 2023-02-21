package com.example.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent srcIntent = getIntent();
        Currency currency = srcIntent.getParcelableExtra("Currency");

        Intent intent = new Intent(this, secondActivity.class);
        final Button buttonSubmit = findViewById(R.id.submitButton);
        final Button buttonAbout = findViewById(R.id.aboutButton);

        final EditText myNumber = findViewById(R.id.amountEditText);
        final TextView textValue = findViewById(R.id.testViewDollar);

        final ImageView backgroundFlag = findViewById(R.id.imageView);
        backgroundFlag.setImageResource(currency.flag);


        buttonSubmit.setOnClickListener(v ->{
                String number = String.valueOf(myNumber.getText());
                double convertedNumber = Double.parseDouble(number) * currency.rate;
                @SuppressLint("DefaultLocale") String result = String.format("%.2f", convertedNumber);
                textValue.setText(result + currency.symbol);

                if ( number.isEmpty()){
                    Context context = getApplicationContext();
                    CharSequence text = "Remplissez la valeur";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
        });

        buttonAbout.setOnClickListener(v -> startActivity(intent));
    }
}