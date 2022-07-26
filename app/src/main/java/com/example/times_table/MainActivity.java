package com.example.times_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public void generateTimesTable(int timeTableNumber){
        ArrayList<String> timeTableContents= new ArrayList<String>();
        for(int j = 1 ;j<=100; j++){
            timeTableContents.add(Integer.toString(j * timeTableNumber));
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timeTableContents);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SeekBar seekBar = findViewById(R.id.seekBar);
        listView=findViewById(R.id.listView);
        int max = 20;
        int startingPosition = 10;
        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);
        generateTimesTable(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min =1 ;
                int timeTableNumber;
                if(i < min ){
                    timeTableNumber = min ;
                    seekBar.setProgress(min);
                }
                else{
                    timeTableNumber = i ;
                }
                generateTimesTable(timeTableNumber);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}