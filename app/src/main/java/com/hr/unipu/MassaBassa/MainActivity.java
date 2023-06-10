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

public class MainActivity extends AppCompatActivity {
    private Button FirstOptionSelection;
    private Button SecondOptionSelection;
    private Button ThirdOptionSelection;
    private Button FourthOptionSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        FirstOptionSelection = (Button)findViewById(R.id.FirstOptionSelection);
        SecondOptionSelection = (Button)findViewById(R.id.SecondOptionSelection);
        ThirdOptionSelection = (Button)findViewById(R.id.ThirdOptionSelection);
        FourthOptionSelection = (Button)findViewById(R.id.FourthOptionSelection);

        FirstOptionSelection.setOnClickListener(new View.OnClickListener() { // Activity, prva biljka opis
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        SecondOptionSelection.setOnClickListener(new View.OnClickListener() { // Activity, druga biljka opis
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        ThirdOptionSelection.setOnClickListener(new View.OnClickListener() { // Activity, treca biljka opis
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        FourthOptionSelection.setOnClickListener(new View.OnClickListener() { // Activity, treca biljka opis
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(MainActivity.this, PredMainMenu.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void openActivity(){
        Intent intent = new Intent(this,Calculator_Power_Amp.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent = new Intent(this,Calculator_Mids_n_Highs.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this,MainActivityPodMenu.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this,SubwooferWiringActivity.class);
        startActivity(intent);
    }

    public void ChangeFragment(View view){
        Fragment fragment;
        if (view == findViewById(R.id.FirstOptionSelection)){
            fragment = new Menu_Fragment_AmpPowerCalculator();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.SecondOptionSelection)){
            fragment = new Menu_Fragment_MidsAndHighsCalculator();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }

        if (view == findViewById(R.id.ThirdOptionSelection)){
            fragment = new Fragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.FourthOptionSelection)){
            fragment = new Fragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
    }
}
