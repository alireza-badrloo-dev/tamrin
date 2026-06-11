package com.example.myapplication6;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {
    private ImageView image_item;
    private TextView name_item;
    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        image_item = itemView.findViewById(R.id.image_item);
        name_item = itemView.findViewById(R.id.name_item);

    }

    public void setItems(String name , int imageId){
        name_item.setText(name);
        image_item.setImageResource(imageId);
        image_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
