package edu.sjsu.android.mortgagecalculator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText text; //principal
    private SeekBar sBar; //seekBar
    private TextView tView; //text view to see what number is being scrolled to in seekbar
    private TextView answer; //final answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editText);
         tView = findViewById(R.id.textview6);
         sBar = findViewById(R.id.seekBar);
         answer=findViewById(R.id.textView7);
          tView = (TextView) findViewById(R.id.textview6);
      tView.setText("10.000");

                sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //to read what number is being scrolled too
                    float pval = 10;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                         pval = (float) (progress / 1000.0);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        tView.setText(String.valueOf(pval));
                    }
                });

    }


    public void onClick(View view) {
        //answer.setText("hi");
        switch (view.getId()) {
            case R.id.button:
                RadioButton fifteen = findViewById(R.id.radioButton);
                RadioButton twenty = findViewById(R.id.radioButton1);
                RadioButton thirty = findViewById(R.id.radioButton2);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                    return;
                }
                float principal = Float.parseFloat(text.getText().toString());

               float interest = Float.parseFloat(tView.getText().toString()); //read textview box from seekbar

                boolean isChecked = ((CheckBox) findViewById(R.id.checkBox)).isChecked();
                if (fifteen.isChecked()) {
                    answer.setText("$"+MortgageCalc.mortgage(principal,interest , 15, isChecked)+"/month");
                } else if (twenty.isChecked()) {
                    answer.setText("$"+MortgageCalc.mortgage(principal, interest, 20, isChecked)+"/month");
                } else {
                    answer.setText("$"+MortgageCalc.mortgage(principal, interest, 30, isChecked)+"/month");
                }
                break;
        }

    }
}