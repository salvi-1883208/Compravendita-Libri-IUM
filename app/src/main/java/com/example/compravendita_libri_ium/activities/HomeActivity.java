package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.compravendita_libri_ium.Ad;
import com.example.compravendita_libri_ium.Book;
import com.example.compravendita_libri_ium.Books;
import com.example.compravendita_libri_ium.ListAdapter;
import com.example.compravendita_libri_ium.Order;
import com.example.compravendita_libri_ium.Orders;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.UsedBook;
import com.example.compravendita_libri_ium.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private Button button_ordini_eff;
    private Button button_annunci_ins;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("Sezione compravendita libri");

        //button_ordini_eff = findViewById(R.id.button_ordini_eff);
        button_ordini_eff.setOnClickListener(view -> openOrdersList());

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.lezioni_di_fisica_front};

        ArrayList<Order> ordersArrayList = new ArrayList<>();

        //aggiungo gli ordini all'arraylist
        ordersArrayList.add(0, Orders.ALGORITMI_STR_DAT.getOrder());
        ordersArrayList.add(1, Orders.ELEMENTI_FISICA.getOrder());

        String[] bookTitles = new String[7];


        // for loop for images https://youtu.be/RHqGiWluAzU?t=766

        ListAdapter listAdapter = new ListAdapter(HomeActivity.this, ordersArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(HomeActivity.this, OrdersActivity.class);
                intent.putExtra("title", ordersArrayList.get(i).getAdBase().getBook().getTitle());
                intent.putExtra("author", ordersArrayList.get(i).getAdBase().getBook().getAuthor());
                intent.putExtra("edition", ordersArrayList.get(i).getAdBase().getBook().getEdition());
                intent.putExtra("publisher", ordersArrayList.get(i).getAdBase().getBook().getPublisher());
                intent.putExtra("isbn", ordersArrayList.get(i).getAdBase().getBook().getIsbn());
                intent.putExtra("subject", ordersArrayList.get(i).getAdBase().getBook().getSubject());
                intent.putExtra("condition", ordersArrayList.get(i).getAdBase().getBook().getCondition());
                intent.putExtra("sub condition", ordersArrayList.get(i).getAdBase().getBook().getSubCondition());
                intent.putExtra("price", ordersArrayList.get(i).getAdBase().getPrice());
                intent.putExtra("meeting place", ordersArrayList.get(i).getAdBase().getMeetingPlace());
                intent.putExtra("seller", ordersArrayList.get(i).getSeller().getName());
                intent.putExtra("time remaining", ordersArrayList.get(i).getTimeRemaining());
                startActivity(intent);

            }
        });

        button_annunci_ins = findViewById(R.id.button_annunci_ins);
        button_annunci_ins.setOnClickListener(view -> openAdsList());

    }

    private void openOrdersList(){
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }

    private void openAdsList() {
        Intent intent = new Intent(this, AdsActivity.class);
        startActivity(intent);
    }
}