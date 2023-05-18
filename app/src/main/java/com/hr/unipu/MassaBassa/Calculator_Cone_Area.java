package com.hr.unipu.MassaBassa;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator_Cone_Area extends AppCompatActivity {

    private EditText numSubsEditText;
    private EditText subSizeEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_conearea);

        numSubsEditText = findViewById(R.id.numSubsEditText);
        subSizeEditText = findViewById(R.id.subSizeEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Set resultTextView to be invisible if number of subs and size of subs are empty
        if (numSubsEditText.getText().toString().equals("") && subSizeEditText.getText().toString().equals("")) {
            resultTextView.setVisibility(View.GONE);
        }

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateConeArea();
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
    private void calculateConeArea() {
        String numSubsStr = numSubsEditText.getText().toString();
        String subSizeStr = subSizeEditText.getText().toString();

        if (numSubsStr.isEmpty() || subSizeStr.isEmpty()) {
            resultTextView.setText(R.string.error_message);
            resultTextView.setVisibility(View.VISIBLE);
            return;
        }

        int numSubs = Integer.parseInt(numSubsStr);
        double sizeSubs = Double.parseDouble(subSizeStr);
        double coneArea = Math.PI * (sizeSubs / 2) * (sizeSubs / 2) * numSubs;
        String resultMessage = String.format("The cone area is %.2f square units.\n", coneArea);
        resultTextView.setVisibility(View.VISIBLE);
        resultTextView.setText(resultMessage);
    }
}
