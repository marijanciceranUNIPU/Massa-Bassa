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
        int id = view.getId();
        Intent intent;

        switch (id) {
            case R.id.PrviSelect:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.DrugiSelect:
                intent = new Intent(this, ManualsVideos.class);
                startActivity(intent);
                break;
            case R.id.thirdselect:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.CetvrtiSelect:
                intent = new Intent(this, AboutApp.class);
                startActivity(intent);
                break;
        }
    }
}
