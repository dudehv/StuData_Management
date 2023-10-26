package com.example.studata;

import static com.example.studata.ResponceCodefirIntent.REGISTRATION_NAME_INTANT_KEY;
import static com.example.studata.ResponceCodefirIntent.REGISTRATION_NUM_INTANT_KEY;
import static com.example.studata.Utilitie.isValid;
import static com.example.studata.Utilitie.showingToast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class dataEntry extends AppCompatActivity {
    TextView studenttable,registerpagetextview,name,classtext,address,mobile,registrationnotextview;
    Button save;
    EditText entername,classname,editaddress,editmobile;
    int val;
    String isFromUpdate;
    StudentDataModel sdm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        studenttable=findViewById(R.id.studenttable);
        registerpagetextview=findViewById(R.id.registerpagetextview);
        name=findViewById(R.id.name);
        classtext=findViewById(R.id.classtext);
        address=findViewById(R.id.address);
        save=findViewById(R.id.save);
        entername=findViewById(R.id.entername);
        classname=findViewById(R.id.classname);
        editaddress=findViewById(R.id.editaddress);
        mobile=findViewById(R.id.mobile);
        editmobile=findViewById(R.id.editmobile);
        registrationnotextview=findViewById(R.id.registrationnotextview);

        isFromUpdate = getIntent().getStringExtra("isFromUpdate");
        if(isFromUpdate!=null && isFromUpdate.equals("1")){
            String regNum = getIntent().getStringExtra("userid");
            sdm= (StudentDataModel) getIntent().getSerializableExtra("sdm");
            entername.setText(sdm.getFullname());
            classname.setText(sdm.getClassname());
            editaddress.setText(sdm.getAddress());
            editmobile.setText(sdm.getMobile());
            registrationnotextview.setText(regNum);
            save.setText("UPDATE");
        }else if(isFromUpdate.equals("2")){
            String regNum = getIntent().getStringExtra("userid");
            sdm= (StudentDataModel) getIntent().getSerializableExtra("sdm");
            entername.setText(sdm.getFullname());
            classname.setText(sdm.getClassname());
            editaddress.setText(sdm.getAddress());
            editmobile.setText(sdm.getMobile());
            registrationnotextview.setText(regNum);
            save.setText("UPDATE");

        }else {
            Random random = new Random();
            val = random.nextInt(1000);
            save.setText("SAVE");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isFromUpdate==null){
            registrationnotextview.setText(""+val);
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userregistrationnumber=registrationnotextview.getText().toString();
                String username= entername.getText().toString();
                String userclass= classname.getText().toString();
                String useraddress=editaddress.getText().toString();
                String usermobile=editmobile.getText().toString();

                if(isValid(username,userclass,useraddress,usermobile)){
                    if(isFromUpdate!= null && isFromUpdate.equals("1")){
                        int issave=Utilitie.updatestudent(username, userclass, useraddress,usermobile,userregistrationnumber,dataEntry.this);
                        if(issave==1 ){
                            Intent intent=new Intent();
                            intent.putExtra(REGISTRATION_NUM_INTANT_KEY,""+userregistrationnumber);
                            intent.putExtra(REGISTRATION_NAME_INTANT_KEY,""+username);
                            setResult(RESULT_OK,intent);
                            finish();
                        }else {
                            Toast.makeText(dataEntry.this, "User Already Registered", Toast.LENGTH_SHORT).show();
                        }

                    } else if (isFromUpdate!= null && isFromUpdate.equals("2")) {
                        int issave=Utilitie.updatestudent(username, userclass, useraddress,usermobile,userregistrationnumber,dataEntry.this);
                        if(issave==1 ){
                            Intent intent=new Intent();
                            intent.putExtra(REGISTRATION_NUM_INTANT_KEY,""+userregistrationnumber);
                            intent.putExtra(REGISTRATION_NAME_INTANT_KEY,""+username);
                            setResult(RESULT_OK,intent);
                            finish();
                        }else {
                            Toast.makeText(dataEntry.this, "User Already Registered", Toast.LENGTH_SHORT).show();
                        }

                    } else{
                        boolean issave=Utilitie.saveIntosp(dataEntry.this,userregistrationnumber, username, userclass, useraddress,usermobile);
                        if(issave){
                            Intent intent=new Intent();
                            intent.putExtra(REGISTRATION_NUM_INTANT_KEY,""+userregistrationnumber);
                            intent.putExtra(REGISTRATION_NAME_INTANT_KEY,""+username);
                            setResult(RESULT_OK,intent);
                            finish();
                        }else {
                            Toast.makeText(dataEntry.this, "User Already Registered", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    showingToast(dataEntry.this);
                }
            }
        });
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