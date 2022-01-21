package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.compravendita_libri_ium.Ad;
import com.example.compravendita_libri_ium.ListAdapter;
import com.example.compravendita_libri_ium.Order;
import com.example.compravendita_libri_ium.Orders;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_orders);
        getSupportActionBar().setTitle("Ordini Effettuati");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Order> orderArrayList = new ArrayList<>();

        //Riempio una lista con tutti gli ordini da mostrare
        for (Orders order: Orders.values()) {
            orderArrayList.add(order.getOrder());
        }

        ListAdapter listAdapter = new ListAdapter(OrdersActivity.this, orderArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OrdersActivity.this, BookProfileActivity.class);
                intent.putExtra("order", orderArrayList.get(position));
                startActivity(intent);
            }
        });

    }
}