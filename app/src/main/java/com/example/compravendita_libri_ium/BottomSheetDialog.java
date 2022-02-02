package com.example.compravendita_libri_ium;

import static com.example.compravendita_libri_ium.RecyclerViewAddPhotoAdapter.SELECT_PICTURE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import com.example.compravendita_libri_ium.activities.NewAdPhotosActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.File;
import java.io.IOException;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    public static final int REQUEST_IMAGE_CAPTURE = 1;
    private Context context;
    private int counter = 0;

    public BottomSheetDialog(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout,
                container, false);

        Button documentsButton = v.findViewById(R.id.documents_button);
        Button cameraButton = v.findViewById(R.id.camera_button);

        documentsButton.setOnClickListener(v1 -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            ((Activity) context).startActivityForResult(Intent.createChooser(intent, "Seleziona una foto"), SELECT_PICTURE);
        });

        cameraButton.setOnClickListener(v12 -> {
            counter++; //this is an int
            String imageFileName = "JPEG_" + counter; //make a better file name
            File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File image = null;
            try {
                image = File.createTempFile(imageFileName, ".jpg", storageDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Uri uri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", image);
            Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            ((NewAdPhotosActivity) context).setUri(uri);
            ((NewAdPhotosActivity) context).startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE);
        });
        return v;
    }
}

