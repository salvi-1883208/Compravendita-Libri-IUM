package com.example.compravendita_libri_ium;


import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.compravendita_libri_ium.activities.NewAdPhotosActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecyclerViewAddPhotoAdapter extends RecyclerView.Adapter<RecyclerViewAddPhotoAdapter.ViewHolder> {

    public static final int SELECT_PICTURE = 200;
    private static ArrayList<Uri> images;
    private Context context;
    private Button continueButton;
    private BottomSheetDialog bottomSheetDialog;

    public RecyclerViewAddPhotoAdapter(Context context, ArrayList<Uri> images, Button continueButton, BottomSheetDialog bottomSheetDialog) {
        this.images = images;
        this.context = context;
        this.continueButton = continueButton;
        this.bottomSheetDialog = bottomSheetDialog;
    }

    public ArrayList<Uri> getPhotos() {
        return images;
    }

    public void addPhoto(Uri photo) {
        images.add(photo);
        if (continueButton.getVisibility() == View.GONE)
            continueButton.setVisibility(View.VISIBLE);
        else {
            continueButton.setClickable(true);
            continueButton.setBackgroundColor(context.getResources().getColor(R.color.sapienza));
        }
        RecyclerViewAddPhotoAdapter.this.notifyItemInserted(images.size() - 1);
    }

    public void addPhotos(ArrayList<Uri> uris) {
        images.addAll(uris);
        if (continueButton.getVisibility() == View.GONE)
            continueButton.setVisibility(View.VISIBLE);
        else {
            continueButton.setClickable(true);
            continueButton.setBackgroundColor(context.getResources().getColor(R.color.sapienza));
        }
        RecyclerViewAddPhotoAdapter.this.notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerViewAddPhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.new_ad_recycler_view_photo, parent, false);
        return new RecyclerViewAddPhotoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAddPhotoAdapter.ViewHolder holder, int position) {
        if (images.isEmpty() || images.size() <= position)
            addPhotoButton(holder);
        else
            showPhoto(holder, position);
    }

    private void addPhotoButton(RecyclerViewAddPhotoAdapter.ViewHolder holder) {
        holder.addPhotoButton.setVisibility(View.VISIBLE);
        holder.photoView.setVisibility(View.INVISIBLE);
        holder.removePhotoButton.setVisibility(View.GONE);

        holder.addPhotoButton.setOnClickListener(view -> {
            bottomSheetDialog.show(((NewAdPhotosActivity) context).getSupportFragmentManager(),
                    "ModalBottomSheet");
        });
    }

    private void showPhoto(RecyclerViewAddPhotoAdapter.ViewHolder holder, int position) {
        Uri item = images.get(position);

        holder.removePhotoButton.setOnClickListener(view -> {
            System.out.println("\n" + position + "\n" + images.size() + "\n");
            images.remove(item);
            if (images.isEmpty()) {
                continueButton.setClickable(false);
                continueButton.setBackgroundColor(context.getResources().getColor(R.color.lightGray));
            }
            RecyclerViewAddPhotoAdapter.this.notifyDataSetChanged(); //TODO Andrebbe cambiato ma non so come risolvere
        });
        holder.addPhotoButton.setVisibility(View.GONE);
        holder.removePhotoButton.setVisibility(View.VISIBLE);
        holder.photoView.setVisibility(View.VISIBLE);
        holder.photoView.setImageURI(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView photoView;
        public FloatingActionButton addPhotoButton;
        public FloatingActionButton removePhotoButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            photoView = (ImageView) itemView.findViewById(R.id.added_photo);
            addPhotoButton = (FloatingActionButton) itemView.findViewById(R.id.add_photo_button);
            removePhotoButton = (FloatingActionButton) itemView.findViewById(R.id.remove_photo_button);
        }
    }
}