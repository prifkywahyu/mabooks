package com.developer.rifky.mabooks;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.developer.rifky.mabooks.modeling.ModelUser;

import java.util.ArrayList;

/**
 * Created by Rifky on 07-Jan-18.
 */

public class ProfilLihatActive extends AppCompatActivity {
    ListView list;
    SQLiteDatabase database;
    AdapterUser adapter;

    ArrayList<ModelUser> buku = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_main);
        Toolbar toolbar = findViewById(R.id.toolbar_dua);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lihat Daftar Buku");

        openData();
        adapter = new AdapterUser(this, R.layout.profil_lihat);
        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int bukani, long l) {
                final String selection = buku.get(bukani).getId().toString();
                final String[] option = {"Update Buku", "Hapus Buku"};

                final AlertDialog.Builder dialog = new AlertDialog.Builder(ProfilLihatActive.this);
                dialog.setTitle("Opsi Daftar Buku");
                dialog.setItems(option, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent update = new Intent(ProfilLihatActive.this, ProfilUpdateActive.class);
                                Bundle edit = new Bundle();
                                edit.putString("id", buku.get(bukani).getId().toString());
                                edit.putString("judul", buku.get(bukani).getJudul());
                                edit.putString("peminjam", buku.get(bukani).getPeminjam());
                                edit.putString("nohp", buku.get(bukani).getNohp());
                                edit.putString("dipinjam", buku.get(bukani).getDipinjam());
                                update.putExtras(edit);
                                startActivity(update);
                                break;

                            case 1:
                                final AlertDialog.Builder dialogHapus = new AlertDialog.Builder(ProfilLihatActive.this);

                                dialogHapus.setTitle("Hapus Buku");
                                dialogHapus.setMessage("Anda yakin ingin menghapus ini?");
                                dialogHapus.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int z) {
                                        database.delete("dafbuku","id=?", new String[] {selection});
                                        Intent hapus = new Intent(ProfilLihatActive.this, HomeActive.class);
                                        startActivity(hapus);

                                        refreshData();
                                    }
                                });
                                dialogHapus.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                                dialogHapus.show();
                                break;
                        }
                    }
                });
                dialog.create().show();
                return false;
            }
        });
        ((ArrayAdapter)list.getAdapter()).notifyDataSetInvalidated();
        refreshData();
    }

    public void refreshData() {
        Cursor cursor = database.query(false, "dafbuku", null, null, null, null,
                null, "judul", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                ModelUser user = new ModelUser();
                user.setId(cursor.getInt(0));
                user.setJudul(cursor.getString(1));
                user.setPeminjam(cursor.getString(2));
                user.setNohp(cursor.getString(3));
                user.setDipinjam(cursor.getString(4));
                buku.add(user);
            } while (cursor.moveToNext());
        }
        adapter.addAll(buku);
        adapter.notifyDataSetChanged();
    }

    public void openData() {
        DataHelper buku = new DataHelper(ProfilLihatActive.this);
        database = buku.getWritableDatabase();
    }
}
