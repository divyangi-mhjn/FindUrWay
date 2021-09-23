package com.hp.major.FindUrWay;

 import android.content.Intent;
 import android.os.Bundle;
         import android.support.v7.app.AppCompatActivity;
         import android.support.v7.widget.LinearLayoutManager;
         import android.support.v7.widget.RecyclerView;
 import android.support.v7.widget.Toolbar;
 import android.view.View;
 import android.widget.ImageView;
 import android.widget.Toast;
         import java.util.Arrays;
         import java.util.List;
         
         public class  FAQActivity extends AppCompatActivity{
 
             private HeadingCategoryAdapter mAdapter;
     private RecyclerView recyclerView;
     ImageView iiim;
 
             @Override
     protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_faq);

                 Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                 setSupportActionBar(toolbar);

                 toolbar.setTitle("Frequently asked questions");
                 toolbar.setNavigationIcon(R.drawable.backa);
                 setSupportActionBar(toolbar);
                 toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                         startActivity(intent);
                     }
                 });

                 iiim=(ImageView)findViewById(R.id.iiim);

         
                         Heading movie_one = new Heading("The METRO Customer card identifies you as METRO Returns Policy an authorised METRO customer. " +
                                 "You cannot gain access to a METRO centre without your card.");
                 Heading movie_two  = new Heading(" A token is a valid ticket used for single journey travel. ");
                 Heading movie_three = new Heading(" Tokens are available across all ticketing windows and Ticket Vending Machines (TVMs) at Metro stations.");
                 Heading movie_four  = new Heading("Yes, In DMRC- The maximum travel time limit is 170 Minutes for single(onward) journey. After expiry of travel time limit a penalty @ Rs 10/ per hour subject to maximum of Rs 50/- will be charged.\n" +
                         "In AMEL - The maximum travel time limit is 120 Minutes for single journey. After expiry of travel time limit a penalty @ Rs 20/ per hour subject to maximum of Rs 400/- will be charged.\n" +
                         "\n");
                 Heading movie_five = new Heading(". In DMRC- Yes, but by dropping token into exit gate slot within 20 minutes after entry. After expiry of the time limit a penalty @ Rs10/ per hour subject to maximum of Rs 50/- will be charged.\n" +
                         "In AMEL - By dropping token into exit gate slot within 30 minutes after entry. After expiry of the time limit a penalty @ Rs20/ per hour subject to maximum of Rs 400/- will be charged.\n ");
                 Heading movie_six = new Heading("Your safety and comfort are our top priority. We have strong safety features and policies in place to make your ride safe, comfortable and reliable.If you have any concerns regarding your safety, please call us and we will look into it with immediate attention.\n" +
                         "PH no. 1234567890\n");
                 Heading movie_seven = new Heading("You can check the estimated total fare for your ride by seeing the meter, mounted on the Auto Rickshaw.");
                 Heading movie_eight = new Heading("Your auto ride can accommodate 2-3 small size bags.");
                 Heading movie_nine = new Heading("You just have to enter the between location and you will get the list of buses with time in your route.");
                 Heading movie_ten = new Heading("Star Wars: Episode V - The Empire Strikes");
                 Heading movie_eleven = new Heading("Forrest Gump");
                 Heading movie_tweleve = new Heading("Inception");
         
                         HeadingCategory molvie_category_one = new HeadingCategory("What is the METRO Customer Card?", Arrays.asList(movie_one));
                 HeadingCategory molvie_category_two = new HeadingCategory("What is a token?", Arrays.asList(movie_two));
                 HeadingCategory molvie_category_three = new HeadingCategory("From where can I purchase token for travelling in Metro Trains?", Arrays.asList(movie_three));
                 HeadingCategory molvie_category_four = new HeadingCategory("Is there any time limit within which I should exit from the destination station after entering from any station?", Arrays.asList(movie_four));

                 HeadingCategory molvie_category_five = new HeadingCategory("Can I exit from the same station where I have entered?", Arrays.asList(movie_five));
                 HeadingCategory molvie_category_six = new HeadingCategory("Safety concerns? Call us!", Arrays.asList(movie_six));
                 HeadingCategory molvie_category_seven = new HeadingCategory("How can I check the total fare for my ride?", Arrays.asList(movie_seven));
                 HeadingCategory molvie_category_eight = new HeadingCategory("How much luggage can I carry in my auto ride? ", Arrays.asList(movie_eight));

                 HeadingCategory molvie_category_nine = new HeadingCategory("How I get the list of buses in my route? ", Arrays.asList(movie_nine));


                 final List<HeadingCategory> movieCategories = Arrays.asList(molvie_category_one,  molvie_category_two, molvie_category_three,molvie_category_four,molvie_category_five,  molvie_category_six, molvie_category_seven,molvie_category_eight,molvie_category_nine);
         
                         recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
                 mAdapter = new HeadingCategoryAdapter(this, movieCategories);
                 mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
             @Override
             public void onListItemExpanded(int position) {
                                 HeadingCategory expandedHeadingCategory = movieCategories.get(position);
                 

                             }
 
                     @Override
             public void onListItemCollapsed(int position) {
                                 HeadingCategory collapsedHeadingCategory = movieCategories.get(position);
                 

                             }
         });
         
                         recyclerView.setAdapter(mAdapter);
                 recyclerView.setLayoutManager(new LinearLayoutManager(this));
             }
 
             @Override
     protected void onSaveInstanceState(Bundle outState) {
                 super.onSaveInstanceState(outState);
                 mAdapter.onSaveInstanceState(outState);
             }
 
             @Override
     protected void onRestoreInstanceState(Bundle savedInstanceState) {
                 super.onRestoreInstanceState(savedInstanceState);
                 mAdapter.onRestoreInstanceState(savedInstanceState);
             }
 } 