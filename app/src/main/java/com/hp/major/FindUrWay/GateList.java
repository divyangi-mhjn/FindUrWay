package com.hp.major.FindUrWay;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


public class GateList extends ArrayAdapter<Gate> {
    private Activity context;
    List<Gate> gate1;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseUser user;
    String email1;
    int flag;


    public  GateList(Activity context, List<Gate> gate1) {
        super(context, R.layout.activity_fav, gate1);
        this.context = context;
        this.gate1 = gate1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_fav, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.text);
        TextView textViewName2 = (TextView) listViewItem.findViewById(R.id.text2);




        Gate gate = gate1.get(position);
        user = FirebaseAuth.getInstance().getCurrentUser();
        email1 = user.getEmail();



            textViewName.setText(gate.getValue1());
            textViewName2.setText(gate.getValue2());





            position++;




        return listViewItem;
    }
}
