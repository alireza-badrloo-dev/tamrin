package com.example.myapplication6;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {
    private ImageView image_item;
    private TextView name_item;
    private TextView  more_item;
    private TextView time_item;

    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        image_item = itemView.findViewById(R.id.image_item);
        name_item = itemView.findViewById(R.id.name_item);
        more_item = itemView.findViewById(R.id.more_item);
        time_item = itemView.findViewById(R.id.time_item);
    }

    public void setItems(String name , int imageId){
        name_item.setText(name);
        image_item.setImageResource(imageId);
        more_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(v.getContext());
                alertdialog.setTitle("تست تایتل");
                alertdialog.setMessage("تست پیام");

                alertdialog.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertdialog.setNegativeButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


                alertdialog.setCancelable(false);
                alertdialog.show();

            }
        });

        time_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    }
                },23 , 01 ,true);
                timePickerDialog.show();
            }
        });
    }
}
