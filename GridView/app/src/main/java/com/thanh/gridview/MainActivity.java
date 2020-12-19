package com.thanh.gridview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Adapter adapter;
    ArrayList<Product> ProductArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Products List");

        Anhxa();
        adapter = new Adapter(this, R.layout.item_grid_view, ProductArr);
        gridView.setAdapter(adapter);
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                delete(i);
                return false;
            }
        });
    }

    private void delete(final int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Warning!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Do you want to delete this?");
        alertDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ProductArr.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }

    private void Anhxa() {
        gridView = (GridView) findViewById(R.id.grid_view);
        ProductArr = new ArrayList<>();
        ProductArr.add(new Product("Acer Predator", "$2000", R.drawable.acer));
        ProductArr.add(new Product("Dell Alienware", "$2500", R.drawable.alien));
        ProductArr.add(new Product("Dell XPS 9300", "$3000", R.drawable.xps));
        ProductArr.add(new Product("Asus TUF 15", "$1500", R.drawable.asus));
        ProductArr.add(new Product("Thinkpad X1", "$1700", R.drawable.thinkpad));
        ProductArr.add(new Product("Dell G3", "$2100", R.drawable.dell));
    }
}