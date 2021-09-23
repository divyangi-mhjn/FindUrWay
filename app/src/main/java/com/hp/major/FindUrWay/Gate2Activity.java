package com.hp.major.FindUrWay;

import android.app.Activity;
        import android.content.Intent;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.text.TextUtils;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.List;
public class Gate2Activity extends AppCompatActivity {
    String value;
    private Activity context;
    ArrayList<Gate> gate;
    ArrayList<Gatee> gatee;
    DatabaseReference db, db1;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseUser user;
    String email1;
    TextView text;
    ListView listViewGate, listViewGate1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.backa);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Detailed Description");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),GateActivity.class);
                startActivity(i);
            }
        });
        text = (TextView) findViewById(R.id.t1);
        listViewGate = (ListView) findViewById(R.id.listViewGate1);
        listViewGate1 = (ListView) findViewById(R.id.listViewGate2);
        Bundle b = getIntent().getExtras();
        value = b.getString("value");
        gate = new ArrayList<>();
        gatee = new ArrayList<>();
        db = FirebaseDatabase.getInstance().getReference("Gates");
        db1 = FirebaseDatabase.getInstance().getReference("Platforms");
        text.setText(value);
        if (value.equals("Adarsh Nagar")) {

            db.orderByChild("value3").equalTo("Adarsh Nagar").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Adarsh Nagar").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if (value.equals("Botanical Garden")) {

            db.orderByChild("value3").equalTo("Botanical Garden").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Botanical Garden").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if (value.equals("Chandni Chowk")) {

            db.orderByChild("value3").equalTo("Chandni Chowk").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Chandni Chowk").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if (value.equals("AIIMS")) {

            db.orderByChild("value3").equalTo("AIIMS").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("AIIMS").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        else if (value.equals("Akshardham")) {

            db.orderByChild("value3").equalTo("Akshardham").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Akshardham").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        else if (value.equals("Chawri Bazar")) {

            db.orderByChild("value3").equalTo("Chawri Bazar").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Chawri Bazar").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        else if (value.equals("Dilshad Garden")) {

            db.orderByChild("value3").equalTo("Dilshad Garden").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Dilshad Nagar").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        else if (value.equals("Dwarka Sector 21")) {

            db.orderByChild("value3").equalTo("Dwarka Sector 21").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Dwarka Sector 21").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if (value.equals("Guru Dhronacharya")) {

            db.orderByChild("value3").equalTo("Guru Dhronacharya").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Guru Dhronacharya").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if (value.equals("Hauz Khas")) {

            db.orderByChild("value3").equalTo("Hauz Khas").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Hauz Khas").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        else if (value.equals("Huda City Centre")) {

            db.orderByChild("value3").equalTo("Huda City Centre").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Huda City Centre").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if (value.equals("Kashmere Gate")) {

            db.orderByChild("value3").equalTo("Kashmere Gate").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Kashmere Gate").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        else if (value.equals("New Delhi")) {

            db.orderByChild("value3").equalTo("New Delhi").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("New Delhi").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if (value.equals("Race Course")) {

            db.orderByChild("value3").equalTo("Race Course").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Race Course").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if (value.equals("Rajiv Chowk")) {

            db.orderByChild("value3").equalTo("Rajiv Chowk").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Rajiv Chowk").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        else if (value.equals("Vidhan Sabha")) {

            db.orderByChild("value3").equalTo("Vidhan Sabha").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Vidhan Sabha").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        else if (value.equals("Sikanderpur")) {

            db.orderByChild("value3").equalTo("Sikanderpur").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("Sikanderpur").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        else if (value.equals("Central Secretariat")) {

            db.orderByChild("value3").equalTo("CS").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gate.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gate gate1 = postSnapshot.getValue(Gate.class);
                        //adding artist to the list
                        gate.add(gate1);
                    }
                    //creating adapter
                    GateList gateAdapter = new GateList(Gate2Activity.this, gate);


                    //attaching adapter to the listview
                    listViewGate.setAdapter(gateAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            db1.orderByChild("value3").equalTo("CS").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    gatee.clear();

                    //iterating through all the nodes
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        //getting artist
                        Gatee gate1 = postSnapshot.getValue(Gatee.class);
                        //adding artist to the list
                        gatee.add(gate1);
                    }
                    //creating adapter
                    GateeList gateeAdapter = new GateeList(Gate2Activity.this, gatee);


                    //attaching adapter to the listview
                    listViewGate1.setAdapter(gateeAdapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }












    }
    @Override
    public void onBackPressed() {
        finish();

    }

}

