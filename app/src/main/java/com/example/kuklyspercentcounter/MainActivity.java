package com.example.kuklyspercentcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView percentBar;
    private TextView totalBar;
    private TextView tipBar;
    private TextView resultBar;
    private EditText enterBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        percentBar =  findViewById(R.id.percentBar);
        totalBar =  findViewById(R.id.totalBar);
        tipBar =  findViewById(R.id.tipBar);
        resultBar =  findViewById(R.id.resultBar);
        enterBar =  findViewById(R.id.enterBar);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentBar.setText(String.valueOf(progress) + "%");
                int rate = progress;
                try {
                    String amount = enterBar.getText().toString();
                    String tip = String.format("%.2f", tip(progress, amount));
                    tipBar.setText(tip);
                    String total = String.format("%.2f", total(progress, amount));
                    totalBar.setText(total);
                    resultBar.setText("Amount: " + amount + ", Total: " + total + ", with a rate of " + rate + "%");
                } catch (NumberFormatException ignored) {
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private double tip(int rate, String amount){
        double discount = Double.parseDouble(String.valueOf(rate));
        double input = Double.parseDouble(amount);
        return input * (discount / 100);
    }
    private double total(int rate, String amount){
        double discount = Double.parseDouble(String.valueOf(rate));
        double input = Double.parseDouble(amount);
        return input + (input * (discount / 100));
    }
}