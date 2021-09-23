package com.hp.major.FindUrWay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    //we will use these constants later to pass the artist name and id to another activity


    //view objects
    EditText editTextName;

    FloatingActionButton buttonAddArtist;
    ListView listViewArtists;

    String email;
ImageView ii;

    //a list to store all the artist from firebase database
    List<Chat> chat;

    //our database reference object
    DatabaseReference databaseArtists;
    FirebaseUser user;

    @Override
    protected void onStart() {
        super.onStart();

        //attaching value event listener
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                chat.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Chat chat1 = postSnapshot.getValue(Chat.class);
                    //adding artist to the list
                    chat.add(chat1);
                }

                //creating adapter
                ChatList artistAdapter = new ChatList(ChatActivity.this, chat);
                //attaching adapter to the listview
                listViewArtists.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();
        if(!isConnected(ChatActivity.this)){ buildDialog(ChatActivity.this).show();
        }
        else {


        }

        //getting the reference of chats node

        databaseArtists = FirebaseDatabase.getInstance().getReference("chat");


        //getting views
        editTextName = (EditText) findViewById(R.id.input);
        ii = (ImageView) findViewById(R.id.ii);
        listViewArtists = (ListView) findViewById(R.id.list_of_messages);

        buttonAddArtist = (FloatingActionButton) findViewById(R.id.fab);




        //list to store chats
        chat = new ArrayList<>();


        //adding an onclicklistener to button
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addArtist();
            }
        });

        // when list item clicked


    }
    /*
    * This method is saving a new artist to the
    * Firebase Realtime Database
    * */
    private void addArtist() {
        //getting the values to save
        String text = editTextName.getText().toString().trim();
        String name = email.toString();
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String dateToStr = format.format(today);

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Chat
            String id = databaseArtists.push().getKey();

            //creating an Chat Object
            Chat chat = new Chat(id, text,name,dateToStr);

            //Saving the Chat
            databaseArtists.child(id).setValue(chat);

            //setting edittext to blank again
            editTextName.setText("");

            //displaying a success toast

        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please try Again", Toast.LENGTH_LONG).show();
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

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
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