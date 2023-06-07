package com.hr.unipu.MassaBassa;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable the back button

        recyclerView = findViewById(R.id.recyclerViewEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        eventList = new ArrayList<>();
        // Manually add events
        eventList.add(new Event("1. Tuning Car Meet Zadar 2023", "First Zadar car show this year, more than 500 cars and bikes expected, come and see us!.",
                "June 31, 2023", "12:00 AM - 16:00"));
        eventList.add(new Event("Style and Expo Rijeka 2023", "Tuning car style show in Kostrena near Rijeka. Second year in a row. Style, dB drag, 400m street race and so much more events waiting for you!",
                "August 17, 2023", "9:00 AM - 18:00"));
        eventList.add(new Event("Poreč Auto Moto Show 2023", "Burnt tires, smell of fuel, fast cars, that's what we do! Join us at this year's Auto Moto show in Poreč, 25. August 2023.",
                "August 25, 2023", "11:00 AM - 17:00"));
        eventList.add(new Event("Zagreb Season End", "Come to the capital city and join us for this final year's car show!",
                "September 18, 2023", "10:00 AM - 20:00"));

        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
