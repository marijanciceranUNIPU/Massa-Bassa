package com.hr.unipu.MassaBassa;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator_Power_Amp extends AppCompatActivity {

    private EditText numSpeakersEditText;
    private EditText rmsEditText;
    private EditText maxPowerEditText;
    private RadioGroup speakerTypeRadioGroup;
    private RadioButton svcRadioButton;
    private RadioButton dvcRadioButton;
    private EditText ohmsEditText;
    private TextView outputAmpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_amp_power);

        numSpeakersEditText = findViewById(R.id.speaker_count);
        rmsEditText = findViewById(R.id.rms_power);
        maxPowerEditText = findViewById(R.id.max_power);
        speakerTypeRadioGroup = findViewById(R.id.speakerTypeRadioGroup);
        svcRadioButton = findViewById(R.id.svcRadioButton);
        dvcRadioButton = findViewById(R.id.dvcRadioButton);
        ohmsEditText = findViewById(R.id.ohms);
        outputAmpTextView = findViewById(R.id.output_amp_text);
        Button calculateAmpButton = findViewById(R.id.calculate_amp_button);

        calculateAmpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AmpResult();
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
    private void AmpResult() {
        // Get inputs
        int numSpeakers = Integer.parseInt(numSpeakersEditText.getText().toString());
        int rms = Integer.parseInt(rmsEditText.getText().toString());
        int maxPower = Integer.parseInt(maxPowerEditText.getText().toString());
        int ohms = Integer.parseInt(ohmsEditText.getText().toString());
        boolean isDvc = dvcRadioButton.isChecked();

        // Calculate recommended amp power
        double recommendedRmsPower = calculateRecommendedRmsPower(numSpeakers, rms, ohms, isDvc);
        double recommendedMaxPower = calculateRecommendedMaxPower(recommendedRmsPower);

        // Construct output string
        String output = "Recommended minimum RMS power: " + roundToTwoDecimals(recommendedRmsPower) + " watts\n"
                + "Recommended maximum RMS power: " + roundToTwoDecimals(recommendedMaxPower) + " watts\n"
                + "Recommended amplifier: " + getRecommendedAmplifier(recommendedRmsPower, recommendedMaxPower, isDvc);

        // Display output
        outputAmpTextView.setText(output);
    }

    private double calculateRecommendedRmsPower(int numSpeakers, int rms, int ohms, boolean isDvc) {
        double totalRmsPower = numSpeakers * rms;
        if (isDvc) {
            totalRmsPower *= 2;
            ohms /= 2;
        }
        double recommendedRmsPower = totalRmsPower;
        return recommendedRmsPower;
    }

    private double calculateRecommendedMaxPower(double recommendedRmsPower) {
        double recommendedMaxPower = recommendedRmsPower * 1.5;
        return recommendedMaxPower;
    }

    private String getRecommendedAmplifier(double recommendedRmsPower, double recommendedMaxPower, boolean isDvc) {
        String recommendedAmplifier = recommendedRmsPower + "/" + recommendedMaxPower + " watts";
        return recommendedAmplifier;
    }

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
