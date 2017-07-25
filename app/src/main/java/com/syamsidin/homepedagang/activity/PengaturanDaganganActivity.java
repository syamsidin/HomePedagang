package com.syamsidin.homepedagang.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.syamsidin.homepedagang.R;


public class PengaturanDaganganActivity extends AppCompatActivity {

    RadioButton rb1;
    RadioButton rb2;

    ImageButton tambah,edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Pengaturan Dagangan");
        setContentView(R.layout.activity_pengaturan_dagangan);

        final RadioGroup radio = (RadioGroup)findViewById(R.id.radioType);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radio.findViewById(checkedId);
                int index = radio.indexOfChild(radioButton);

                // Add logic here

                switch (index) {
                    case 0: // first button

                        AlertDialog.Builder builder = new AlertDialog.Builder(PengaturanDaganganActivity.this);
                        builder.setMessage("Apakah anda yakin akan mengubah type dagangan ?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                        Toast.makeText(getApplicationContext(), "Anda memilih diam!",
                                Toast.LENGTH_LONG).show();
                        break;

                    case 1: // secondbutton

                        AlertDialog.Builder builder2 = new AlertDialog.Builder(PengaturanDaganganActivity.this);
                        builder2.setMessage("Apakah anda yakin akan mengubah type dagangan ?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert2 = builder2.create();
                        alert2.show();
                        Toast.makeText(getApplicationContext(), "anda memeilih berkeliling!",
                                Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        tambah = (ImageButton)findViewById(R.id.btn_tambah);
        edit = (ImageButton)findViewById(R.id.edit_produk);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PengaturanDaganganActivity.this,TambahProdukActivity.class);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PengaturanDaganganActivity.this,EditProdukActivity.class);
                startActivity(intent);
            }
        });
    }

}
