package com.example.user.database_test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        removedata();
    }

    private void removedata() {
        SharedPreferences s=getSharedPreferences("filename",MODE_PRIVATE);
        SharedPreferences.Editor e=s.edit();
        e.remove("name");
        e.commit();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
