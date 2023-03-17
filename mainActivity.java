package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String name;
    String amount;
    Database_transfer DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.btn);
        Button button1=findViewById(R.id.btn2);
        DB =new Database_transfer(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,listActivity.class);
                startActivity(intent);

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=DB.getinfo();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "no data found", Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer=new StringBuffer();

                while(res.moveToNext()){
                    buffer.append("\n"+res.getString(1)+"\t\t\t\t\t\t\t\t\t\t");
                    buffer.append(res.getString(2)+"\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User ");
                builder.setTitle("User Data");
                builder.setTitle("Amount     Name");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });
    }
}
