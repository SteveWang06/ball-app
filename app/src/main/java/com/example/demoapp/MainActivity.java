package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox cbBasketball;
    private CheckBox cbFootball;
    private CheckBox cbBaseball;
    private TextView tvMessage;
    private RadioGroup rgBall;
    private Spinner spBall;
    private String[] ball = {"basketball", "football", "baseball"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbBasketball = findViewById(R.id.cb_basketball);
        cbFootball = findViewById(R.id.cb_football);
        cbBaseball = findViewById(R.id.cb_baseball);
        tvMessage = findViewById(R.id.tv_message);
        rgBall = findViewById(R.id.rg_ball);
        spBall = findViewById(R.id.sp_ball);

        ArrayAdapter<CharSequence> spAdapter = ArrayAdapter.createFromResource(this, R.array.myBall, android.R.layout.simple_spinner_item);
                //new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ball);
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spBall.setAdapter(spAdapter);
        AdapterView.OnItemSelectedListener spListener = new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String mesage = "you like the item" + (i + 1) + "item " +adapterView.getSelectedItem().toString();
                tvMessage.setText(mesage);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        spBall.setOnItemSelectedListener(spListener);


        RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String masege = "you like the item: ";
                switch (i){
                    case R.id.rd_basketball:
                        masege += "the fisrt item";
                        break;
                    case R.id.rd_football:
                        masege += "the second item";
                        break;
                    case R.id.rd_baseball:
                        masege += "the third item";
                        break;
                }
                tvMessage.setText(masege);

            }
        };
        rgBall.setOnCheckedChangeListener(rgListener);




        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String massege = "you like:";
                int count = 0;
                if (cbBasketball.isChecked()){
                    massege += " basketball";
                    count++;
                }
                if (cbFootball.isChecked()){
                    massege += " football";
                    count++;
                }
                if (cbBaseball.isChecked()){
                    massege += " baseball";
                    count++;
                }
                tvMessage.setText(massege + " total " + count + " item");
            }
        };
        cbBasketball.setOnCheckedChangeListener(listener);
        cbFootball.setOnCheckedChangeListener(listener);
        cbBaseball.setOnCheckedChangeListener(listener);

    }
}