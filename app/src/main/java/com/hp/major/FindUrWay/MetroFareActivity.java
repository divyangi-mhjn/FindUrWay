package com.hp.major.FindUrWay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class MetroFareActivity extends AppCompatActivity {
    AutoCompleteTextView autoTextView1,autoTextView2;
    TextView f1,f2,f3,f4;
    Button btn;
    String str,strr;
    CardView c1,c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metro_fare);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Fare");
        toolbar.setNavigationIcon(R.drawable.backa);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MetroActivity.class);
                startActivity(intent);
            }
        });
        c1=(CardView)findViewById(R.id.c1);
        c2=(CardView)findViewById(R.id.c2);
        f1=(TextView)findViewById(R.id.f1);
        f2=(TextView)findViewById(R.id.f2);
        f3=(TextView)findViewById(R.id.f3);
        f4=(TextView)findViewById(R.id.f4);




        String[]ListDrop = { "Huda City Centre","Huaz Khas","Rajiv Chowk","Adarsh Nagar","Mayur Vihar 1","Golf Course"};



        autoTextView1 = (AutoCompleteTextView) findViewById(R.id.autocompleteEditTextView1);
        autoTextView2 = (AutoCompleteTextView) findViewById(R.id.autocompleteEditTextView2);
        btn=(Button)findViewById(R.id.btn);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item,ListDrop);
        c1.setVisibility(View.GONE);
        c2.setVisibility(View.GONE);
        //Used to specify minimum number of
        //characters the user has to type in order to display the drop down hint.
        autoTextView1.setThreshold(1);
        //Setting adapter
        autoTextView1.setAdapter(arrayAdapter);
        autoTextView2.setThreshold(1);
        //Setting adapter
        autoTextView2.setAdapter(arrayAdapter);
        autoTextView1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.start, 0, 0, 0);
        autoTextView1.setCompoundDrawablePadding(15);
        autoTextView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.end, 0, 0, 0);
        autoTextView2.setCompoundDrawablePadding(15);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func();

            }
        });

    }
    public void func(){
        str=autoTextView1.getText().toString();
        strr=autoTextView2.getText().toString();
        c1.setVisibility(View.VISIBLE);
        c2.setVisibility(View.VISIBLE);

        if(str.equals("Golf Course") && strr.equals("Mayur Vihar1")){
            f2.setText("30");
            f4.setText("27");
        }
        else if(str.equals("Rajiv Chowk") && strr.equals("Adarsh Nagar")){
            f2.setText("40");
            f4.setText("36");
        }
        else if(str.equals("Huda City Centre") && strr.equals("Huaz Khas")){
            f2.setText("40");
            f4.setText("36");
        }
        }
    }
