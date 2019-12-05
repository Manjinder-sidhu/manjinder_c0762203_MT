package com.example.manjinder_c0762203_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView selectedCar;
    TextView days;
    TextView DriverAge;
    TextView gps;
    TextView child;
    TextView millage;
    TextView amount;
    TextView totalAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        selectedCar = findViewById(R.id.selectedcar);
        days=findViewById(R.id.number_days);
        DriverAge = findViewById(R.id.driver_age);
        gps = findViewById(R.id.option1);
        child = findViewById(R.id.option2);
        millage=findViewById(R.id.option3);
        amount=findViewById(R.id.amount);
        totalAmount = findViewById(R.id.total_payment);


        Intent i = getIntent();
        String str = i.getExtras().getString("car");
        selectedCar.setText(str);
        String str2 = i.getExtras().getString("days");
        days.setText(str2);
        String str3 = i.getExtras().getString("driverAge");
        DriverAge.setText(str3);
        String str4 = i.getExtras().getString("option1");
        String str5 = i.getExtras().getString("option2");
        String str6 = i.getExtras().getString("option3");

        gps.setText( str4 );
        child.setText(str5 );
        millage.setText(str6);
        String str7 = i.getExtras().getString("Amount");
        amount.setText(str7);
        String str8 = i.getExtras().getString("totalAmount");
        totalAmount.setText(str8);

    }
}
