package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.compravendita_libri_ium.Book;
import com.example.compravendita_libri_ium.BooksToSell;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityNewAdBinding;

import java.util.ArrayList;
import java.util.List;

public class NewAdActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Book> booksToSell = BooksToSell.getInstance().getBooks();
    String[] bookNames = new String[booksToSell.size()];
    ArrayAdapter<String> arrayAdapter;
    private ActivityNewAdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Inserisci annuncio");

        for (int i = 0; i < booksToSell.size(); i++) {
            bookNames[i] = booksToSell.get(i).getTitle();
        }

        listView = findViewById(R.id.search_listview);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bookNames);
        listView.setAdapter(arrayAdapter);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {        //quando l'user fa enter
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {        //quando l'user comincia a scrivere
                arrayAdapter.getFilter().filter(s);
                return false;
            }
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