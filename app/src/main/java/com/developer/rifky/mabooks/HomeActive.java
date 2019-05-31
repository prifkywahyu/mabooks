package com.developer.rifky.mabooks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rifky on 27-Dec-17.
 */

public class HomeActive extends AppCompatActivity implements View.OnClickListener {

    Button toprofil, cari, tentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        Toolbar toolbar = findViewById (R.id.toolbar_dua);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mabooks");

        toprofil = findViewById(R.id.btn_profil);
        toprofil.setOnClickListener(this);
        cari = findViewById(R.id.btn_caribuku);
        cari.setOnClickListener(this);
        tentang = findViewById(R.id.btn_tentang);
        tentang.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.fab:
                        Intent fab = new Intent(HomeActive.this, ProfilBuatActive.class);
                        startActivity(fab);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_profil:
                Intent p = new Intent(HomeActive.this, ProfilLihatActive.class);
                startActivity(p);
                break;
            case R.id.btn_caribuku:
                Intent cari = new Intent(Intent.ACTION_VIEW);
                cari.setData(Uri.parse("https://www.gramedia.com"));
                startActivity(cari);
                break;
            case R.id.btn_tentang:
                Intent t = new Intent(HomeActive.this, TentangMabooks.class);
                startActivity(t);
                break;
        }
    }
}
