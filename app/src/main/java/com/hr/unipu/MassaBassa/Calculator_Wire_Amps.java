package com.hr.unipu.MassaBassa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Calculator_Wire_Amps extends AppCompatActivity {

    private EditText editTextWireSize;
    private EditText editTextWireLength;
    private Button buttonCalculate;
    private TextView textViewAmps;
    private TextView textViewPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wire_calculator);

        // Find views by their IDs
        editTextWireSize = findViewById(R.id.editTextWireSize);
        editTextWireLength = findViewById(R.id.editTextWireLength);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewAmps = findViewById(R.id.textViewAmps);
        textViewPower = findViewById(R.id.textViewPower);

        // Set an OnClickListener for the Calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered values
                int wireSize = Integer.parseInt(editTextWireSize.getText().toString());
                int wireLength = Integer.parseInt(editTextWireLength.getText().toString());

                // Perform the calculation and display the result
                double amps = calculateWireAmps(wireSize, wireLength);
                double power = calculateWirePower(wireSize, wireLength);
                textViewAmps.setText("Total Amps: " + amps);
                textViewPower.setText("Total Power: " + power + " Watts");
            }
        });
    }

    private double calculateWireAmps(int wireSize, int wireLength) {
        // Constants for wire ampacity values
        final double[] wireSizes = {0.5, 0.75, 1.0, 1.5, 2.0, 2.5, 3.0, 4.0, 6.0, 8.0, 10.0, 15.0, 20.0, 25.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0, 125.0, 150.0, 175.0, 200.0, 225.0, 250.0};
        final double[] ampacityValues = {11.0, 15.0, 18.0, 24.0, 29.0, 35.0, 41.0, 55.0, 76.0, 96.0, 116.0, 150.0, 181.0, 210.0, 234.0, 287.0, 349.0, 405.0, 454.0, 499.0, 540.0, 579.0, 645.0, 703.0, 758.0, 812.0, 864.0, 915.0};

        if (wireSize >= 0 && wireSize <= 250) {
            if (wireSize == 0) {
                return 0.0;
            } else if (wireSize <= wireSizes[0]) {
                return ampacityValues[0];
            } else if (wireSize >= wireSizes[wireSizes.length - 1]) {
                return ampacityValues[ampacityValues.length - 1];
            } else {
                for (int i = 0; i < wireSizes.length - 1; i++) {
                    if (wireSize >= wireSizes[i] && wireSize < wireSizes[i + 1]) {
                        double ampacity1 = ampacityValues[i];
                        double ampacity2 = ampacityValues[i + 1];
                        double wireSize1 = wireSizes[i];
                        double wireSize2 = wireSizes[i + 1];
                        return interpolate(ampacity1, ampacity2, wireSize1, wireSize2, wireSize);
                    }
                }
            }
        }
        return 0.0;
    }

    private double calculateWirePower(int wireSize, int wireLength) {
        double amps = calculateWireAmps(wireSize, wireLength);
        double voltage = 12.0; // Assuming 12V DC system
        return amps * voltage;
    }

    private double interpolate(double y1, double y2, double x1, double x2, double x) {
        return y1 + (x - x1) * (y2 - y1) / (x2 - x1);
    }
}
