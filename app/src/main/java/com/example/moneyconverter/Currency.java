package com.example.moneyconverter;

import android.os.Parcel;
import android.os.Parcelable;

public class Currency implements Parcelable{
    public final String symbol;
    public final int flag;
    public final double rate;

    public Currency(String symbol, int flag, double rate) {
        this.symbol = symbol;
        this.flag = flag;
        this.rate = rate;
    }

    protected Currency(Parcel in) {
        symbol = in.readString();
        flag = in.readInt();
        rate = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(symbol);
        dest.writeInt(flag);
        dest.writeDouble(rate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Currency> CREATOR = new Creator<Currency>() {
        @Override
        public Currency createFromParcel(Parcel in) {
            return new Currency(in);
        }

        @Override
        public Currency[] newArray(int size) {
            return new Currency[size];
        }
    };
}
