package com.example.lum.hardhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SeekBar light1;
    private SeekBar light2;
    private SeekBar light3;
    // database
//    FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseDatabase fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        database = FirebaseDatabase.getInstance();


        light1 = (SeekBar) findViewById(R.id.light1);
        light2 = (SeekBar) findViewById(R.id.light2);
        light3 = (SeekBar) findViewById(R.id.light3);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        //System.out.print(mDatabase);
        mDatabase.child("light1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long value = dataSnapshot.getValue(Long.class);
                //int intesity = Integer.parseInt(value);
                light1.setProgress((int) value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mDatabase.child("light2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long value = dataSnapshot.getValue(Long.class);
                //int intesity = Integer.parseInt(value);
                light2.setProgress((int) value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mDatabase.child("light3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long value = dataSnapshot.getValue(Long.class);
                //int intesity = Integer.parseInt(value);
                light3.setProgress((int) value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        light1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            boolean gesture = false;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                if( gesture == false) {
                    gesture = true;
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                if(gesture) {
                    if (progressChangedValue >= 50) {
                        mDatabase.child("light1").setValue(100);
                        light1.setProgress(100);
                    } else {
                        mDatabase.child("light1").setValue(0);
                        light1.setProgress(0);
                    }
                    gesture=false;
                }
            }
        });

        light2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            boolean gesture = false;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                if( gesture == false) {
                    gesture = true;
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                if(gesture) {
                    if (progressChangedValue >= 50) {
                        mDatabase.child("light2").setValue(100);
                        light2.setProgress(100);
                    } else {
                        mDatabase.child("light2").setValue(0);
                        light2.setProgress(0);
                    }
                    gesture=false;
                }
            }
        });

        light3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            boolean gesture = false;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                if( gesture == false) {
                    gesture = true;
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                if (gesture) {
                    //mDatabase.child("light3").setValue(progressChangedValue);
                    if(progressChangedValue>=50) {
                        mDatabase.child("light3").setValue(100);
                        light3.setProgress(100);
                    } else{
                        mDatabase.child("light3").setValue(0);
                        light3.setProgress(0);
                    }
                    gesture = false;
                }
            }
        });




}


    }