package com.example.studata;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView regNumView,nameView,classView,addressView,mobileView;
    ImageView imageView,imageviewOption;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        regNumView=itemView.findViewById(R.id.regNumView);
        nameView=itemView.findViewById(R.id.nameView);
        classView=itemView.findViewById(R.id.classView);
        addressView=itemView.findViewById(R.id.addressView);
        mobileView=itemView.findViewById(R.id.mobileView);
        imageView=itemView.findViewById(R.id.imageview);
        imageviewOption=itemView.findViewById(R.id.imageViewOptions);
    }
}
