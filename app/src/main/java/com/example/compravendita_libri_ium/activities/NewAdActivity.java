package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.compravendita_libri_ium.Book;
import com.example.compravendita_libri_ium.BooksToSell;
import com.example.compravendita_libri_ium.NewAdBuilder;
import com.example.compravendita_libri_ium.NewAdListAdapter;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityNewAdBinding;

import java.util.ArrayList;

public class NewAdActivity extends AppCompatActivity {

    private ArrayList<Book> booksToSell = BooksToSell.getInstance().getBooks();
    private String[] bookNames = new String[booksToSell.size()];
    private String[] bookEditions = new String[booksToSell.size()];
    private ActivityNewAdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Passo 1: Selezione libro");

        for (int i = 0; i < booksToSell.size(); i++) {
            bookNames[i] = booksToSell.get(i).getTitle();
        }

        for (int i = 0; i < booksToSell.size(); i++) {
            bookEditions[i] = Integer.toString(booksToSell.get(i).getEdition());
        }

        NewAdListAdapter adapter = new NewAdListAdapter(this, booksToSell);
        binding.searchListview.setAdapter(adapter);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {        //quando l'user fa enter
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {        //quando l'user comincia a scrivere
                adapter.getFilter().filter(s);
                return false;
            }
        });
        binding.searchListview.setOnItemClickListener((adapterView, view, position, l) -> {
            TextView textView = (TextView) view.findViewById(R.id.new_ad_book_infos);
            Button button = (Button) view.findViewById(R.id.new_ad_infos_button);

            if (button.getVisibility() == View.GONE) {
                textView.setText(booksToSell.get(position).getDescription());
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(view1 -> {
                    Intent intent = new Intent(NewAdActivity.this, SelectConditionActivity.class);
                    intent.putExtra("builder", new NewAdBuilder().setBook(booksToSell.get(position)));
                    startActivity(intent);
                });

            } else {
                button.setVisibility(View.GONE);
                textView.setText("Edizione: " + Integer.toString(booksToSell.get(position).getEdition()));
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