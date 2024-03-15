package com.example.ferryticketsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    double costPerTicketsToCatalina = 34;
    double costPerTicketsToLongBeach = 40;
    int numOfTickets;
    double totalCost;
    String tripChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText tickets = findViewById(R.id.edTickets);
        Spinner destination = findViewById(R.id.spinnerDest);
        TextView result = findViewById(R.id.result);
        Button cost = findViewById(R.id.cost);

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    numOfTickets = Integer.parseInt(tickets.getText().toString());
                } catch (NumberFormatException e)
                {
                    result.setText("Please enter the number of tickets you need");
                    return;
                }

                NumberFormat currency = NumberFormat.getCurrencyInstance() ;
                tripChoice = destination.getSelectedItem().toString() ;

                if (destination.getSelectedItemPosition() == 0 )
                    totalCost = costPerTicketsToCatalina * numOfTickets;
                else
                    totalCost = costPerTicketsToLongBeach * numOfTickets;

                result.setText("One Way Trip " + tripChoice + "  for " + numOfTickets + " passengers: " + currency.format(totalCost) );
            }
        });

    }

}