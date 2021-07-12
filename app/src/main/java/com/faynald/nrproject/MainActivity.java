package com.faynald.nrproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtAngka1, edtAngka2;
    private TextView tvHasil;
    Dialog dialogNull;

    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAngka1 = findViewById(R.id.edt_angka1);
        edtAngka2 = findViewById(R.id.edt_angka2);
        Button btnHitung = findViewById(R.id.btn_hitung);
        btnHitung.setOnClickListener(this);
        tvHasil = findViewById(R.id.tv_hasil);

        Button btnPindah = findViewById(R.id.btn_pindah_activity);
        btnPindah.setOnClickListener(this);
        Button btnPindahData = findViewById(R.id.btn_pindah_activity_dengan_data);
        btnPindahData.setOnClickListener(this);
        Button btnImplicit = findViewById(R.id.btn_implicit);
        btnImplicit.setOnClickListener(this);
        Button btnIphone = findViewById(R.id.btn_iphone);
        btnIphone.setOnClickListener(this);
        Button btnRecyclerView = findViewById(R.id.btn_recycle_view);
        btnRecyclerView.setOnClickListener(this);



        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_HASIL);
            tvHasil.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_HASIL, tvHasil.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung){
            boolean apakahEmpty = false;
            String angka1 = edtAngka1.getText().toString();
            String angka2 = edtAngka2.getText().toString();

            if(TextUtils.isEmpty(angka1)) {
                apakahEmpty = true;
                edtAngka1.setError("Harap diisi");
            }

            if (TextUtils.isEmpty(angka2)){
                apakahEmpty = true;
                edtAngka2.setError("Harap diisi");
            }

            if (!apakahEmpty){
                Double doubleHasil = Double.parseDouble(angka1) + Double.parseDouble(angka2);
                String strHasil = String.valueOf(doubleHasil);
                if(strHasil.endsWith(".0")){
                    strHasil = strHasil.substring(0, strHasil.length() - 2);
                }
                Resources res = getResources();
                strHasil = res.getString(R.string.hasil) + strHasil;
                tvHasil.setText(strHasil);
            }
        }
        if (v.getId() == R.id.btn_pindah_activity){
            Intent pindahIntent = new Intent(MainActivity.this, PndActivity.class);
            startActivity(pindahIntent);
        }else if (v.getId() == R.id.btn_pindah_activity_dengan_data){
            Intent pindahIntentData = new Intent(MainActivity.this, MDataActivity.class);
            pindahIntentData.putExtra(MDataActivity.EXTRA_NAME, "Farhan");
            pindahIntentData.putExtra(MDataActivity.EXTRA_AGE, 20);
            startActivity(pindahIntentData);
        }else if (v.getId() == R.id.btn_implicit){
            String phoneNumber = "081392290314";
            Intent keDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(keDial);
        }else if (v.getId() == R.id.btn_iphone){
            Intent pindahIntent = new Intent(MainActivity.this, ShowDetailActivity.class);
            startActivity(pindahIntent);
        }else if (v.getId() == R.id.btn_recycle_view){
            Intent pindahIntent = new Intent(MainActivity.this, ChooseProduct.class);
            startActivity(pindahIntent);
        }
    }

    public void tutupDialog(View v){
        dialogNull.dismiss();
    }
}