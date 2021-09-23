package com.hp.major.FindUrWay;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Signup extends AppCompatActivity {


    private Button signup, existing1;
    private EditText email, password,user,confirm;
    TextView name;
    ImageView img;
    private ProgressDialog pd;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth fa;
    private String regexstr="[a-zA-z]";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        signup = (Button) findViewById(R.id.sign_up_button);
        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirm=(EditText)findViewById(R.id.confirm);
        user=(EditText)findViewById(R.id.user);
        img=(ImageView)findViewById(R.id.img);
        existing1 = (Button) findViewById(R.id.sign_in_button);
        pd = new ProgressDialog(this);
        fa = FirebaseAuth.getInstance();
       


        mAuth=FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser()!= null)
                {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }

            }
        };

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username();
            }
        });

        existing1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kj=new Intent(Signup.this,Login.class);
                startActivity(kj);
                finish();
            }
        });

        password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.pass,0,0,0);
        email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.user,0,0,0);

        user.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.email,0,0,0);
        confirm.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.confirm,0,0,0);

           password.setCompoundDrawablePadding(15);
           email.setCompoundDrawablePadding(15);;
           user.setCompoundDrawablePadding(15);
           confirm.setCompoundDrawablePadding(15);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }




    protected void username() {
        String str, str1;
        str = email.getText().toString();
        str1 = password.getText().toString();

        if (email.getText().toString().length() == 0) {
            email.setError("Enter E-mail ID");
        } else if (password.getText().toString().length() == 0) {
            password.setError("Enter password");
        }
         else if(!(password.getText().toString() .equals(confirm.getText().toString())) ){
            confirm.setError("Password doesnt match");
        }

        else if (password.getText().toString().length() <6) {
            password.setError("password length minimum 6 letters");}

        else if (email.getText().toString().length() != 0 && password.getText().toString().trim().length() != 0 && password.getText().toString().equals(confirm.getText().toString())) {
            pd.setMessage("Verification link has been sent to the registered account");
            pd.show();


            fa.createUserWithEmailAndPassword(str, str1)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendVerificationEmail();


                            } else {
                                pd.dismiss();
                                email.setError("E-mail ID not valid");

                            }
                        }

                    });
        }
    }
    private void sendVerificationEmail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // email sent


                            // after email is sent just logout the user and finish this activity
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(Signup.this, Login.class));
                            finish();
                        } else {
                            // email not sent, so display layout_chat_list and restart the activity or do whatever you wish to do
                            Toast.makeText(getApplicationContext(), "Mail not verified", Toast.LENGTH_LONG).show();
                            //restart this activity
                            overridePendingTransition(0, 0);
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());

                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) {

        if (user != null) {
            Intent d = new Intent(Signup.this, MainActivity.class);
            startActivity(d);

        } else {

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    username();
                }
            });


        }
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Signup.this,Login.class);
        startActivity(intent);

    }


}
