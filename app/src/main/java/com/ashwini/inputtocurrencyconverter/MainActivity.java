package com.ashwini.inputtocurrencyconverter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAmount;
    private Button btnRefactor;
    double amt;
    private TableLayout tlCurrencyTable;
    private int currencyTotal = 0,rowCount = 0,j;

    Double amountTotal =0.0;

    ArrayList<AmountDetails> amountList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);

        init();
    }

    private void init() {

        etAmount = findViewById(R.id.etAmount);
        btnRefactor = findViewById(R.id.btnRefactor);

        btnRefactor.setOnClickListener(this);

        tlCurrencyTable = findViewById(R.id.table_main);

        TableRow tRow0 = new TableRow(this);

        TextView tv1 = new TextView(this);
        tv1.setText(" Currency Note ");
        tv1.setTextColor(Color.WHITE);
        tRow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText(" Count ");
        tv2.setTextColor(Color.WHITE);
        tRow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" Total ");
        tv3.setTextColor(Color.WHITE);
        tRow0.addView(tv3);

        tlCurrencyTable.addView(tRow0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnRefactor:
                callRefactorMethod();
                break;
        }
    }

    private void callRefactorMethod() {
        double rs = Double.parseDouble(etAmount.getText().toString());
        rowCount = 0;
        this.amountList.clear();
        while(rs >= 2000)
        {
            amt = rs / 2000 ;
            rs = rs % 2000;
            rowCount = rowCount +1;
            amountList.add(new AmountDetails(2000.0,amt));
            break ;
        }

        while(rs >= 1000)
        {
            amt = rs / 1000 ;
            rs = rs % 1000;
            amountList.add(new AmountDetails(1000.0,amt));
            rowCount = rowCount +1;
            break ;
        }

        while(rs >= 500)
        {
            amt = rs / 500 ;
            rs = rs % 500;
            amountList.add(new AmountDetails(500.0,amt));
            rowCount = rowCount +1;
            break ;
        }
        while(rs >= 200)
        {
            amt = rs / 200 ;
            rs = rs % 200;
            amountList.add(new AmountDetails(200.0,amt));
            rowCount = rowCount +1;
            break ;
        }
        while(rs >= 100)
        {
            amt = rs / 100 ;
            rs = rs % 100;
            amountList.add(new AmountDetails(100.0,amt));
            rowCount = rowCount +1;
            break ;
        }
        while(rs >= 50)
        {
            amt = rs / 50 ;
            rs = rs % 50;
            amountList.add(new AmountDetails(50.0,amt));
            rowCount = rowCount +1;
            break ;
        }
        while(rs >= 20)
        {
            amt = rs / 20 ;
            rs = rs % 20;
            amountList.add(new AmountDetails(20.0,amt));
            rowCount = rowCount +1;
            break ;
        }
        while(rs >= 10)
        {
            amt = rs / 10 ;
            rs = rs % 10;
            amountList.add(new AmountDetails(10.0,amt));
            rowCount = rowCount +1;
            break ;
        }
        while(rs >= 5)
        {
            amt = rs / 5 ;
            rs = rs % 5;
            amountList.add(new AmountDetails(5.0,amt));
            rowCount = rowCount +1;
            break ;
        }
        while(rs >= 2)
        {
            amt = rs / 2 ;
            rs = rs % 2;
            amountList.add(new AmountDetails(2.0,amt));
            rowCount = rowCount +1;
            break ;
        }
        while(rs >= 1)
        {
            amt = rs / 1 ;
            rs = rs % 1;
            amountList.add(new AmountDetails(1.0,amt));
            rowCount = rowCount +1;
            break ;
        }

        while(rs >= 0.5)
        {
            amt = rs / 0.5 ;
            rs = rs % 0.5;
            rowCount = rowCount +1;
            amountList.add(new AmountDetails(0.5,amt));
            break ;
        }

        while(rs >= 0.25)
        {
            amt = rs / 0.25 ;
            rs = rs % 0.25;
            rowCount = rowCount +1;
            amountList.add(new AmountDetails(0.25,amt));
            break ;
        }

        initTable();
    }

    public void initTable() {


        int childCount = tlCurrencyTable.getChildCount();


        if (childCount > 1) {
            tlCurrencyTable.removeViews(1, childCount - 1);
        }

        while (tlCurrencyTable.getChildCount() > 1) {
            TableRow row =  (TableRow) tlCurrencyTable.getChildAt(1);
            tlCurrencyTable.removeView(row);
            j= tlCurrencyTable.getChildCount();
        }

        amountTotal =0.0;
        currencyTotal = 0;
        for (int i = 0; i < rowCount; i++) {
            TableRow tbRow1 = new TableRow(this);
            AmountDetails amountObj = amountList.get(i);


            currencyTotal = currencyTotal + Integer.valueOf((amountObj.getAmountCount()).intValue());
            amountTotal = amountTotal+  Integer.valueOf((amountObj.getAmountCount()).intValue()) * amountObj.getAmountData();


            TextView t2v = new TextView(this);
            t2v.setText("Rs "+String.valueOf(amountObj.getAmountData()));
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbRow1.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setText(String.valueOf(Integer.valueOf((amountObj.getAmountCount()).intValue())));
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            tbRow1.addView(t3v);

            TextView t4v = new TextView(this);
            t4v.setText(String.valueOf(amountObj.getAmountData())+" x " +String.valueOf(Integer.valueOf((amountObj.getAmountCount()).intValue())));
            t4v.setTextColor(Color.WHITE);
            t4v.setGravity(Gravity.CENTER);
            tbRow1.addView(t4v);

            tlCurrencyTable.addView(tbRow1);
        }

        TableRow tbRow2 = new TableRow(this);
        TextView t2v = new TextView(this);
        t2v.setText("Total");
        t2v.setTextColor(Color.WHITE);
        t2v.setGravity(Gravity.CENTER);
        tbRow2.addView(t2v);

        TextView t3v = new TextView(this);
        t3v.setText(String.valueOf(currencyTotal));
        t3v.setTextColor(Color.WHITE);
        t3v.setGravity(Gravity.CENTER);
        tbRow2.addView(t3v);

        TextView t4v = new TextView(this);
        t4v.setText(String.valueOf(amountTotal));
        t4v.setTextColor(Color.WHITE);
        t4v.setGravity(Gravity.CENTER);
        tbRow2.addView(t4v);
        tlCurrencyTable.addView(tbRow2);

    }
}
