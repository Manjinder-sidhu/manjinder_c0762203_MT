package com.example.manjinder_c0762203_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    Spinner car_names;
    EditText daily_rent;
    TextView amount;
    TextView number_days;
    SeekBar seekbar;
    RadioGroup driver;
    CheckBox gps;
    CheckBox child;
    CheckBox millage;
    TextView total_Payment;
    Button view;





    /*
    global variables
     */
    String car;


    int rent1 ;
    int rentTotal;
    int days;
    double totalAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        car_names = findViewById(R.id.car_names);
        daily_rent=findViewById(R.id.Daily_rent);
        amount = findViewById(R.id.Amount);
        number_days = findViewById(R.id.no_days);
        seekbar = findViewById(R.id.seekbar);
        driver = findViewById(R.id.rg);
        gps = findViewById(R.id.gps);
        child = findViewById(R.id.childSeat);
        millage=findViewById(R.id.millage);
        total_Payment = findViewById(R.id.total_payment);
        view = findViewById(R.id.viewdetails);


//        public final int total{
//            totalAmount = (Integer.parseInt(amount.getText().toString()) * 13)/100;
//            total_Payment.setText(String.valueOf(totalAmount));
//
//        }

        car_names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (car_names.getSelectedItem().toString()){

                    case "BMW":
                      daily_rent.setText("120");
                      amount.setText("120");

//                        Intent i = new Intent(MainActivity.this,Details.class);
//                        i.putExtra("car","BMW");

                      break;
                    case "Audi":
                        daily_rent.setText("100");
                        amount.setText("100");
                        break;

                    case "Cadillac":
                        daily_rent.setText("90");
                        amount.setText("90");
                        break;

                    case "Volks Wagon":
                        daily_rent.setText("80");
                        amount.setText("80");
                        break;

                    case "Mercedes":
                        daily_rent.setText("110");
                        amount.setText("110");
                        break;

                    case "Peugeot":
                        daily_rent.setText("70");
                        amount.setText("70");
                        break;

                    case "Swift":
                        daily_rent.setText("90");
                        amount.setText("90");
                        break;


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        days = progress;

        if (!daily_rent.getText().toString().isEmpty()) {
            rent1 = Integer.valueOf(daily_rent.getText().toString()) ;

            rentTotal = rent1 * days;
            amount.setText(String.valueOf(rentTotal));
        }
            number_days.setText(String.valueOf(progress));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});



driver.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(days <= 0){

            Toast.makeText(MainActivity.this, "select number of days first", Toast.LENGTH_SHORT).show();
        }
        else if(days > 0){

            if (checkedId == R.id.below) {
                rent1 = Integer.valueOf(amount.getText().toString()) + 5;
                amount.setText(String.valueOf(rent1));
            }
            if (checkedId == R.id.between) {
                rent1 = Integer.valueOf(amount.getText().toString()) + 0;
                amount.setText(String.valueOf(rent1));
            }
            if (checkedId == R.id.above) {
                rent1 = Integer.valueOf(amount.getText().toString()) - 10;
                amount.setText(String.valueOf(rent1));
            }
        }
    }
});


gps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            rent1 = Integer.valueOf(amount.getText().toString()) + 5 ;
            amount.setText(String.valueOf(rent1));
        }
    }
});

        child.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rent1 = Integer.valueOf(amount.getText().toString()) + 7 ;
                    amount.setText(String.valueOf(rent1));
                }
            }
        });
        millage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rent1 = Integer.valueOf(amount.getText().toString()) + 10 ;
                    amount.setText(String.valueOf(rent1));
                }
            }
        });

view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        car = car_names.getSelectedItem().toString();
        Intent i = new Intent(MainActivity.this,Details.class);
        i.putExtra("car",car);


    }
});



    }
}
