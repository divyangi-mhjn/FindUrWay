package com.hp.major.FindUrWay;

         
         import android.content.Context;
         import android.view.LayoutInflater;
         import android.view.View;
         import android.view.ViewGroup;
         import java.util.List;
         
         public class HeadingCategoryAdapter extends ExpandableRecyclerAdapter<HeadingCategoryViewHolder, HeadingViewHolder> {
 
             private LayoutInflater mInflator;
 
             public HeadingCategoryAdapter(Context context, List<? extends ParentListItem> parentItemList) {
                 super(parentItemList);
                 mInflator = LayoutInflater.from(context);
             }
 
             @Override
     public HeadingCategoryViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
                 View movieCategoryView = mInflator.inflate(R.layout.heading_category_view, parentViewGroup, false);
                 return new HeadingCategoryViewHolder(movieCategoryView);
             }
 
             @Override
     public HeadingViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
                 View moviesView = mInflator.inflate(R.layout.heading_view, childViewGroup, false);
                 return new HeadingViewHolder(moviesView);
             }
 
             @Override
     public void onBindParentViewHolder(HeadingCategoryViewHolder headingCategoryViewHolder, int position, ParentListItem parentListItem) {
                 HeadingCategory headingCategory = (HeadingCategory) parentListItem;
                 headingCategoryViewHolder.bind(headingCategory);
             }
 
             @Override
     public void onBindChildViewHolder(HeadingViewHolder headingViewHolder, int position, Object childListItem) {
                 Heading heading = (Heading) childListItem;
                 headingViewHolder.bind(heading);
             }
 }