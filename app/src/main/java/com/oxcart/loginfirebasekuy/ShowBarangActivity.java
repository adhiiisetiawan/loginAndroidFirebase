package com.oxcart.loginfirebasekuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ShowBarangActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;
    List<Barang> list = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewBarangAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_barang);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowBarangActivity.this));

        progressDialog = new ProgressDialog(ShowBarangActivity.this);
        progressDialog.setMessage("Loading Data from Firebase Database");
        progressDialog.show();

//        databaseReference = FirebaseDatabase.getInstance().getReference(MainActivity.Database_Path);
    }
}
