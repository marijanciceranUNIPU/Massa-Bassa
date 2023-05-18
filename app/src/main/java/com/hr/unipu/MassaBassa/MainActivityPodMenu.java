package com.hr.unipu.MassaBassa;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPodMenu extends AppCompatActivity {
    private Button PrvaSlikaSelection;
    private Button DrugaSlikaSelection;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_podmenu);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        PrvaSlikaSelection = (Button)findViewById(R.id.PrvaSlikaSelection);
        DrugaSlikaSelection = (Button)findViewById(R.id.DrugaSlikaSelection);

        PrvaSlikaSelection.setOnClickListener(new View.OnClickListener() { // Activity, prva biljka opis
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        DrugaSlikaSelection.setOnClickListener(new View.OnClickListener() { // Activity, druga biljka opis
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity(){
        Intent intent = new Intent(this,Calculator_Cone_Area.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Calculator_Different_Cone_Area.class);
        startActivity(intent);
    }

    public void ChangeFragment(View view){
        Fragment fragment;
        if (view == findViewById(R.id.PrvaSlikaSelection)){
            fragment = new Menu_Fragment_AmpPowerCalculator();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.DrugaSlikaSelection)){
            fragment = new Menu_Fragment_MidsAndHighsCalculator();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
    }
}
