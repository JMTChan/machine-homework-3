package com.chan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List m = new LinkedList();

        Intent intent = getIntent();

        String name = intent.getStringExtra("na");
        String address = intent.getStringExtra("ad");
        String contact = intent.getStringExtra("co");

        String burger = intent.getStringExtra("burger");

        String add = intent.getStringExtra("bac");
        String add1 = intent.getStringExtra("pin");
        String add2 = intent.getStringExtra("let");
        String add3 = intent.getStringExtra("pic");
        String add4 = intent.getStringExtra("che");
        String add5 = intent.getStringExtra("mus");

        TextView nam = findViewById(R.id.name);
        nam.setText(name);
        TextView addr = findViewById(R.id.address);
        addr.setText(address);
        TextView con = findViewById(R.id.contact);
        con.setText(contact);

        TextView bur = findViewById(R.id.burger);
        bur.setText(burger);

        m.add(add);
        m.add(add1);
        m.add(add2);
        m.add(add3);
        m.add(add4);
        m.add(add5);
        TextUtils.join("",m);

        TextView ad = findViewById(R.id.addons);
        ad.setText(m.toString().replace(",","").replace("[","").replace("]","").replace("null",""));

        Button sub = findViewById(R.id.submit);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this,"Order Submitted", Toast.LENGTH_LONG).show();
            }
        });

        Button ex = findViewById(R.id.exit);
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
