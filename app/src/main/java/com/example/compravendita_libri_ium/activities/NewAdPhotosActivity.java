package com.example.compravendita_libri_ium.activities;

import static com.example.compravendita_libri_ium.BottomSheetDialog.REQUEST_IMAGE_CAPTURE;
import static com.example.compravendita_libri_ium.RecyclerViewAddPhotoAdapter.SELECT_PICTURE;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.compravendita_libri_ium.AdBase;
import com.example.compravendita_libri_ium.BottomSheetDialog;
import com.example.compravendita_libri_ium.NewAdBuilder;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.RecyclerViewAddPhotoAdapter;
import com.example.compravendita_libri_ium.databinding.ActivityNewAdPhotosBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class NewAdPhotosActivity extends AppCompatActivity {

    private ActivityNewAdPhotosBinding binding;
    private BottomSheetDialog bottomSheetDialog;

    public Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAdPhotosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bottomSheetDialog = new BottomSheetDialog(this);

        NewAdBuilder builder = this.getIntent().getParcelableExtra("builder");

        RecyclerViewAddPhotoAdapter adapter = new RecyclerViewAddPhotoAdapter(this, new ArrayList<>(), binding.addPhotoContinuaButton, bottomSheetDialog);

        //TODO FOTO STANDARD PER EVITARE DI DOVER METTERE LE FOTO NEI TEST DELL'APP (DA RIMUOVERE)
        //-------------------------------------------------------------------------------------------------------
        adapter.addPhotos(new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.image_for_tests))));
        //-------------------------------------------------------------------------------------------------------
        binding.recyclerPhotos.setAdapter(adapter);
        binding.recyclerPhotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        binding.addPhotoContinuaButton.setOnClickListener(view -> {
            Intent intent = new Intent(NewAdPhotosActivity.this, NewAdPriceActivity.class);
            intent.putExtra("builder", builder.setPhotos(((RecyclerViewAddPhotoAdapter) binding.recyclerPhotos.getAdapter()).getPhotos()));
            startActivity(intent);
        });

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_tool_bar);

        if (builder.hasSubCondition())
            ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Passo 4: Foto del libro");
        else
            ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Passo 3: Foto del libro");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            ((RecyclerViewAddPhotoAdapter) binding.recyclerPhotos.getAdapter()).addPhoto(uri);
            Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Images.Media.DATA, MediaStore.Images.Media.DATE_ADDED, MediaStore.Images.ImageColumns.ORIENTATION}, MediaStore.Images.Media.DATE_ADDED, null, "date_added ASC");
        }


        if (resultCode == RESULT_OK && null != data && requestCode == SELECT_PICTURE) {
            ContentResolver contentResolver = this.getContentResolver();
            //Se seleziono solo un'immagine
            if (data.getData() != null) {
                Uri selectedPhotoUri = data.getData();
                ((RecyclerViewAddPhotoAdapter) binding.recyclerPhotos.getAdapter()).addPhoto(selectedPhotoUri);
                contentResolver.takePersistableUriPermission(selectedPhotoUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else if (data.getClipData() != null) {
                //se seleziono più immagini
                ClipData clipData = data.getClipData();
                ArrayList<Uri> uris = new ArrayList<>();
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    ClipData.Item item = clipData.getItemAt(i);
                    Uri uri = item.getUri();
                    uris.add(uri);
                    contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                }
                ((RecyclerViewAddPhotoAdapter) binding.recyclerPhotos.getAdapter()).addPhotos(uris);
            }
        }
        bottomSheetDialog.dismiss();
    }

    public void setUri(Uri uri) {
        this.uri = uri;
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