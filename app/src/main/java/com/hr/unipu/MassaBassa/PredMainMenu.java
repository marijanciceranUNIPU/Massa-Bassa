package com.hr.unipu.MassaBassa;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PredMainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pred_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(PredMainMenu.this, EnterMainPage.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ChangeFragment(View view) {
        // Handle button click event here
        int id = view.getId();
        Intent intent;

        switch (id) {
            case R.id.PrviSelect:
                // Handle PrvaSlikaSelection button click
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.DrugiSelect:
                // Handle DrugaSlikaSelection button click
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.TreciSelect:
                // Handle TrecaSlikaSelection button click
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.CetvrtiSelect:
                // Handle CetvrtaSlikaSelection button click
                openAppInfo();
                break;
        }
    }

    public void openAppInfo() {
        Intent intent = new Intent(this, AboutApp.class);
        startActivity(intent);
    }
}
