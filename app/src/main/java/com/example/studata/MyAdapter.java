package com.example.studata;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<StudentDataModel> items;
    Communication comm;

    public MyAdapter(Context context, List<StudentDataModel> items,Context listner) {
        this.context = context;
        this.items = items;
        comm= (Communication) listner;
    }
    public void setData(List<StudentDataModel> newData) {
        this.items.clear();
        items.addAll(newData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.regNumView.setText(items.get(position).getRegistrationNumber());
        holder.nameView.setText(items.get(position).getFullname());
        holder.classView.setText(items.get(position).getClassname());
        holder.addressView.setText(items.get(position).getAddress());
        holder.mobileView.setText(items.get(position).getMobile());
        holder.imageviewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v,position,context);
            }
        });



    }

    public void showPopup(View v, int position, Context context) {
        PopupMenu popup = new PopupMenu(context, v, Gravity.END);
        //popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_resource, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.delete_student){
                    comm.deleteStudent(items.get(position).registrationNumber);
                    return true;

                }else if (item.getItemId() == R.id.update_student){
                  comm.updatestudent(items.get(position));
                    return true;
                }else{
                   comm.homepage();
                    return true;
                }
            }
        });
        popup.show();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
