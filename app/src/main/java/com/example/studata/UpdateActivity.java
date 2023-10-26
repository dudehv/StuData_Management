package com.example.studata;

import static com.example.studata.Utilitie.isValid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    TextView upstudenttable,upregister;
    Button updatebtn;
    EditText editupregistrationno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        upstudenttable=findViewById(R.id.upstudenttable);
        upregister=findViewById(R.id.upregister);
        updatebtn=findViewById(R.id.updatebtn);
        editupregistrationno=findViewById(R.id.editupregistrationno);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userregistrationno=editupregistrationno.getText().toString();
                if(isValid(userregistrationno)){
                    StudentDataModel sdm=Utilitie.getDataFromDB(UpdateActivity.this,userregistrationno);
                     if (sdm!=null){
                         Intent upintent = new Intent(UpdateActivity.this, dataEntry.class);
                         if (editupregistrationno.getText() != null) {
                             upintent.putExtra("userid", editupregistrationno.getText().toString());
                             upintent.putExtra("isFromUpdate",""+1);
                             upintent.putExtra("sdm",sdm);
                         }
                         startActivity(upintent);
                     }else{
                         Toast.makeText(UpdateActivity.this, "You are not registered user. Please go to registration secreen", Toast.LENGTH_SHORT).show();
                     }
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