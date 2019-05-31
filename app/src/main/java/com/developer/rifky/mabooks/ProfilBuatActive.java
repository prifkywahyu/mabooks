package com.developer.rifky.mabooks;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

/**
 * Created by Rifky on 26-Dec-17.
 */

public class ProfilBuatActive extends AppCompatActivity implements View.OnClickListener {
    private SQLiteDatabase sqLiteDatabase;

    EditText a, b, c, d;
    Button kirim;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_buat);
        Toolbar toolbar = findViewById(R.id.toolbar_dua);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Buat Daftar Buku");

        openDatabase();
        a = (EditText) findViewById(R.id.editjudul);
        b = (EditText) findViewById(R.id.editpeminjam);
        c = (EditText) findViewById(R.id.editnohp);
        d = (EditText) findViewById(R.id.editdipinjam);
        kirim = findViewById(R.id.kirimbro);
        kirim.setOnClickListener(this);
        preferences = getSharedPreferences("Buat", MODE_PRIVATE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.kirimbro:
                if (a.getText().length() > 0 && b.getText().length() > 0 && c.getText().length() > 0 && d.getText().length() >0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("judul", a.getText().toString());
                    contentValues.put("peminjam", b.getText().toString());
                    contentValues.put("nohp", c.getText().toString());
                    contentValues.put("dipinjam", d.getText().toString());
                    long test = sqLiteDatabase.insert("dafbuku", null, contentValues);

                    if (test != -1) {
                        Toast.makeText(ProfilBuatActive.this, "Judul Buku " + a.getText().toString() + " berhasil disimpan.", Toast.LENGTH_SHORT).show();
                        String Text = "";
                    }
                }
                break;
        }
    }

    public void openDatabase() {
        DataHelper buku = new DataHelper(ProfilBuatActive.this);
        sqLiteDatabase = buku.getWritableDatabase();
    }
}
