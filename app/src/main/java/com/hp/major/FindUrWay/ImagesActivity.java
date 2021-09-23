package com.hp.major.FindUrWay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImagesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView,mRecyclerView1,mRecyclerView2;
    private ImageAdapter mAdapter;
    private ProgressBar mProgressCircle;
    private DatabaseReference mDatabaseRef,mDatabaseRefA,mDatabaseRefB;
    private List<Upload> mUploads;
    String value,value1;
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.backa);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Route");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(getApplicationContext(),MetroRouteActivity.class);
                startActivity(inte);

            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView1 = (RecyclerView) findViewById(R.id.recycler_view1);
        mRecyclerView1.setHasFixedSize(true);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView2 = (RecyclerView) findViewById(R.id.recycler_view2);
        mRecyclerView2.setHasFixedSize(true);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this));
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        mUploads = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        String[] arrayInB = extras.getStringArray("my_array");
        value=arrayInB[0];
        value1=arrayInB[1];
        if(!isConnected(ImagesActivity.this)){ buildDialog(ImagesActivity.this).show();
        }
        else {


        }

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("RedLine");
        mDatabaseRefA = FirebaseDatabase.getInstance().getReference("BlueLine");
        mDatabaseRefB = FirebaseDatabase.getInstance().getReference("YellowLine");



        if (value.equals("Huda City Centre")&& value1.equals("Sikanderpur")) {
            tv2.setText("6 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        } else if (value.equals("Huda City Centre")&& value1.equals("Huaz Khas")) {
            tv2.setText("24 min");

            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("6").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });




        }
        else if (value.equals("Huda City Centre")&& value1.equals("AIIMS")) {
            tv2.setText("28 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("7").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Huda City Centre")&& value1.equals("Jor Bhagh")) {
            tv2.setText("32 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("9").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Huda City Centre")&& value1.equals("Race Course")) {
            tv2.setText("34 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Huda City Centre")&& value1.equals("Rajiv Chowk")) {
            tv2.setText("42 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Huda City Centre")&& value1.equals("New Delhi")) {
            tv2.setText("44 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Huda City Centre")&& value1.equals("Kashmere Gate")) {
            tv2.setText("50 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Huda City Centre")&& value1.equals("Jahangirpuri")) {
            tv2.setText("66 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Sikanderpur")&& value1.equals("Huaz Khas")) {
            tv2.setText("18 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("6").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });




        }
        else if (value.equals("Sikanderpur")&& value1.equals("AIIMS")) {
            tv2.setText("22 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("7").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Sikanderpur")&& value1.equals("Jor Bhagh")) {
            tv2.setText("26 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("9").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });




        }

        else if (value.equals("Sikanderpur")&& value1.equals("Race Course")) {
            tv2.setText("28 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Sikanderpur")&& value1.equals("Rajiv Chowk")) {
            tv2.setText("36 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("11").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });




        }

        else if (value.equals("Sikanderpur")&& value1.equals("New Delhi")) {
            tv2.setText("38 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Sikanderpur")&& value1.equals("Kashmere Gate")) {
            tv2.setText("44 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });




        }

        else if (value.equals("Sikanderpur")&& value1.equals("Jahangirpuri")) {
            tv2.setText("60 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("Huaz Khas")&& value1.equals("AIIMS")) {
            tv2.setText("4 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("7").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("Huaz Khas")&& value1.equals("Jor Bhagh")) {
            tv2.setText("8 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("9").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("Huaz Khas")&& value1.equals("Race Course")) {
            tv2.setText("10 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Huaz Khas")&& value1.equals("Rajiv Chowk")) {
            tv2.setText("18 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("11").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("Huaz Khas")&& value1.equals("New Delhi")) {
            tv2.setText("20 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Huaz Khas")&& value1.equals("Kashmere Gate")) {
            tv2.setText("26 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("Huaz Khas")&& value1.equals("Jahangirpuri")) {
            tv2.setText("42 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("AIIMS")&& value1.equals("Jor Bhagh")) {
            tv2.setText("4 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("9").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("AIIMS")&& value1.equals("Race Course")) {
            tv2.setText("6 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("AIIMS")&& value1.equals("Rajiv Chowk")) {
            tv2.setText("14 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("11").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("AIIMS")&& value1.equals("New Delhi")) {
            tv2.setText("16 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("AIIMS")&& value1.equals("Kashmere Gate")) {
            tv2.setText("22 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("AIIMS")&& value1.equals("Jahangirpuri")) {
            tv2.setText("38 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }


        else if (value.equals("Jor Bhagh")&& value1.equals("Rajiv Chowk")) {
            tv2.setText("10 min");

            mDatabaseRefB.orderByChild("value1").startAt("9").endAt("11").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Jor Bhagh")&& value1.equals("Race Course")) {
            tv2.setText("2 min");

            mDatabaseRefB.orderByChild("value1").startAt("9").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Jor Bhagh")&& value1.equals("New Delhi")) {
            tv2.setText("12 min");

            mDatabaseRefB.orderByChild("value1").startAt("9").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Jor Bhagh")&& value1.equals("Kashmere Gate")) {
            tv2.setText("18 min");

            mDatabaseRefB.orderByChild("value1").startAt("9").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Jor Bhagh")&& value1.equals("Jahangirpuri")) {
            tv2.setText("34 min");

            mDatabaseRefB.orderByChild("value1").startAt("9").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Race Course")&& value1.equals("Rajiv Chowk")) {
            tv2.setText("8 min");

            mDatabaseRefB.orderByChild("value1").startAt("10").endAt("11").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Race Course")&& value1.equals("New Delhi")) {
            tv2.setText("10 min");

            mDatabaseRefB.orderByChild("value1").startAt("10").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Race Course")&& value1.equals("Kashmere Gate")) {
            tv2.setText("16 min");

            mDatabaseRefB.orderByChild("value1").startAt("10").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Race Course")&& value1.equals("Jahangirpuri")) {
            tv2.setText("32 min");

            mDatabaseRefB.orderByChild("value1").startAt("10").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Rajiv Chowk")&& value1.equals("New Delhi")) {
            tv2.setText("2 min");

            mDatabaseRefB.orderByChild("value1").startAt("11").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Rajiv Chowk")&& value1.equals("Kashmere Gate")) {
            tv2.setText("8 min");

            mDatabaseRefB.orderByChild("value1").startAt("11").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Rajiv Chowk")&& value1.equals("Jahangirpuri")) {
            tv2.setText("24 min");

            mDatabaseRefB.orderByChild("value1").startAt("11").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("New Delhi")&& value1.equals("Kashmere Gate")) {
            tv2.setText("6 min");

            mDatabaseRefB.orderByChild("value1").startAt("12").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("New Delhi")&& value1.equals("Jahangirpuri")) {
            tv2.setText("22 min");

            mDatabaseRefB.orderByChild("value1").startAt("12").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Kashmere Gate")&& value1.equals("Jahangirpuri")) {
            tv2.setText("16 min");

            mDatabaseRefB.orderByChild("value1").startAt("14").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                    mRecyclerView1.setAdapter(mAdapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }




        //reverse



        else if (value.equals("Sikanderpur")&& value1.equals("Huda City Centre")) {
            tv2.setText("6 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        } else if (value.equals("Huaz Khas")&& value1.equals("Huda City Centre")) {
            tv2.setText("24 min");

            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("6").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });




        }
        else if (value.equals("AIIMS")&& value1.equals("Huda City Centre")) {
            tv2.setText("28 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("7").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }
                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Jor Bhagh")&& value1.equals("Huda City Centre")) {
            tv2.setText("32 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("9").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Race Course")&& value1.equals("Huda City Centre")) {
            tv2.setText("34 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Rajiv Chowk")&& value1.equals("Huda City Centre")) {
            tv2.setText("42 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("New Delhi")&& value1.equals("Huda City Centre")) {
            tv2.setText("44 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Kashmere Gate")&& value1.equals("Huda City Centre")) {
            tv2.setText("50 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Jahangirpuri")&& value1.equals("Huda City Centre")) {
            tv2.setText("66 min");
            mDatabaseRefB.orderByChild("value1").startAt("0").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Huaz Khas")&& value1.equals("Sikanderpur")) {
            tv2.setText("18 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("6").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });




        }
        else if (value.equals("AIIMS")&& value1.equals("Sikanderpur")) {
            tv2.setText("22 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("7").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (value.equals("Jor Bhagh")&& value1.equals("Sikanderpur")) {
            tv2.setText("26 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("9").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });




        }

        else if (value.equals("Race Course")&& value1.equals("Sikanderpur")) {
            tv2.setText("28 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Rajiv Chowk")&& value1.equals("Sikanderpur")) {
            tv2.setText("36 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("11").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });




        }

        else if (value.equals("New Delhi")&& value1.equals("Sikanderpur")) {
            tv2.setText("38 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }
                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Kashmere Gate")&& value1.equals("Sikanderpur")) {
            tv2.setText("44 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });




        }

        else if (value.equals("Jahangirpuri")&& value1.equals("Sikanderpur")) {
            tv2.setText("60 min");

            mDatabaseRefB.orderByChild("value1").startAt("1").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("AIIMS")&& value1.equals("Huaz Khas")) {
            tv2.setText("4 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("7").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }
                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("Jor Bhagh")&& value1.equals("Huaz Khas")) {
            tv2.setText("8 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("9").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("Race Course")&& value1.equals("Huaz Khas")) {
            tv2.setText("10 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Rajiv Chowk")&& value1.equals("Huaz Khas")) {
            tv2.setText("18 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("11").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("New Delhi")&& value1.equals("Huaz Khas")) {
            tv2.setText("20 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }
                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Kashmere Gate")&& value1.equals("Huaz Khas")) {
            tv2.setText("26 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("Jahangirpuri")&& value1.equals("Huaz Khas")) {
            tv2.setText("42 min");

            mDatabaseRefB.orderByChild("value1").startAt("6").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }

        else if (value.equals("Jor Bhagh")&& value1.equals("AIIMS")) {
            tv2.setText("4 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("9").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }
                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Race Course")&& value1.equals("AIIMS")) {
            tv2.setText("6 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Rajiv Chowk")&& value1.equals("AIIMS")) {
            tv2.setText("14 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("11").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("New Delhi")&& value1.equals("AIIMS")) {
            tv2.setText("16 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Kashmere Gate")&& value1.equals("AIIMS")) {
            tv2.setText("22 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Jahangirpuri")&& value1.equals("AIIMS")) {
            tv2.setText("38 min");

            mDatabaseRefB.orderByChild("value1").startAt("7").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }


        else if (value.equals("Rajiv Chowk")&& value1.equals("Jor Bhagh")) {
            tv2.setText("10 min");

            mDatabaseRefB.orderByChild("value1").startAt("9").endAt("11").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }
                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Race Course")&& value1.equals("Jor Bhagh")) {
            tv2.setText("2 min");

            mDatabaseRefB.orderByChild("value1").startAt("9").endAt("10").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("New Delhi")&& value1.equals("Jor Bhagh")) {
            tv2.setText("12 min");

            mDatabaseRefB.orderByChild("value1").startAt("9").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Kashmere Gate")&& value1.equals("Jor Bhagh")) {
            tv2.setText("18 min");

            mDatabaseRefB.orderByChild("value1").startAt("9").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }
                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Jahangirpuri")&& value1.equals("Jor Bhagh")) {
            tv2.setText("34 min");

            mDatabaseRefB.orderByChild("value1").startAt("9").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Rajiv Chowk")&& value1.equals("Race Course")) {
            tv2.setText("8 min");

            mDatabaseRefB.orderByChild("value1").startAt("10").endAt("11").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("New Delhi")&& value1.equals("Race Course")) {
            tv2.setText("10 min");

            mDatabaseRefB.orderByChild("value1").startAt("10").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }
                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Kashmere Gate")&& value1.equals("Race Course")) {
            tv2.setText("16 min");

            mDatabaseRefB.orderByChild("value1").startAt("10").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Jahangirpuri")&& value1.equals("Race Course")) {
            tv2.setText("32 min");

            mDatabaseRefB.orderByChild("value1").startAt("10").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }
                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("New Delhi")&& value1.equals("Rajiv Chowk")) {
            tv2.setText("2 min");

            mDatabaseRefB.orderByChild("value1").startAt("11").endAt("12").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Kashmere Gate")&& value1.equals("Rajiv Chowk")) {
            tv2.setText("8 min");

            mDatabaseRefB.orderByChild("value1").startAt("11").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Jahangirpuri")&& value1.equals("Rajiv Chowk")) {
            tv2.setText("24 min");

            mDatabaseRefB.orderByChild("value1").startAt("11").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Kashmere Gate")&& value1.equals("New Delhi")) {
            tv2.setText("6 min");

            mDatabaseRefB.orderByChild("value1").startAt("12").endAt("14").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Jahangirpuri")&& value1.equals("Kashmere Gate")) {
            tv2.setText("22 min");

            mDatabaseRefB.orderByChild("value1").startAt("12").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else if (value.equals("Jahangirpuri")&& value1.equals("Kashmere Gate")) {
            tv2.setText("16 min");

            mDatabaseRefB.orderByChild("value1").startAt("14").endAt("20").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);

                    }

                    Collections.reverse(mUploads);
                    mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        else {
            Toast.makeText(this, "Information is not present!Kindly go through the Maps ", Toast.LENGTH_SHORT).show();
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