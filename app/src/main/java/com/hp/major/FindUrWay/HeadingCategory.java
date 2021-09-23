package com.hp.major.FindUrWay;

         
         import java.util.List;
         
         public class HeadingCategory implements ParentListItem {
     private String mName;
     private List<Heading> mMovies;
 
             public HeadingCategory(String name, List<Heading> movies) {
                 mName = name;
                 mMovies = movies;
             }
 
             public String getName() {
                 return mName;
             }
 
             @Override
     public List<?> getChildItemList() {
                 return mMovies;
             }
 
             @Override
     public boolean isInitiallyExpanded() {
                 return false;
             }
 }