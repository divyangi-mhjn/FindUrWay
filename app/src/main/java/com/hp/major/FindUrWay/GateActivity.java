package com.hp.major.FindUrWay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GateActivity extends AppCompatActivity {
   ImageView tt;
    AutoCompleteTextView autoTextView1,autoTextView2;
    TextView txt;
    Button btn;
    String str,strr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tt=(ImageView)findViewById(R.id.tt);
        toolbar.setTitle("Gates And Directions");
        toolbar.setNavigationIcon(R.drawable.backa);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MetroActivity.class);
                startActivity(intent);
            }
        });
        if(!isConnected(GateActivity.this)){ buildDialog(GateActivity.this).show();
        }
        else {


        }


        String[]ListDrop = { "Adarsh Nagar","Botanical Garden","Chandni Chowk","AIIMS","Akshardham","Chawri Bazar","Dilshad Garden","Dwarka Sector 21"
        ,"Guru Dhronacharya","Hauz Khas","Huda City Centre","INA","Kashmere Gate","New Delhi","Race Course","Rajiv Chowk","Vidhan Sabha","Sikanderpur","Central Secretariat"};



        autoTextView1 = (AutoCompleteTextView) findViewById(R.id.autocompleteEditTextView1);

        btn=(Button)findViewById(R.id.btn);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item,ListDrop);
        //Used to specify minimum number of
        //characters the user has to type in order to display the drop down hint.
        autoTextView1.setThreshold(1);
        //Setting adapter
        autoTextView1.setAdapter(arrayAdapter);

        //Setting adapter

        autoTextView1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.stn, 0, 0, 0);
        autoTextView1.setCompoundDrawablePadding(15);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str=autoTextView1.getText().toString();


                Intent intent=new Intent(getApplicationContext(),Gate2Activity.class);

                intent.putExtra("value", str);

                startActivity(intent);
            }
        });

    }
    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Check your internet/wifi connection");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent=new Intent(getApplicationContext(),MetroActivity.class);
                startActivity(intent);
            }
        });

        return builder;
    }
    @Override
    public void onBackPressed() {
        finish();

    }
}