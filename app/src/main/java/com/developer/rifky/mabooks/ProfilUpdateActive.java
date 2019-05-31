package com.developer.rifky.mabooks;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Rifky on 07-Jan-18.
 */

public class ProfilUpdateActive extends AppCompatActivity {
    EditText judul, pemin, no_hp, dipin;
    Button btn_update;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_update);
        Toolbar toolbar = findViewById(R.id.toolbar_dua);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Edit Daftar Buku");

        openData();
        judul = findViewById(R.id.editjudul2);
        pemin = findViewById(R.id.editpeminjam2);
        no_hp = findViewById(R.id.editnohp2);
        dipin = findViewById(R.id.editdipinjam2);
        btn_update = findViewById(R.id.simpan);

        Bundle test = getIntent().getExtras();
        judul.setText(test.getString("judul",""));
        pemin.setText(test.getString("peminjam",""));
        no_hp.setText(test.getString("nohp",""));
        dipin.setText(test.getString("dipinjam",""));
        final String yoi = test.getString("id","");

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("judul", judul.getText().toString());
                values.put("peminjam", pemin.getText().toString());
                values.put("nohp", no_hp.getText().toString());
                values.put("dipinjam", dipin.getText().toString());
                long data = database.update("dafbuku", values,"id=?", new String []{yoi});

                if (data !=-1) {
                    Toast.makeText(ProfilUpdateActive.this,"Buku berhasil diedit!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (ProfilUpdateActive.this, ProfilLihatActive.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void openData() {
        DataHelper buku = new DataHelper(ProfilUpdateActive.this);
        database = buku.getWritableDatabase();
    }
}
