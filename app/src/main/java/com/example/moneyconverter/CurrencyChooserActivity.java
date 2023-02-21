package com.example.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CurrencyChooserActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_chooser);

        findViewById(R.id.japanButton).setOnClickListener(this);
        findViewById(R.id.nzButton).setOnClickListener(this);
        findViewById(R.id.usaButton).setOnClickListener(this);
        findViewById(R.id.ukButton).setOnClickListener(this);

    }

    private void navigateToConvert(String symbol, int flag, double rate) {
        Intent intent = new Intent(CurrencyChooserActivity.this, MainActivity.class);
        Currency currency = new Currency(symbol, flag, rate);
        intent.putExtra("Currency", currency);
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ukButton :
                navigateToConvert("£", R.drawable.flag_uk, 0.89);
                break;
            case R.id.usaButton :
                navigateToConvert("$", R.drawable.flag_usa, 1.07);
                break;
            case R.id.nzButton:
                navigateToConvert("NZ$", R.drawable.flag_nz, 1.71);
                break;
            case R.id.japanButton :
                navigateToConvert("¥", R.drawable.flag_japan, 143.22);
                break;
        }
    }
}

