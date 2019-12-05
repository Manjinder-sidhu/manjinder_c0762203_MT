package com.example.manjinder_c0762203_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    EditText amount;
    TextView number_days;
    SeekBar seekbar;
    RadioGroup driver;
    CheckBox gps;
    CheckBox child;
    CheckBox millage;
    EditText total_Payment;
    Button view;





    /*
    global variables
     */
    String car;
    int rent1 ;
    int rentTotal;
    int days;
    double totalAmount;
    String driverAge;
    String childstr = "0";
    String gpsstr = "0";
    String millagestr = "0";
    String daysStr;



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
        total_Payment = findViewById(R.id.Tot_Payment);
        view = findViewById(R.id.viewdetails);
//        total_Payment.addTextChangedListener(forAmount);

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
                        totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                        total_Payment.setText(String.valueOf(totalAmount));

                      break;
                    case "Audi":
                        daily_rent.setText("100");
                        amount.setText("100");
                        totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                        total_Payment.setText(String.valueOf(totalAmount));
                        break;

                    case "Cadillac":
                        daily_rent.setText("90");
                        amount.setText("90");
                        totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                        total_Payment.setText(String.valueOf(totalAmount));
                        break;

                    case "Volks Wagon":
                        daily_rent.setText("80");
                        amount.setText("80");
                        totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                        total_Payment.setText(String.valueOf(totalAmount));
                        break;

                    case "Mercedes":
                        daily_rent.setText("110");
                        amount.setText("110");
                        totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                        total_Payment.setText(String.valueOf(totalAmount));
                        break;

                    case "Peugeot":
                        daily_rent.setText("70");
                        amount.setText("70");
                        totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                        total_Payment.setText(String.valueOf(totalAmount));
                        break;

                    case "Swift":
                        daily_rent.setText("90");
                        amount.setText("90");
                        totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                        total_Payment.setText(String.valueOf(totalAmount));
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

            totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
            total_Payment.setText(String.valueOf(totalAmount));
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
                driverAge = "less than below";
                rent1 = Integer.valueOf(amount.getText().toString()) + 5;
                amount.setText(String.valueOf(rent1));
                totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                total_Payment.setText(String.valueOf(totalAmount));
            }
            if (checkedId == R.id.between) {
                driverAge = "between 20 and 60";
                rent1 = Integer.valueOf(amount.getText().toString()) + 0;
                amount.setText(String.valueOf(rent1));
                totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                total_Payment.setText(String.valueOf(totalAmount));
            }
            if (checkedId == R.id.above) {
                driverAge = "above 60";
                rent1 = Integer.valueOf(amount.getText().toString()) - 10;
                amount.setText(String.valueOf(rent1));
                totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                total_Payment.setText(String.valueOf(totalAmount));
            }
        }
    }
});


gps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            gpsstr = "$5";
            rent1 = Integer.valueOf(amount.getText().toString()) + 5 ;
            amount.setText(String.valueOf(rent1));
            totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
            total_Payment.setText(String.valueOf(totalAmount));

        }
    }
});

        child.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    childstr = "$7";
                    rent1 = Integer.valueOf(amount.getText().toString()) + 7 ;
                    amount.setText(String.valueOf(rent1));
                    totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                    total_Payment.setText(String.valueOf(totalAmount));
                }
            }
        });
        millage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    millagestr="$10";
                    rent1 = Integer.valueOf(amount.getText().toString()) + 10 ;
                    amount.setText(String.valueOf(rent1));
                    totalAmount = (Double.parseDouble(amount.getText().toString()) * 13/100) +Double.parseDouble(amount.getText().toString()) ;
                    total_Payment.setText(String.valueOf(totalAmount));
                }
            }
        });

view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        car = car_names.getSelectedItem().toString();
        Intent i = new Intent(MainActivity.this,Details.class);
        i.putExtra("car",car);
        i.putExtra("days",number_days.getText().toString());
         i.putExtra("option1", gpsstr);
daysStr = String.valueOf(days);
i.putExtra("days",daysStr);
        i.putExtra("option2", childstr);

        i.putExtra("option3", millagestr);

        i.putExtra("driverAge",driverAge);
        i.putExtra("Amount",amount.getText().toString());
        i.putExtra("totalAmount",total_Payment.getText().toString());
        startActivity(i);


    }
});




    }


}
