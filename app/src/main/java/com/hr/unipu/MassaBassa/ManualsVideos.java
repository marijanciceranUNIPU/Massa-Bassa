package com.hr.unipu.MassaBassa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ManualsVideos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ManualsVideosAdapter manualsVideosAdapter;
    private List<ManualVideoItem> manualVideoList;
    private List<ManualVideoItem> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuals_videos);

        recyclerView = findViewById(R.id.recyclerView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        manualVideoList = new ArrayList<>();
        filteredList = new ArrayList<>();

        manualVideoList.add(new ManualVideoItem("Webpage - Car Audio Fabrication", "CAF Webpage - tutorials, how-to, lessons and more!", "https://www.caraudiofabrication.com/learn","https://static.wixstatic.com/media/d26aba_d2cc7eca1e0c418182f355931909eb57~mv2.jpg/v1/fill/w_454,h_255,fp_0.50_0.50,q_90,enc_auto/d26aba_d2cc7eca1e0c418182f355931909eb57~mv2.jpg"));
        manualVideoList.add(new ManualVideoItem("Webpage - Crutchfield", "Online retailer and resource for consumer electronics that specializes in providing expert advice and support for audio and video products.", "https://www.crutchfield.com/S-54FGDVg7qMl/","https://images.crutchfieldonline.com/ImageBank/v20190322131200/social-media/og-meta.jpg"));
        manualVideoList.add(new ManualVideoItem("Webpage - Masori", "Europe's Largest Carhifi Shop - Masori", "https://masori.de/en","https://cdn.shopify.com/s/files/1/0271/9478/5927/products/powered-by-masori-sticker-369_400x.webp?v=1675467768"));
        manualVideoList.add(new ManualVideoItem("Video - Wiring a Car Stereo and Speakers, Amp, & Sub made EASY for Beginners", "Did you like this video?  If so, please consider becoming a Patreon...", "https://www.youtube.com/watch?v=72Tmq8S71F0&pp=ygURY2FyIGF1ZGlvIGNoYW5uZWw%3D","https://i3.ytimg.com/vi/72Tmq8S71F0/maxresdefault.jpg"));
        manualVideoList.add(new ManualVideoItem("Video - How to install an amp and sub in your car?", "This video shows you a typical installation and the tools and best practices that'll help your project become a success. ", "https://www.youtube.com/watch?v=eidK7FNI0GA&ab_channel=CRUTCHFIELD","https://i3.ytimg.com/vi/eidK7FNI0GA/maxresdefault.jpg"));
        manualVideoList.add(new ManualVideoItem("Video - Avoid these 5 common Car Audio NOOB Mistakes!", "How can we better install our subwoofers, amplifier, radio, speakers and wiring? Avoid these five mistakes! ", "https://www.youtube.com/watch?v=1FTsmUCbvoM","https://i3.ytimg.com/vi/1FTsmUCbvoM/maxresdefault.jpg"));
        manualVideoList.add(new ManualVideoItem("YouTube Channel - EXOcontralto", "Bass videos, bass builds, car audio advice and much more!", "https://www.youtube.com/@EXOcontralto","https://yt3.googleusercontent.com/ytc/AGIKgqOvKL5WkSWlEj46Q_LwSs6XKHbTTmGvQWcBJIIv=s176-c-k-c0x00ffffff-no-rj-mo"));
        manualVideoList.add(new ManualVideoItem("YouTube Channel - LIFEOFPRICE", "Crazy basshead videos, competitions, webshop announcements, car audio advice and much more!", "https://www.youtube.com/@THELIFEOFPRICE","https://yt3.googleusercontent.com/ytc/AGIKgqNtyrD65lTCOPodDh4A3xYjMT3vQllcGAf20lTeOA=s176-c-k-c0x00ffffff-no-rj"));
        manualVideoList.add(new ManualVideoItem("YouTube Channel - meade916", "Customization and enhancement of car audio systems, build videos and so much to explore!", "https://www.youtube.com/@meade916","https://yt3.googleusercontent.com/sAAkcnvSxd2VlBq7Dg3TTUPL-wjwLdJV_Srydig5j9a-NsVbtPKEzIbgu7UW27eij66KnW4GDw=s176-c-k-c0x00ffffff-no-rj"));

        filteredList.addAll(manualVideoList);

        manualsVideosAdapter = new ManualsVideosAdapter(filteredList);
        recyclerView.setAdapter(manualsVideosAdapter);

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterItems(newText);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Handle back button press
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void filterItems(String query) {
        filteredList.clear();

        for (ManualVideoItem item : manualVideoList) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase())
                    || item.getDescription().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }

        manualsVideosAdapter.notifyDataSetChanged();
    }
}