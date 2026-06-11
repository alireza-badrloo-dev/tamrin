package com.example.myapplication6;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {
    private ImageView image_item;
    private TextView name_item;
    private  TextView dialog_item;


    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        image_item = itemView.findViewById(R.id.image_item);
        name_item = itemView.findViewById(R.id.name_item);
        dialog_item = itemView.findViewById(R.id.dialog_item);
    }

    public void setItems(String name , int imageId){
        name_item.setText(name);
        image_item.setImageResource(imageId);

        dialog_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dilaog_view);
                TextView btn_yes = dialog.findViewById(R.id.btn_yes);
                TextView btn_no = dialog.findViewById(R.id.btn_no);

                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "btn clicked yes" ,Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "btn clicked no" ,Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


    }
}
