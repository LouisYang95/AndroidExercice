package com.example.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CurrencyListActivity extends AppCompatActivity {

    ArrayList<Currency> currencies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);

        for (int i = 0; i < 10;i++){
            currencies.add(new Currency("$", R.drawable.flag_usa, 1.07));
            currencies.add(new Currency("Y", R.drawable.flag_japan, 120.0));
            currencies.add(new Currency("NZ$", R.drawable.flag_nz, 1.71));
            currencies.add(new Currency("£", R.drawable.flag_uk, 1.13));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CurrencyAdapter adapter = new CurrencyAdapter(currencies);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}