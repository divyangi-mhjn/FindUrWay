package com.hp.major.FindUrWay;
import android.view.View;
 import android.widget.TextView;
 
         public class HeadingViewHolder extends ChildViewHolder {
 
             private TextView mMoviesTextView;
 
             public HeadingViewHolder(View itemView) {
                 super(itemView);
                 mMoviesTextView = (TextView) itemView.findViewById(R.id.tv_movies);
             }
 
             public void bind(Heading heading) {
                 mMoviesTextView.setText(heading.getName());
             }
 }

