package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton addbtn;
    RecyclerContactAdapter adapter;
    Button add;
    EditText name,number;
    ArrayList<ContactModel> list=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addbtn=findViewById(R.id.addbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.design);
                add=dialog.findViewById(R.id.add);
                name=dialog.findViewById(R.id.name);
                number=dialog.findViewById(R.id.number);

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String Name="";
                        String Number="";
                        Name=name.getText().toString().trim();
                        Number=number.getText().toString().trim();
                        list.add(new ContactModel(Name,Number));
                        adapter.notifyItemInserted(list.size()-1);
                        recyclerView.scrollToPosition(list.size()-1);
                        dialog.dismiss();

                    }
                });
                dialog.show();

            }
        });
        adapter=new RecyclerContactAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}