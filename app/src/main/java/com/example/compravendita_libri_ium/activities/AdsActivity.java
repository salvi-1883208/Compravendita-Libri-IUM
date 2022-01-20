package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.compravendita_libri_ium.Ad;
import com.example.compravendita_libri_ium.BookCondition;
import com.example.compravendita_libri_ium.BookSubCondition;
import com.example.compravendita_libri_ium.Books;
import com.example.compravendita_libri_ium.MeetingPlace;
import com.example.compravendita_libri_ium.R;
import java.util.ArrayList;

public class AdsActivity extends AppCompatActivity {

    private ListView listView;

    private ArrayList<Ad> ads = new ArrayList<>();

    private ArrayAdapter<Ad> arrayAdapter;

    private final AdapterView.OnItemClickListener messageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            // Do something in response to the click
            Intent intent = new Intent(AdsActivity.this, SelectedFromListActivity.class);

            String selectedName = listView.getItemAtPosition(position).toString();

            //Like a dictionary
            intent.putExtra("SELECTED", selectedName);

            //Start the next activity
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getAds();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);

        listView = findViewById(R.id.listview_ads);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ads);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(messageClickedHandler);
    }

    private void getAds() {
        Ad ad1 = new Ad(Books.FISICA_II_2008.getBook().toUsedBook(BookCondition.BUONE_CONDIZIONI, BookSubCondition.SOTT_EVIDENZ),
                30.0, null, MeetingPlace.FERMI);
        System.out.println(ad1);
        ads.add(ad1);
        ads.add(new Ad(Books.FISICA_I_2008.getBook().toUsedBook(BookCondition.BUONE_CONDIZIONI, BookSubCondition.SOTT_MATITA_O_PENNA),
                35.0, null, MeetingPlace.FERMI));
    }
}