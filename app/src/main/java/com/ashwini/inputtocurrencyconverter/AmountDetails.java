package com.ashwini.inputtocurrencyconverter;

/**
 * Created by softdotcom-7 on 26/3/18.
 */

public class AmountDetails {
    Double amountData;
    Double amountCount;


    public AmountDetails(Double amountCount, Double amountData) {
        this.amountData = amountCount;
        this.amountCount = amountData;
    }

    public Double getAmountData() {
        return amountData;
    }

    public void setAmountData(Double amountData) {
        this.amountData = amountData;
    }

    public Double getAmountCount() {
        return amountCount;
    }

    public void setAmountCount(Double amountCount) {
        this.amountCount = amountCount;
    }
}
