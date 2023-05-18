package com.hr.unipu.MassaBassa;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Calculator_Different_Cone_Area extends AppCompatActivity {

    private EditText firstSpeakerCountEditText, firstSpeakerSizesEditText, secondSpeakerCountEditText, secondSpeakerSizesEditText;
    private Button calculateDifferenceButton;

    private TextView outputTextView;
    private TextView output_first_cone_area;
    private TextView output_second_cone_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_different_cone_area);

        firstSpeakerCountEditText = findViewById(R.id.first_speaker_count);
        firstSpeakerSizesEditText = findViewById(R.id.first_speaker_sizes);
        secondSpeakerCountEditText = findViewById(R.id.second_speaker_count);
        secondSpeakerSizesEditText = findViewById(R.id.second_speaker_sizes);
        calculateDifferenceButton = findViewById(R.id.calculateDifferenceButton);
        outputTextView = findViewById(R.id.output_text);
        output_first_cone_area = findViewById(R.id.output_first_cone_area);
        output_second_cone_area = findViewById(R.id.output_second_cone_area);

        calculateDifferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndDisplayResult();
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
    private void calculateAndDisplayResult() {
        // Get inputs
        int firstSpeakerCount = Integer.parseInt(firstSpeakerCountEditText.getText().toString());
        int firstSpeakerSizes = Integer.parseInt(firstSpeakerSizesEditText.getText().toString());
        int secondSpeakerCount = Integer.parseInt(secondSpeakerCountEditText.getText().toString());
        int secondSpeakerSizes = Integer.parseInt(secondSpeakerSizesEditText.getText().toString());

        // Calculate total cone areas
        double firstTotalConeArea = calculateTotalConeArea(firstSpeakerCount, firstSpeakerSizes);
        double secondTotalConeArea = calculateTotalConeArea(secondSpeakerCount, secondSpeakerSizes);

        // Round total cone areas to 2 decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        String firstTotalConeAreaString = df.format(firstTotalConeArea);
        String secondTotalConeAreaString = df.format(secondTotalConeArea);

        // Compare total cone areas and display result
        if (firstTotalConeArea > secondTotalConeArea) {
            outputTextView.setText(firstSpeakerCount + " " + firstSpeakerSizes + " inch" + " speakers cone area is bigger than " +
                    secondSpeakerCount + " " + secondSpeakerSizes + " inch" + " speakers area.");
            output_first_cone_area.setText("The total cone area of the first speakers equals: " + firstTotalConeAreaString + " sq. in.");
            output_second_cone_area.setText("The total cone area of the seconds speakers equals: " + secondTotalConeAreaString + " sq. in.");
        } else if (secondTotalConeArea > firstTotalConeArea) {
            outputTextView.setText(secondSpeakerCount + " " + secondSpeakerSizes + " inch" + " speakers cone area is bigger than " +
                    firstSpeakerCount + " " + firstSpeakerSizes + " inch" + " speakers area.");
            output_first_cone_area.setText("The total cone area of the first speakers equals: " + firstTotalConeAreaString + " sq. in.");
            output_second_cone_area.setText("The total cone area of the seconds speakers equals: " + secondTotalConeAreaString + " sq. in.");
        } else {
            outputTextView.setText("The total cone areas of both sets of speakers are equal.");
        }
    }
    private double calculateTotalConeArea(int count, double size) {
        double radius = size / 2;
        double area = Math.PI * radius * radius;
        return count * area;
    }
}
