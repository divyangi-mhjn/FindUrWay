package com.hp.major.FindUrWay;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewPlaceNotesActivity extends AppCompatActivity {

    public static final String TAG = "ViewPlaceNotesActivity";
    private FirebaseFirestore firestoreDB;
    private RecyclerView recyclerView;
    private FirebaseAuth auth;
    private FirebaseUser user;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_place_notes);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        tb.setSubtitle("View Place Notes");
        user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();


        firestoreDB = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.place_notes_lst);

        LinearLayoutManager recyclerLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(recyclerView.getContext(),
                        recyclerLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        getPlaceNotesFromDb();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.place_notes_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_place_notes_m:
                showPlacePicker();
                return true;
            case R.id.view_place_notes_m:
                getPlaceNotesFromDb();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void getPlaceNotesFromDb() {
        firestoreDB.collection("placeNotes").whereEqualTo("email",email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<PlaceNotes> placeNotesList = new ArrayList<PlaceNotes>();
                            Log.d(TAG, "results size "+task.getResult().size());
                            for(DocumentSnapshot doc : task.getResult()){
                                placeNotesList.add(doc.toObject(PlaceNotes.class));
                            }
                            PlaceNotesRecyclerViewAdapter recyclerViewAdapter = new
                                    PlaceNotesRecyclerViewAdapter(placeNotesList,
                                    ViewPlaceNotesActivity.this);
                            recyclerView.setAdapter(recyclerViewAdapter);

                        } else {
                            Log.d(TAG, "Error getting notes ", task.getException());
                        }
                    }
                });
    }
    public void showPlacePicker(){
        Intent i = new Intent();
        i.setClass(this, PlacePickerActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
