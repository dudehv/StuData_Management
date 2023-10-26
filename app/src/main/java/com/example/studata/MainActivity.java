package com.example.studata;

import static com.example.studata.ResponceCodefirIntent.Add;
import static com.example.studata.ResponceCodefirIntent.Delete;
import static com.example.studata.ResponceCodefirIntent.REGISTRATION_NAME_INTANT_KEY;
import static com.example.studata.ResponceCodefirIntent.REGISTRATION_NUM_INTANT_KEY;
import static com.example.studata.ResponceCodefirIntent.Search;
import static com.example.studata.ResponceCodefirIntent.Update;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView studentdata, text;
    Button addstudentbtn,deletestudentbtn,updatestudentbtn,searchbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentdata=findViewById(R.id.studentdata);
        text=findViewById(R.id.text);
        addstudentbtn=findViewById(R.id.addstudentbtn);
        deletestudentbtn=findViewById(R.id.deletestudentbtn);
        updatestudentbtn=findViewById(R.id.updatestudentbtn);
        searchbtn=findViewById(R.id.searchbtn);
    }
    @Override
    protected void onResume() {
        super.onResume();
        addstudentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplication(),dataEntry.class), Add);
            }
        });
        deletestudentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplication(),DeleteActivity.class),Delete);
            }
        });
        updatestudentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplication(),UpdateActivity.class),Update);
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplication(),SearchActivity.class),Search);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            switch(requestCode){
                case Add: {
                    if(data!=null){
                        String regNumName="Registration Succefully !! \n Registartion Number : "+data.getStringExtra(REGISTRATION_NUM_INTANT_KEY)+"\n Name is : "+data.getStringExtra(REGISTRATION_NAME_INTANT_KEY);
                        new ViewDialog().showDialog(MainActivity.this,regNumName);
                    }
                    break;
                }
                case Delete:{
                    if(data!=null){
                        String regNumName=" Succefully Deleted!! \n Registartion Number : "+data.getStringExtra(REGISTRATION_NUM_INTANT_KEY);
                        new ViewDialog().showDialog(MainActivity.this,regNumName);
                    }
                    break;
                }
                case Update:{
                    
                }
            }
        }
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to exit ?");
        builder.setTitle("Alert !");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
               finish();
        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}