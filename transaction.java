package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class transaction extends AppCompatActivity {
    EditText ed2,ed1;
    Database_transfer g;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        //ed3=findViewById(R.id.ed3);
        submit=findViewById(R.id.submit);
        g=new Database_transfer(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount=ed1.getText().toString();
                String name=ed2.getText().toString();
                //String password1=ed3.getText().toString();
                if(amount.equals("")|| name.equals("")){
                    Toast.makeText(com.example.myapplication.transaction.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean v=g.insert_data(amount,name);
                    if(v==true){

                        Toast.makeText(com.example.myapplication.transaction.this, "Successful", Toast.LENGTH_SHORT).show();
                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent=new Intent(transaction.this,MainActivity.class);
                            }
                        });
                    }
                    else{
                        Toast.makeText(com.example.myapplication.transaction.this, "not successful", Toast.LENGTH_SHORT).show();
                    }
                }
                ed1.setText("");
                ed2.setText("");
                //ed3.setText("");
            }
        });
    }
}
