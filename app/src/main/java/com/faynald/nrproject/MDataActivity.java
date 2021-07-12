package com.faynald.nrproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MDataActivity extends AppCompatActivity {
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdata);

        TextView tvDataReceived = findViewById(R.id.tv_data_received);

        String nama = getIntent().getStringExtra(EXTRA_NAME);
        int umur = getIntent().getIntExtra(EXTRA_AGE, 0);

        String teks = "Nama : " + nama + "\nUmur : " + umur;
        tvDataReceived.setText(teks);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pindah Activity Dengan Data");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(menuItem);
    }
}