package com.hr.unipu.MassaBassa;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button PrvaSlikaSelection;
    private Button DrugaSlikaSelection;
    private Button TrecaSlikaSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrvaSlikaSelection = (Button)findViewById(R.id.PrvaSlikaSelection);
        DrugaSlikaSelection = (Button)findViewById(R.id.DrugaSlikaSelection);
        TrecaSlikaSelection = (Button)findViewById(R.id.TrecaSlikaSelection);

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

        TrecaSlikaSelection.setOnClickListener(new View.OnClickListener() { // Activity, treca biljka opis
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
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

        if (view == findViewById(R.id.TrecaSlikaSelection)){
            fragment = new Fragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
    }
}
