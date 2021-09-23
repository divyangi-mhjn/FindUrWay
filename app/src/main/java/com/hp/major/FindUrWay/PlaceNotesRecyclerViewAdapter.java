package com.hp.major.FindUrWay;
import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import static com.hp.major.FindUrWay.PlacePickerActivity.TAG;

public class PlaceNotesRecyclerViewAdapter extends
        RecyclerView.Adapter<PlaceNotesRecyclerViewAdapter.ViewHolder> {

    private List<PlaceNotes> placeNotesList;
    private Context context;
    private FirebaseFirestore firestoreDB;


    public PlaceNotesRecyclerViewAdapter(List<PlaceNotes> list, Context ctx) {
        placeNotesList = list;
        context = ctx;
    }
    @Override
    public int getItemCount() {
        return placeNotesList.size();
    }

    @Override
    public PlaceNotesRecyclerViewAdapter.ViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_notes_item, parent, false);

        PlaceNotesRecyclerViewAdapter.ViewHolder viewHolder =
                new PlaceNotesRecyclerViewAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlaceNotesRecyclerViewAdapter.ViewHolder holder, int position) {
        final int itemPos = position;
        final PlaceNotes place = placeNotesList.get(position);
        holder.name.setText(place.getPlaceName());
        holder.address.setText(place.getAddress());

        firestoreDB = FirebaseFirestore.getInstance();


        holder.viewNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNotes(place);
            }
        });

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView address;

        public Button viewNotes;

        public ViewHolder(View view) {

            super(view);

            name = view.findViewById(R.id.name);
            address = view.findViewById(R.id.address);

            viewNotes = view.findViewById(R.id.view_notes);
        }
    }

    private void viewNotes(PlaceNotes placeNotes){
        //get notes for the selected item and display in dialog
        String str=placeNotes.getNotes();
        View v;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setTitle("Your Notes");
        alertDialogBuilder.setMessage(str);
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

}