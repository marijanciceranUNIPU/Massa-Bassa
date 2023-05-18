package com.hr.unipu.MassaBassa;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
public class Calculator_Mids_n_Highs extends AppCompatActivity {

    private EditText powerEditText;
    private RadioGroup midsRadioGroup;
    private RadioGroup highsRadioGroup;
    private TextView midsResultTextView;
    private TextView highsResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mids_highs);

        powerEditText = findViewById(R.id.powerEditText);
        midsRadioGroup = findViewById(R.id.midsRadioGroup);
        highsRadioGroup = findViewById(R.id.highsRadioGroup);
        midsResultTextView = findViewById(R.id.midsResultTextView);
        highsResultTextView = findViewById(R.id.highsResultTextView);
        Button calculatePowerButton = findViewById(R.id.calculatePowerButton);

        calculatePowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatePower();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void calculatePower() {
        int totalPower = Integer.parseInt(powerEditText.getText().toString());

        double midsPowerPercentage;
        int checkedMidsRadioButtonId = midsRadioGroup.getCheckedRadioButtonId();
        if (checkedMidsRadioButtonId == R.id.mids20RadioButton) {
            midsPowerPercentage = 0.20;
        } else {
            midsPowerPercentage = 0.25;
        }

        double highsPowerPercentage;
        int checkedHighsRadioButtonId = highsRadioGroup.getCheckedRadioButtonId();
        if (checkedHighsRadioButtonId == R.id.highs5RadioButton) {
            highsPowerPercentage = 0.05;
        } else {
            highsPowerPercentage = 0.10;
        }

        double midsPower = totalPower * midsPowerPercentage;
        double highsPower = totalPower * highsPowerPercentage;

        midsResultTextView.setText("Mids Power: " + midsPower + " Watts");
        highsResultTextView.setText("Highs Power: " + highsPower + " Watts");
    }
}
