package com.hp.major.FindUrWay;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

import java.util.ArrayList;
import java.util.regex.Pattern;


public class Login extends AppCompatActivity {
    private Button login;
    private EditText password,email;
    TextView reset,signup;

    ImageView img;
    CardView card;
    private ProgressDialog pd;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup = (TextView) findViewById(R.id.btn_signup);
        email = (EditText) findViewById(R.id.username);
        img = (ImageView) findViewById(R.id.img);


        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.btn_login);
        reset = (TextView) findViewById(R.id.btn_reset_password);
        pd = new ProgressDialog(this);
        password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.pass, 0, 0, 0);
        email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.user, 0, 0, 0);
        email.setCompoundDrawablePadding(15);
        password.setCompoundDrawablePadding(15);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }

            }
        };
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kj = new Intent(Login.this, Signup.class);
                startActivity(kj);
                finish();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kj = new Intent(Login.this, ResetPassword.class);
                startActivity(kj);
                finish();
            }
        });
    }

        @Override
            public void onStart() {
                super.onStart();
                // Check if user is signed in (non-null) and update UI accordingly.
                FirebaseUser currentUser = mAuth.getCurrentUser();
                updateUI(currentUser);
            }




            protected void username() {
                final String str, str1;
                str = email.getText().toString().trim();
                str1 = password.getText().toString().trim();

                if (email.getText().toString().trim().length() == 0) {
                    email.setError("Enter E-mail ID");
                } else if (password.getText().toString().trim().length() == 0) {
                    password.setError("Enter password");
                } else if (email.getText().toString().trim().length() != 0 && password.getText().toString().trim().length() != 0) {
                    pd.setMessage("Signing in");
                    pd.show();
                    //authenticate user
                    mAuth.signInWithEmailAndPassword(str, str1)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // If sign in fails, display a layout_chat_list to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.

                                    if (!task.isSuccessful()) {
                                        pd.dismiss();
                                        Toast.makeText(getApplicationContext(), "Wrong E-mail or password.", Toast.LENGTH_LONG).show();

                                    } else {
                                        checkIfEmailVerified();



                                    }
                                }
                            });
                }
            }

    private void checkIfEmailVerified()
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user.isEmailVerified())
        { pd.dismiss();
            // user is verified, so you can finish this activity or send user to activity which you want.
            finish();

            Toast.makeText(getApplicationContext(), "Sign in successful.", Toast.LENGTH_LONG).show();
            Intent f = new Intent(Login.this, MainActivity.class);
            startActivity(f);
        }
        else
        { pd.dismiss();
            // email is not verified, so just prompt the layout_chat_list to the user and restart this activity.
            // NOTE: don't forget to log out the user.
            Toast.makeText(getApplicationContext(), "Wrong E-mail or password.", Toast.LENGTH_LONG).show();
            FirebaseAuth.getInstance().signOut();
            user.delete()
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {

                                finish();

                            }
                        }
                    });

            //restart this activity

        }
    }



    private void updateUI(FirebaseUser user) {

        if (user != null) {
            Intent d = new Intent(Login.this, MainActivity.class);
            startActivity(d);

        } else {

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    username();
                }
            });


        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                Toast.makeText(Login.this, "Done",
                        Toast.LENGTH_LONG).show();

                AppExit();
            }
        });

        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
        Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);

        Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        pbutton.setTextColor(Color.parseColor("#FF6666"));
        nbutton.setTextColor(Color.parseColor("#FF6666"));
        nbutton.setHintTextColor(Color.BLUE);
    }
    public void AppExit()
    {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }


}

