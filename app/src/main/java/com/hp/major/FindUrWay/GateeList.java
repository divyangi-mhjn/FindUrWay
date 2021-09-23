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


public class GateeList extends ArrayAdapter<Gatee> {
    private Activity context;
    List<Gatee> gatee1;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseUser user;
    String email1;
    int flag;


    public  GateeList(Activity context, List<Gatee> gatee1) {
        super(context, R.layout.activity_fav, gatee1);
        this.context = context;
        this.gatee1 = gatee1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem1 = inflater.inflate(R.layout.activity_fav, null, true);

        TextView textViewName = (TextView) listViewItem1.findViewById(R.id.text);
        TextView textViewName2 = (TextView) listViewItem1.findViewById(R.id.text2);




        Gatee gatee = gatee1.get(position);
        user = FirebaseAuth.getInstance().getCurrentUser();
        email1 = user.getEmail();



        textViewName.setText(gatee.getValue1());
        textViewName2.setText(gatee.getValue2());





        position++;




        return listViewItem1;
    }
}
