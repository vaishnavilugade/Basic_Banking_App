package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listActivity extends AppCompatActivity {
    ListView listView;
    String[] name={"Rohit","Snehal","Pankaj","Pranav","Sagar","Shivani"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toast.makeText(listActivity.this, "WELCOME", Toast.LENGTH_SHORT).show();
        listView=findViewById(R.id.list);
        ArrayAdapter<String> vaishnavi=new ArrayAdapter<String>(listActivity.this, android.R.layout.simple_dropdown_item_1line,name);
        listView.setAdapter(vaishnavi);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(listActivity.this, "Welcome to "+name[position]+"'s details", Toast.LENGTH_SHORT).show();

                if(position==0) {
                    //clicked on user1
                    startActivity(new Intent(listActivity.this,user1.class));
                }else if(position==1){
                    //clicked on user2
                    startActivity(new Intent(listActivity.this,user2.class));
                }else if(position==2){
                    //clicked on user3
                    startActivity(new Intent(listActivity.this,user3.class));
                }else if(position==3){
                    //clicked on user4
                    startActivity(new Intent(listActivity.this,user4.class));
                }else if(position==4){
                    //clicked on user5
                    startActivity(new Intent(listActivity.this,user5.class));
                }else if(position==5){
                    //clicked on user6
                    startActivity(new Intent(listActivity.this,user6.class));
                }
                
            }
        });

    }
}
