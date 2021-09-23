package com.hp.major.FindUrWay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MetroRouteActivity extends AppCompatActivity {
    AutoCompleteTextView autoTextView1,autoTextView2;
    TextView txt;
    Button btn;
    String str,strr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metro_route);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Metro Route");
        toolbar.setNavigationIcon(R.drawable.backa);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MetroActivity.class);
                startActivity(intent);
            }
        });


        String[]ListDrop = { "Huda City Centre","Huaz Khas","Rajiv Chowk","Sikanderpur","AIIMS","Jor Bhagh","Race Course",
        "New Delhi","Kashmere Gate","Jahangirpuri"};



        autoTextView1 = (AutoCompleteTextView) findViewById(R.id.autocompleteEditTextView1);
        autoTextView2 = (AutoCompleteTextView) findViewById(R.id.autocompleteEditTextView2);
        btn=(Button)findViewById(R.id.btn);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item,ListDrop);
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
                  str=autoTextView1.getText().toString();
                  strr=autoTextView2.getText().toString();
                  String intArray[] = {str,strr};
                  Intent intent=new Intent(getApplicationContext(),ImagesActivity.class);
                  intent.putExtra("my_array", intArray);
                  startActivity(intent);
              }
          });
        if(!isConnected(MetroRouteActivity.this)){ buildDialog(MetroRouteActivity.this).show();
        }
        else {


        }
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
}
