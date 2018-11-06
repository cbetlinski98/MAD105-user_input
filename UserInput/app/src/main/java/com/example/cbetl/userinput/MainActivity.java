package com.example.cbetl.userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int mealCost;
    double totalCharges;
    double tip;
    String tipPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText mealAmount = (EditText)findViewById(R.id.txtMealAmount);
        final Spinner group =(Spinner)findViewById(R.id.txtGroup);
        Button charges = (Button)findViewById(R.id.btnCharge);
               charges.setOnClickListener(new View.OnClickListener() {
                   final TextView result = ((TextView)findViewById(R.id.txtResult));
                   @Override
                   public void onClick(View view) {
                       String holdEditText = "";
                       holdEditText = mealAmount.getText().toString();

                       try {
                           mealCost = Integer.parseInt(holdEditText);
                       } catch (NumberFormatException d) {
                           mealCost = 0;
                       }

                       DecimalFormat currency = new DecimalFormat("$###,###.##");
                       tipPercent = group.getSelectedItem().toString();

                       try {
                           tip = Double.parseDouble(tipPercent);
                       } catch (NumberFormatException d) {
                           tip = 0;
                       }

                       totalCharges = mealCost + (mealCost * tip);
                       result.setText("Total cost of a meal that is $" + mealCost + " and a tip of "
                               + tipPercent + " is " + currency.format(totalCharges));
               }
    });
}}
