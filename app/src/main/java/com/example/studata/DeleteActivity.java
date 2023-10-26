package com.example.studata;

import static com.example.studata.ResponceCodefirIntent.REGISTRATION_NAME_INTANT_KEY;
import static com.example.studata.ResponceCodefirIntent.REGISTRATION_NUM_INTANT_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeleteActivity extends AppCompatActivity {
    TextView studenttable,registerpage;
    Button deletebtn;
    EditText editregistrationno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        studenttable=findViewById(R.id.studenttable);
        registerpage=findViewById(R.id.registerpage);
        deletebtn=findViewById(R.id.deletebtn);
        editregistrationno=findViewById(R.id.editregistrationno);

    }

    @Override
    protected void onResume() {
        super.onResume();
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id= editregistrationno.getText().toString();

                if(!id.isEmpty()) {
                    DBManager dbManager = new DBManager(DeleteActivity.this);
                    dbManager.open();
                    dbManager.deletedata(id);
                    Intent intent = new Intent();
                    intent.putExtra(REGISTRATION_NUM_INTANT_KEY, ""+id);
                    setResult(RESULT_OK, intent);
                    finish();
                    }


                }



        });
    }
}