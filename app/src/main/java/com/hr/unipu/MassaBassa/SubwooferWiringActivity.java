package com.hr.unipu.MassaBassa;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SubwooferWiringActivity extends AppCompatActivity {

    private Spinner spinnerNumSpeakers;
    private Spinner spinnerVoiceCoils;
    private TextView textViewResult;
    private Button buttonCalculate;

    private int selectedNumSpeakers = 1;
    private int selectedVoiceCoilImpedance = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subwoofer_wiring);

        spinnerNumSpeakers = findViewById(R.id.spinnerNumSpeakers);
        spinnerVoiceCoils = findViewById(R.id.spinnerVoiceCoils);
        textViewResult = findViewById(R.id.textViewResult);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        // Set up the number of speakers spinner
        List<String> numSpeakersList = new ArrayList<>();
        numSpeakersList.add("1 speaker");
        numSpeakersList.add("2 speakers");
        numSpeakersList.add("3 speakers");
        numSpeakersList.add("4 speakers");
        ArrayAdapter<String> numSpeakersAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numSpeakersList);
        spinnerNumSpeakers.setAdapter(numSpeakersAdapter);

        // Set up the voice coils spinner
        List<String> voiceCoilsList = new ArrayList<>();
        voiceCoilsList.add("1 ohm dual voice coils");
        voiceCoilsList.add("2 ohm dual voice coils");
        voiceCoilsList.add("4 ohm dual voice coils");
        voiceCoilsList.add("6 ohm dual voice coils");
        voiceCoilsList.add("4 ohm single voice coil");
        voiceCoilsList.add("8 ohm single voice coil");
        ArrayAdapter<String> voiceCoilsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, voiceCoilsList);
        spinnerVoiceCoils.setAdapter(voiceCoilsAdapter);

        // Set an OnItemSelectedListener for the number of speakers spinner
        spinnerNumSpeakers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedNumSpeakers = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Not used
            }
        });

        // Set an OnItemSelectedListener for the voice coils spinner
        spinnerVoiceCoils.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedVoiceCoilImpedance = (int) getVoiceCoilImpedance(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Not used
            }
        });

        // Set an OnClickListener for the Calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        // Add the back button to the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void calculateResult() {
        String result;
        double impedanceResult;

        if (selectedVoiceCoilImpedance == 1.0) {
            switch (selectedNumSpeakers) {
                case 1:
                    impedanceResult = 0.5;
                    result = "\n Option 1: 0.5 ohm parallel \n Option 2: 2 ohm series";
                    break;
                case 2:
                    impedanceResult = 1.0;
                    result = "\n Option 1: 1 ohm parallel \n Option 2: 4 ohm series";
                    break;
                case 3:
                    impedanceResult = 0.67;
                    result = " \n Option 1: 0.67 ohm series/parallel \n Option 2: 1.5 ohm parallel/series \n Option 3: 6 ohm series";
                    break;
                case 4:
                    impedanceResult = 0.5;
                    result = "\n Option 1: 0.5 ohm series/parallel \n Option 2: 2 ohm parallel/series \n Option 3: 8 ohm series";
                    break;
                default:
                    impedanceResult = 0.0;
                    result = "\n Invalid selection";
                    break;
            }
        } else if (selectedVoiceCoilImpedance == 2.0) {
            switch (selectedNumSpeakers) {
                case 1:
                    impedanceResult = 1.0;
                    result = "\n Option 1: 1 ohm parallel \n Option 2: 4 ohm series";
                    break;
                case 2:
                    impedanceResult = 0.5;
                    result = "\n Option 1: 0.5 ohm parallel/parallel \n Option 2: 2 ohm series/parallel \n Option 3: 8 ohm series";
                    break;
                case 3:
                    impedanceResult = 1.34;
                    result = "\n Option 1: 1.34 ohm series/parallel \n Option 2: 3 ohm parallel/series \n Option 3: 12 ohm series (not recommended)";
                    break;
                case 4:
                    impedanceResult = 1.0;
                    result = "\n Option 1: 1 ohm series/parallel \n Option 2: 4 ohm parallel/series";
                    break;
                default:
                    impedanceResult = 0.0;
                    result = "\n Invalid selection";
                    break;
            }
        } else if (selectedVoiceCoilImpedance == 4.0) {
            switch (selectedNumSpeakers) {
                case 1:
                    impedanceResult = 2.0;
                    result = "\n Option 1: 2 ohm parallel \n Option 2: 8 ohm series";
                    break;
                case 2:
                    impedanceResult = 1.0;
                    result = "\n Option 1: 1 ohm parallel/parallel \n Option 2: 4 ohm series/parallel";
                    break;
                case 3:
                    impedanceResult = 2.67;
                    result = "\n Option 1: 2.67 ohm series/parallel \n Option 2: 6 ohm parallel/series";
                    break;
                case 4:
                    impedanceResult = 0.5;
                    result = "\n Option 1: 0.5 ohm parallel \n Option 2: 2 ohm series/parallel \n Option 3: 8 ohm parallel/series";
                    break;
                default:
                    impedanceResult = 0.0;
                    result = "\n Invalid selection";
                    break;
            }
        } else if (selectedVoiceCoilImpedance == 6.0) {
            switch (selectedNumSpeakers) {
                case 1:
                    impedanceResult = 3.0;
                    result = "\n Option 1: 3 ohm parallel \n Option 2: 12 ohm series (not recommended)";
                    break;
                case 2:
                    impedanceResult = 1.5;
                    result = "\n Option 1: 1.5 ohm parallel/parallel \n Option 2: 6 ohm series/parallel";
                    break;
                case 3:
                    impedanceResult = 1.0;
                    result = "\n Option 1: 1 ohm parallel/parallel \n Option 2: 4 ohm series/parallel \n Option 3: 9 ohm parallel/series";
                    break;
                case 4:
                    impedanceResult = 0.75;
                    result = "\n Option 1: 0.75 ohm parallel \n Option 2: 3 ohm series/parallel \n Option 3: 12 ohm parallel/series (not recommended)";
                    break;
                default:
                    impedanceResult = 0.0;
                    result = "\n Invalid selection";
                    break;
            }
        } else if (selectedVoiceCoilImpedance == 8.0) {
            switch (selectedNumSpeakers) {
                case 1:
                    impedanceResult = 8.0;
                    result = "\n Option: 8 ohm standard";
                    break;
                case 2:
                    impedanceResult = 4.0;
                    result = "\n Option: 4 ohm parallel";
                    break;
                case 3:
                    impedanceResult = 2.67;
                    result = "\n Option: 2.67 ohm parallel";
                    break;
                case 4:
                    impedanceResult = 2.0;
                    result = "\n Option 1: 2 ohm parallel \n Option 2: 8 ohm series/parallel";
                    break;
                default:
                    impedanceResult = 0.0;
                    result = "\n Invalid selection";
                    break;
            }
        }

        else if (selectedVoiceCoilImpedance == 9.0) {
            switch (selectedNumSpeakers) {
                case 1:
                    impedanceResult = 4.0;
                    result = "\n Option: 8 ohm standard";
                    break;
                case 2:
                    impedanceResult = 2;
                    result = "\n Option 1: 2 ohm parallel  \n Option 2: 8 ohm series";
                    break;
                case 3:
                    impedanceResult = 1.34;
                    result = "\n Option 1: 1.34 ohm parallel \n Option 2: 12 ohm";
                    break;
                case 4:
                    impedanceResult = 1.0;
                    result = "\n Option 1: 1 ohm parallel \n Option 2: 4 ohm series/parallel";
                    break;
                default:
                    impedanceResult = 0.0;
                    result = "\n Invalid selection";
                    break;
            }}

        else {
            impedanceResult = 0.0;
            result = "Invalid selection";
        }

        if (selectedNumSpeakers == 1){
            textViewResult.setText("Speaker Quantity: " + selectedNumSpeakers + " speaker" +
                    "\nVoice Coil/s Impedance: " + selectedVoiceCoilImpedance + " ohm" +
                    "\n \nFinal Result: "  + result);
        }
        else {
            textViewResult.setText("Speaker Quantity: " + selectedNumSpeakers + " speakers" +
                "\nVoice Coil/s Impedance: " + selectedVoiceCoilImpedance + " ohm" +
                "\n \nFinal Result: " + result);
    }}
    

    private double getVoiceCoilImpedance(int position) {
        switch (position) {
            case 0:
                return 1.0;
            case 1:
                return 2.0;
            case 2:
                return 4.0;
            case 3:
                return 6.0;
            case 4:
                return 9.0-5.0;
            case 5:
                return 8.0;
            default:
                return 0.0;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the back button click
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
