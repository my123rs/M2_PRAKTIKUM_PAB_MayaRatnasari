package com.example.modul2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int gajiStatus, gajiGolongan;
    String cekStatus, cekGol;
    RadioGroup golongan;
    RadioButton selectedGol;
    CheckBox status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void hitung (View v){
        EditText nama = (EditText) findViewById (R.id.nama);
        TextView outputNama = (TextView) findViewById (R.id.outputNama);
        String name = nama.getText().toString();
        outputNama.setText("Total Gaji Anda "+name);

        golongan = (RadioGroup) findViewById (R.id.rgGolongan);
        int gol = golongan.getCheckedRadioButtonId();
        if (gol == R.id.rbGolongan1){
            gajiGolongan = 1000000;
            selectedGol = findViewById(gol);
            cekGol = selectedGol.getText().toString();
        }else if (gol == R.id.rbGolongan2){
            gajiGolongan = 2000000;
            selectedGol = findViewById(gol);
            cekGol = selectedGol.getText().toString();
        }
        status = (CheckBox) findViewById (R.id.menikah);
        if (status.isChecked()) {
            cekStatus = status.getText().toString();
            gajiStatus = 500000;
        } else {
            gajiStatus = 0;
            cekStatus = "Belum Menikah";
        };

        int totalGaji = gajiStatus+gajiGolongan;
        TextView total = (TextView) findViewById (R.id.outputGaji);
        TextView tStatus = (TextView) findViewById(R.id.outputStatus);
        TextView tGolongan = (TextView) findViewById(R.id.outputGolongan);
        total.setText(String.valueOf(totalGaji));
        tStatus.setText("Status Anda : "+cekStatus);
        tGolongan.setText(String.valueOf(cekGol));

    }
}