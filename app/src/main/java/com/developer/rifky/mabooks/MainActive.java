package com.developer.rifky.mabooks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActive extends AppCompatActivity implements View.OnClickListener {

    EditText nama, sandi;
    Button alert, login;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama = (EditText) findViewById(R.id.editText);
        sandi = (EditText) findViewById(R.id.editText2);
        alert = (Button) findViewById(R.id.getlogin);
        alert.setOnClickListener(this);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        preferences = getSharedPreferences("Masuk", MODE_PRIVATE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                if (nama.getText().toString().equalsIgnoreCase("namaanda") && sandi.getText().toString().equalsIgnoreCase("sandiku")){
                    SharedPreferences.Editor lain = preferences.edit();
                    lain.putString("user", nama.getText().toString());
                    lain.putString("password", sandi.getText().toString());
                    lain.commit();
                    Intent i = new Intent(MainActive.this, HomeActive.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActive.this, "Mohon diisi dengan benar.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        // TODO Auto-generated method stub
        if(view==alert){
            new AlertDialog.Builder(this)
                    .setTitle("Nama dan Kata Sandi")
                    .setMessage("Nama User  : namaanda\nPassword    : sandiku")
                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dlg, int sumthin) {
                            // TODO Auto-generated method stub
                        }
                    })
                    .show();
        }
    }
}
