package com.example.manjinder_c0762203_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView selectedCar;
    TextView days;
    TextView DriverAge;
    TextView options;
    TextView amount;
    TextView totalAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        selectedCar = findViewById(R.id.selectedcar);
        days=findViewById(R.id.no_days);
        DriverAge = findViewById(R.id.driver_age);
        options = findViewById(R.id.options);
        amount=findViewById(R.id.amount);
        totalAmount = findViewById(R.id.total_payment);


        Intent i = getIntent();
        String str = i.getExtras().getString("car");
        selectedCar.setText(str);







    }
}
