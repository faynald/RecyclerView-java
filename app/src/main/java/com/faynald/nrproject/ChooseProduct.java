package com.faynald.nrproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class ChooseProduct extends AppCompatActivity {
    private RecyclerView rvIphone;
    private ArrayList<iphone> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_product);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        rvIphone = findViewById(R.id.rv_iphone_list);
        rvIphone.setHasFixedSize(true);

        list.addAll(iphoneData.getListData());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showRecyclerList() {
        rvIphone.setLayoutManager(new LinearLayoutManager(this));
        ListIphoneAdapter listIphoneAdapter = new ListIphoneAdapter(list);
        rvIphone.setAdapter(listIphoneAdapter);

        listIphoneAdapter.setOnItemClickCallback(new ListIphoneAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(iphone data) {
                showSelectedIphone(data);
            }
        });
    }

    private void showRecyclerGrid() {
        rvIphone.setLayoutManager(new GridLayoutManager(this,2));
        GridIphoneAdapter gridIphoneAdapter = new GridIphoneAdapter(list);
        rvIphone.setAdapter(gridIphoneAdapter);

        gridIphoneAdapter.setOnItemClickCallback(new GridIphoneAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(iphone data) {
                showSelectedIphone(data);
            }
        });
    }

    private void showRecyclerCardView() {
        rvIphone.setLayoutManager(new LinearLayoutManager(this));
        CardViewIphoneAdapter cardViewIphoneAdapter = new CardViewIphoneAdapter(list);
        rvIphone.setAdapter(cardViewIphoneAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
    
    private void showSelectedIphone(iphone ipin) {
        Toast.makeText(this, "Kamu memilih " + ipin.getName(), Toast.LENGTH_SHORT).show();
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
    }
}