package com.example.moneyconverter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder>{


    private final ArrayList<Currency> currencies;

    public CurrencyAdapter(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView flagImageView;
        final TextView symbolTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flagImageView = itemView.findViewById(R.id.flagImageView);
            symbolTextView = itemView.findViewById(R.id.symbolTextView);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_currency, parent, false);

        return new ViewHolder(view);
    }
    //Appele a chaque fois qu'un item est affiche a l'ecran
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Currency currency = currencies.get(position);

        holder.flagImageView.setImageResource(currency.flag);
        holder.symbolTextView.setText(currency.symbol);
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

}
