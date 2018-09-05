package com.chan.myapplication;

import android.content.Intent;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private String select = "";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, Main2Activity.class);
        RadioGroup rg = findViewById(R.id.type_group);
        final RadioButton chick = (RadioButton)findViewById(R.id.chicken);
        final RadioButton beef = (RadioButton)findViewById(R.id.beef);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.chicken)
                {
                    intent.putExtra("burger", "Chicken");
                }
                else if(checkedId == R.id.beef)
                {
                    intent.putExtra("burger","Beef");
                }
            }
        });

        ImageButton imgbtn = findViewById(R.id.add);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });
    }
    public void onCheckedBox(View view)
    {
        boolean checked = ((CheckBox)view).isChecked();

        switch (view.getId())
        {
            case R.id.bacon_checkBox:if (checked){
                intent.putExtra("bac","Bacon");
            }else {
                intent.removeExtra("bac");
            }break;
            case R.id.pineapple_checkBox:if(checked){
                intent.putExtra("pin", "Pineapple");
            }else {
                intent.removeExtra("pin");
            }break;
        }
    }
}