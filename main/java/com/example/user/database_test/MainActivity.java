package com.example.user.database_test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Context c;
    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c=this;
        btn= (Button) findViewById(R.id.btnsubmit);
        et= (EditText) findViewById(R.id.etname);
        btn.setOnClickListener(this);
        readdata();
    }

    private void readdata() {
        SharedPreferences s=getSharedPreferences("filename",MODE_PRIVATE);
        String ss=s.getString("name",null);
        if(ss!=null)
        {
            Intent i=new Intent(c,DataActivity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
               writedata();
    }

    private void writedata() {
        SharedPreferences sp=getSharedPreferences("filename",MODE_PRIVATE);
        SharedPreferences.Editor e=sp.edit();
        e.putString("name",et.getText().toString());
        e.commit();
        Intent i=new Intent(c,DataActivity.class);
        startActivity(i);
        finish();
    }
}
