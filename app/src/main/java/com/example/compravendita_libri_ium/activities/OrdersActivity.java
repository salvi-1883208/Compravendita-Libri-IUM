package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.MyActiveOrders;
import com.example.compravendita_libri_ium.Order;
import com.example.compravendita_libri_ium.OrdersListAdapter;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityOrdersOrAdsBinding;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    private ActivityOrdersOrAdsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Ordini Effettuati");

        binding = ActivityOrdersOrAdsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Order> orderArrayList = MyActiveOrders.getInstance().getOrders();

        OrdersListAdapter ordersListAdapter = new OrdersListAdapter(OrdersActivity.this, orderArrayList);

        binding.listview.setAdapter(ordersListAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(OrdersActivity.this, BookProfileActivity.class);
            intent.putExtra("order", orderArrayList.get(position));
            startActivity(intent);
        });

        binding.newOrderOrAd.setOnClickListener(view -> {
            Intent intent = new Intent(OrdersActivity.this, NewOrderCourseActivity.class);
            intent.putExtra("start", false);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        menu.clear();
        inflater.inflate(R.menu.close_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.close_button:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
