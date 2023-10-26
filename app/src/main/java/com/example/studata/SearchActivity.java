package com.example.studata;

import static com.example.studata.ResponceCodefirIntent.REGISTRATION_NUM_INTANT_KEY;
import static com.example.studata.ResponceCodefirIntent.Update;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements Communication   {
    MyAdapter ad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        List<StudentDataModel> items=Utilitie.getAllDataFromDB(SearchActivity.this);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ad=(new MyAdapter(getApplicationContext(),items,SearchActivity.this));
        recyclerView.setAdapter(ad);

    }



    @Override
    public void deleteStudent(String regNumber) {
        String id= regNumber.toString();

        if(!id.isEmpty()) {
            DBManager dbManager = new DBManager(SearchActivity.this);
            dbManager.open();
            dbManager.deletedata(id);
            List<StudentDataModel> items=Utilitie.getAllDataFromDB(SearchActivity.this);
            ad.setData(items);
            Intent intent = new Intent();
            intent.putExtra(REGISTRATION_NUM_INTANT_KEY, ""+id);
            setResult(RESULT_OK, intent);

        }
    }

    @Override
    public void updatestudent(StudentDataModel studentDataModel) {

        Intent upintent = new Intent(SearchActivity.this, dataEntry.class);
        if (studentDataModel != null) {
            upintent.putExtra("userid", studentDataModel.getRegistrationNumber());
            upintent.putExtra("isFromUpdate",""+2);
            upintent.putExtra("sdm",studentDataModel);
        }
        startActivity(upintent);

    }

    @Override
    public void homepage() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
