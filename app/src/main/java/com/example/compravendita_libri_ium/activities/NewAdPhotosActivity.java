package com.example.compravendita_libri_ium.activities;

import static com.example.compravendita_libri_ium.RecyclerViewAddPhotoAdapter.SELECT_PICTURE;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.compravendita_libri_ium.NewAdBuilder;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.RecyclerViewAddPhotoAdapter;
import com.example.compravendita_libri_ium.databinding.ActivityNewAdPhotosBinding;

import java.util.ArrayList;

public class NewAdPhotosActivity extends AppCompatActivity {

    private ActivityNewAdPhotosBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAdPhotosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NewAdBuilder builder = (NewAdBuilder) this.getIntent().getParcelableExtra("builder");

        RecyclerViewAddPhotoAdapter adapter = new RecyclerViewAddPhotoAdapter(this, new ArrayList<>(), binding.addPhotoContinuaButton);
        binding.recyclerPhotos.setAdapter(adapter);
        binding.recyclerPhotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        binding.addPhotoContinuaButton.setOnClickListener(view -> {
            Intent intent = new Intent(NewAdPhotosActivity.this, NewAdPriceActivity.class);
            intent.putExtra("builder", builder.setPhotos(((RecyclerViewAddPhotoAdapter) binding.recyclerPhotos.getAdapter()).getPhotos()));
            startActivity(intent);
        });

        if (builder.hasSubCondition())
            getSupportActionBar().setTitle("Passo 4: Foto del libro");
        else
            getSupportActionBar().setTitle("Passo 3: Foto del libro");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
            if (requestCode == SELECT_PICTURE) {
                Uri selectedPhotoUri = data.getData();
                if (null != selectedPhotoUri)
                    ((RecyclerViewAddPhotoAdapter) binding.recyclerPhotos.getAdapter()).addPhoto(selectedPhotoUri);
                ContentResolver contentResolver = this.getContentResolver();
                contentResolver.takePersistableUriPermission(selectedPhotoUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }

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