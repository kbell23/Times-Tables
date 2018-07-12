package com.example.kevin.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // creates list view for the user to see
    ListView tableListView;

    // function to generate out table given the times table number
    public void generateTable(int timesTableNumber)
    {
        // creates the array list for the numbers to be displayed in the list view
        final ArrayList<String> numbers = new ArrayList<String>();

        // loops to add the numbers to the array list
        for(int i = 1; i <= 100; i++)
        {
            numbers.add(Integer.toString(timesTableNumber * i));
        }

        // creates the adapter and sets it to the list view
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, numbers);
        tableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableListView = (ListView)findViewById(R.id.tableListView);
        // creates seek bar for the position in the table to be shown
        final SeekBar timesTablesSeekBar = (SeekBar)findViewById(R.id.timesTablesSeekBar);

        // sets the bounds for the seekbar
        int max = 20;
        int startingPosition = 1;
        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPosition);

        // input for when the seek bar is changed
        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // bounds checking
                int min = 1;
                int timesTableNumber;
                if(progress < min){
                    timesTableNumber = min;
                    timesTablesSeekBar.setProgress(min);
                } else{
                    timesTableNumber = progress;
                }
                // generate the table
                generateTable(timesTableNumber);
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
